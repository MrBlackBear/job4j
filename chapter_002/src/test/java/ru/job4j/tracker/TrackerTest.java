package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * TrackerTest.
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class TrackerTest {
    /**
     * Test add.
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll().get(0), is(item));
    }

    /**
     * Test replace.
     */
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2");
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    /**
     * Test findAll.
     */
    @Test
    public void whenFindAllThreeElementsThenLengthISThree() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription", 123L);
        Item second = new Item("test2", "testDescription2", 1234L);
        Item third = new Item("test3", "testDescription2", 12345L);
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        ArrayList<Item> result = tracker.findAll();
        assertThat(result.size(), is(3));
    }

    /**
     * Test delete.
     */
    @Test
    public void whenDeleteItemThenReturnArrayWithoutIt() {
        Tracker actual = new Tracker();
        Tracker result = new Tracker();
        Item first = new Item("test1", "testDescription", 123L);
        Item second = new Item("test2", "testDescription2", 1234L);
        Item third = new Item("test3", "testDescription2", 12345L);
        Item fourth = new Item("test4", "testDescription2", 12346L);
        Item fifth = new Item("test5", "testDescription2", 12347L);
        actual.add(first);
        actual.add(second);
        actual.add(third);
        actual.add(fourth);
        actual.add(fifth);
        result.add(first);
        result.add(second);
        result.add(fourth);
        result.add(fifth);
        actual.delete(third.getId());
        assertTrue(actual.findAll().equals(result.findAll()));
    }

    /**
     * Test findById.
     */
    @Test
    public void whenFindIdThenTrue() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription", 123L);
        Item second = new Item("test2", "testDescription2", 1234L);
        Item third = new Item("test3", "testDescription2", 12342L);
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        assertThat(tracker.findById(second.getId()).getName(), is("test2"));
    }

    /**
     * Test findByName.
     */
    @Test
    public void whenFindByNameTwoElementThenReturnTrackerWithLengthTwo() {
        Tracker result = new Tracker();
        Item first = new Item("test1", "testDescription", 123L);
        Item second = new Item("test2", "testDescription2", 1234L);
        Item third = new Item("test2", "testDescription2", 12345L);
        Item fourth = new Item("test4", "testDescription2", 12346L);
        Item fifth = new Item("test5", "testDescription2", 12347L);
        result.add(first);
        result.add(second);
        result.add(third);
        result.add(fourth);
        result.add(fifth);
        assertThat(result.findByName("test2").size(), is(2));
    }
}
