package models;

import org.junit.After;
import org.junit.Test;

import java.time.LocalDateTime;

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

    @Test
    public void getAddedEvents_isFalseAfterInstantiation_false() throws Exception {
        Event event = new Event("Java Lecture", "Classes and Objects in Java");
        assertEquals(false, event.getAddedEvents());
    }

    @Test
    public void getCreatedAt_instantiatesWithCurrentTime_today() throws Exception {
        Event event = setupNewEvent();
        assertEquals(LocalDateTime.now().getDayOfWeek(), event.getCreatedAt().getDayOfWeek());
    }

    public Event setupNewEvent() {
        return new Event("Java Lecture", "Classes and Objects in Java");
    }

    @Test
    public void getId_eventsInstantiateWithID_1() throws Exception {
        Event.clearAllEvents();
        Event event = new Event("Java Lecture", "Classes and Objects in Java");
        assertEquals(1, event.getId());
    }

    @Test
    public void findReturnsCorrectEvent() throws Exception {
        Event event = setupNewEvent();
        assertEquals(1, Event.findById(event.getId()).getId());
    }

    @Test
    public void findReturnsCorrectEventWhenMultipleEventsExists() throws Exception {
        Event event = setupNewEvent();
        Event otherEvent = new Event("Java Lecture", "Classes and Objects in Java");
        assertEquals(2, Event.findById(otherEvent.getId()).getId());
    }

    @Test
    public void updateChangesEventAgenda() throws Exception {
        Event event = setupNewEvent();
        String formerAgenda = event.getAgenda();
        LocalDateTime formerDate = event.getCreatedAt();
        int formerId = event.getId();

        event.update("Classes and Objects in Java");
        assertEquals(formerId, event.getId());
        assertEquals(formerDate, event.getCreatedAt());
        assertEquals(formerAgenda, event.getAgenda());
        
    }

}