package models;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Guest on 1/12/18.
 */
public class EventTest {

    @Test
    public void NewEventObjectInstantiatesCorrectly_true() throws Exception {
        Event event = new Event("Coding and Hackathon Event");
        assertEquals(true, event instanceof Event);
    }

}