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

            get("/", (request, response) -> {
                Map<String, Object> model = new HashMap<String, Object>();
                return new ModelAndView(model, "index.hbs");
            }, new HandlebarsTemplateEngine());

            post("/events/new", (request, response) -> { //URL to make new post on POST route
                Map<String, Object> model = new HashMap<String, Object>();
                String name = request.queryParams("name");
                String agenda = request.queryParams("agenda");
                Event newEvent = new Event(name, agenda);
                return new ModelAndView(model, "success.hbs");
            }, new HandlebarsTemplateEngine());

        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Event> events = Event.getAll();
            model.put("events", events);

            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());


        }
}
