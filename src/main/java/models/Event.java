package models;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Created by Guest on 1/12/18.
 */
public class Event {
    private String name;
    private String agenda;
    private static ArrayList<Event> instances = new ArrayList<>();
    private boolean addedEvents;
    private LocalDateTime createdAt;

    public Event (String name, String agenda) {
        this.name = name;
        this.agenda = agenda;
        this.addedEvents = false;
        this.createdAt = LocalDateTime.now();
        instances.add(this);

    }

    public String getAgenda() {
        return agenda;
    }

    public String getName() {
        return name;
    }

    public static ArrayList<Event> getAll(){
        return instances;
    }

    public static void clearAllEvents(){
        instances.clear();
    }

    public boolean getAddedEvents() {
        return this.addedEvents;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }


}
