package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
                        new StringBuilder()
                                .append("Меню.")
                                .append(System.lineSeparator())
                                .append("0. Add new Item")
                                .append(System.lineSeparator())
                                .append("1. Show all items")
                                .append(System.lineSeparator())
                                .append("2. Edit item")
                                .append(System.lineSeparator())
                                .append("3. Delete item")
                                .append(System.lineSeparator())
                                .append("4. Find item by Id")
                                .append(System.lineSeparator())
                                .append("5. Find items by name")
                                .append(System.lineSeparator())
                                .append("6. Exit Program")
                                .append(System.lineSeparator())
                                .append("------------ Показывает все элементы --------------")
                                .append(System.lineSeparator())
                                .append("------------ Заявка с getId : " + item.getId() + "-----------")
                                .append(System.lineSeparator())
                                .append("------------ Заявка с getId : " + item1.getId() + "-----------")
                                .append(System.lineSeparator())
                                .append("------------ Заявка с getId : " + item2.getId() + "-----------")
                                .append(System.lineSeparator())
                                .append("Меню.")
                                .append(System.lineSeparator())
                                .append("0. Add new Item")
                                .append(System.lineSeparator())
                                .append("1. Show all items")
                                .append(System.lineSeparator())
                                .append("2. Edit item")
                                .append(System.lineSeparator())
                                .append("3. Delete item")
                                .append(System.lineSeparator())
                                .append("4. Find item by Id")
                                .append(System.lineSeparator())
                                .append("5. Find items by name")
                                .append(System.lineSeparator())
                                .append("6. Exit Program")
                                .append(System.lineSeparator())
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
                        new StringBuilder()
                                .append("Меню.")
                                .append(System.lineSeparator())
                                .append("0. Add new Item")
                                .append(System.lineSeparator())
                                .append("1. Show all items")
                                .append(System.lineSeparator())
                                .append("2. Edit item")
                                .append(System.lineSeparator())
                                .append("3. Delete item")
                                .append(System.lineSeparator())
                                .append("4. Find item by Id")
                                .append(System.lineSeparator())
                                .append("5. Find items by name")
                                .append(System.lineSeparator())
                                .append("6. Exit Program")
                                .append(System.lineSeparator())
                                .append("------------ Нахождение заявки --------------")
                                .append(System.lineSeparator())
                                .append("------------ Id заявки : " + item2.getId() + "-----------")
                                .append(System.lineSeparator())
                                .append("------------ Имя заявки : " + item2.getName() + "-----------")
                                .append(System.lineSeparator())
                                .append("------------ Описание заявки : " + item2.getDescription() + "-----------")
                                .append(System.lineSeparator())
                                .append("Меню.")
                                .append(System.lineSeparator())
                                .append("0. Add new Item")
                                .append(System.lineSeparator())
                                .append("1. Show all items")
                                .append(System.lineSeparator())
                                .append("2. Edit item")
                                .append(System.lineSeparator())
                                .append("3. Delete item")
                                .append(System.lineSeparator())
                                .append("4. Find item by Id")
                                .append(System.lineSeparator())
                                .append("5. Find items by name")
                                .append(System.lineSeparator())
                                .append("6. Exit Program")
                                .append(System.lineSeparator())
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
                        new StringBuilder()
                                .append("Меню.")
                                .append(System.lineSeparator())
                                .append("0. Add new Item")
                                .append(System.lineSeparator())
                                .append("1. Show all items")
                                .append(System.lineSeparator())
                                .append("2. Edit item")
                                .append(System.lineSeparator())
                                .append("3. Delete item")
                                .append(System.lineSeparator())
                                .append("4. Find item by Id")
                                .append(System.lineSeparator())
                                .append("5. Find items by name")
                                .append(System.lineSeparator())
                                .append("6. Exit Program")
                                .append(System.lineSeparator())
                                .append("------------ Нахождение заявок по имени --------------")
                                .append(System.lineSeparator())
                                .append("------------ Заявка с getId : " + item.getId() + "-----------")
                                .append(System.lineSeparator())
                                .append("------------ Заявка с getId : " + item2.getId() + "-----------")
                                .append(System.lineSeparator())
                                .append("Меню.")
                                .append(System.lineSeparator())
                                .append("0. Add new Item")
                                .append(System.lineSeparator())
                                .append("1. Show all items")
                                .append(System.lineSeparator())
                                .append("2. Edit item")
                                .append(System.lineSeparator())
                                .append("3. Delete item")
                                .append(System.lineSeparator())
                                .append("4. Find item by Id")
                                .append(System.lineSeparator())
                                .append("5. Find items by name")
                                .append(System.lineSeparator())
                                .append("6. Exit Program")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }


}
