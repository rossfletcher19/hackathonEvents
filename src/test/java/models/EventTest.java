package models;

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

}