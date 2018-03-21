package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * StartUITest.
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class StartUITest {

    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    /**
     * Test add.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    /**
     * Test update.
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item());
        Input input = new StubInput(new String[]{"2", item.getId(), "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }

    /**
     * Test delete.
     */
    @Test
    public void whenDeleteThenTrackerHasTwoValues() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item());
        tracker.add(new Item());
        tracker.add(new Item());
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().length, is(2));
    }

    /**
     * Test showAll.
     */
    @Test
    public void showAll() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item());
        Item item1 = tracker.add(new Item());
        Item item2 = tracker.add(new Item());
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()),
                is(
                        new StringJoiner(System.lineSeparator())
                                .add("0. Add new Item")
                                .add("1. Show all items")
                                .add("2. Edit item")
                                .add("3. Delete item")
                                .add("4. Find item by Id")
                                .add("5. Find items by name")
                                .add("------------ Показывает все элементы --------------")
                                .add(String.format("------------ Заявка с getId : %s-----------", item.getId()))
                                .add(String.format("------------ Заявка с getId : %s-----------", item1.getId()))
                                .add(String.format("------------ Заявка с getId : %s-----------", item2.getId()))
                                .add("")
                                .toString()
                )
        );
    }

    /**
     * Test findItemById.
     */
    @Test
    public void findItemById() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item());
        Item item1 = tracker.add(new Item());
        Item item2 = tracker.add(new Item("test name", "test desc"));
        Input input = new StubInput(new String[]{"4", item2.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()),
                is(
                        new StringJoiner(System.lineSeparator())
                                .add("0. Add new Item")
                                .add("1. Show all items")
                                .add("2. Edit item")
                                .add("3. Delete item")
                                .add("4. Find item by Id")
                                .add("5. Find items by name")
                                .add("------------ Нахождение заявки --------------")
                                .add(String.format("------------ Id заявки : %s-----------", item2.getId()))
                                .add(String.format("------------ Имя заявки : %s-----------", item2.getName()))
                                .add(String.format("------------ Описание заявки : %s-----------", item2.getDescription()))
                                .add("")
                                .toString()
                )
        );
    }

    /**
     * Test find items by name
     */
    @Test
    public void findItemsByName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "awa"));
        Item item1 = tracker.add(new Item("asas", "des"));
        Item item2 = tracker.add(new Item("test name", "test desc"));
        Input input = new StubInput(new String[]{"5", "test name", "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()),
                is(
                        new StringJoiner(System.lineSeparator())
                                .add("0. Add new Item")
                                .add("1. Show all items")
                                .add("2. Edit item")
                                .add("3. Delete item")
                                .add("4. Find item by Id")
                                .add("5. Find items by name")
                                .add("------------ Нахождение заявок по имени --------------")
                                .add(String.format("------------ Заявка с getId : %s-----------", item.getId()))
                                .add(String.format("------------ Заявка с getId : %s-----------", item2.getId()))
                                .add("")
                                .toString()
                )
        );
    }


}
