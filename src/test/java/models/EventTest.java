package models;

import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Guest on 1/12/18.
 */
public class EventTest {

    @Test
    public void NewEventObjectInstantiatesCorrectly_true() throws Exception {
        Event event = new Event("Java Lecture", "Classes and Objects in Java");
        assertEquals(true, event instanceof Event);
    }

    @Test
    public void EventInstantiatesWithAgenda_true() throws Exception {
        Event event = new Event("Java Lecture", "Classes and Objects in Java");
        assertEquals("Java Lecture", event.getName());
    }

    @Test
    public void EventInstantiatesWithEventName_true() throws Exception {
        Event event = new Event("Java Lecture", "Classes and Objects in Java");
        assertEquals("Classes and Objects in Java", event.getAgenda());
    }

    @After
    public void tearDown() {
        Event.clearAllEvents(); //clear out all the events before each test.
    }

    @Test
    public void AllPostsAreCorrectlyReturned_true() {
        Event event = new Event("Java Lecture", "Classes and Objects in Java");
        Event otherEvent = new Event("How to pair successfully", "Learn the dos and donts of pairing");
        assertEquals(2, Event.getAll().size());
    }

    @Test
    public void AllPostsContainsAllPosts_true() {
        Event event = new Event("Java Lecture", "Classes and Objects in Java");
        Event otherEvent = new Event("How to pair successfully", "Learn the dos and donts of pairing");
        assertTrue(Event.getAll().contains(event));
        assertTrue(Event.getAll().contains(otherEvent));
    }

}