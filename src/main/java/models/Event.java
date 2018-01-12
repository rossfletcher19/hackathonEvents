package models;

/**
 * Created by Guest on 1/12/18.
 */
public class Event {
    private String name;
    private String agenda;

    public Event (String name, String agenda) {
        this.name = name;
        this.agenda = agenda;

    }

    public String getAgenda() {
        return agenda;
    }

    public String getName() {
        return name;
    }


}
