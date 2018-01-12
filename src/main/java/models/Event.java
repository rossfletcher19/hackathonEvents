package models;

import java.util.ArrayList;

/**
 * Created by Guest on 1/12/18.
 */
public class Event {
    private String name;
    private String agenda;
    private static ArrayList<Event> instances = new ArrayList<>();

    public Event (String name, String agenda) {
        this.name = name;
        this.agenda = agenda;
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


}
