import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import models.Event;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) { //type “psvm + tab” to autocreate this :)
        staticFileLocation("/public");

            get("/", (req, res) -> {
                Map<String, Object> model = new HashMap<>();
                ArrayList<Event> events = Event.getAll();
                model.put("events", events);
                return new ModelAndView(model, "index.hbs");
            }, new HandlebarsTemplateEngine());

            get("/events/new", (req, res) -> {
                Map<String, Object> model = new HashMap<>();
                return new ModelAndView(model, "newevent-form.hbs");
            }, new HandlebarsTemplateEngine());

            post("/events/new", (request, response) -> { //URL to make new post on POST route
                Map<String, Object> model = new HashMap<>();
                String name = request.queryParams("name");
                String agenda = request.queryParams("agenda");
                Event newEvent = new Event(name, agenda);
                return new ModelAndView(model, "success.hbs");
            }, new HandlebarsTemplateEngine());

            get("/events/delete", (req, res) -> {
                Map<String, Object> model = new HashMap<>();
                Event.clearAllEvents();
                return new ModelAndView(model, "success2.hbs");
            }, new HandlebarsTemplateEngine());

            get("/events/:id", (req, res) -> {
                Map<String, Object> model = new HashMap<>();
                int idOfEventToFind = Integer.parseInt(req.params("id")); //pull id - must match route segment
                Event foundEvent = Event.findById(idOfEventToFind); //use it to find event
                model.put("event", foundEvent); //add it to model for template to display
                return new ModelAndView(model, "event-detail.hbs"); //individual event page.
            }, new HandlebarsTemplateEngine());

            get("/events/:id/update", (req, res) -> {
                Map<String, Object> model = new HashMap<>();
                int idOfEventToEdit = Integer.parseInt(req.params("id"));
                Event editEvent = Event.findById(idOfEventToEdit);
                model.put("editEvent", editEvent);
                return new ModelAndView(model, "newevent-form.hbs");
            }, new HandlebarsTemplateEngine());

            post("/events/:id/update", (req, res) -> {
                Map<String, Object> model = new HashMap<>();
                String newAgenda = req.queryParams("agenda");
                int idOfEventToEdit = Integer.parseInt(req.params("id"));
                Event editEvent = Event.findById(idOfEventToEdit);
                editEvent.update(newAgenda); //don’t forget me
                return new ModelAndView(model, "success.hbs");
            }, new HandlebarsTemplateEngine());

            get("/events/:id/delete", (req, res) -> {
                Map<String, Object> model = new HashMap<>();
                int idOfEventToDelete = Integer.parseInt(req.params("id")); //pull id - must match route segment
                Event deleteEvent = Event.findById(idOfEventToDelete); //use it to find post
                deleteEvent.deleteEvent();
                return new ModelAndView(model, "success.hbs");
            }, new HandlebarsTemplateEngine());








        }
}
