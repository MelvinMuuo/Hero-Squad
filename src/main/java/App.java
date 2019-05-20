import java.util.HashMap;
import spark.ModelAndView;
import java.util.Map;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";
    staticFileLocation("/public");

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/heros", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String name = request.queryParams("name");
      String age = request.queryParams("age");
      String power = request.queryParams("power");
      String weakness = request.queryParams("weakness");
      Hero newHero = new Hero(name, age, power, weakness);
      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/squads/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/squad-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/squads", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String name = request.queryParams("name");
      String cause = request.queryParams("cause");
      Squad newSquad = new Squad(name, cause);
      model.put("template", "templates/squad-success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/squads", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("squads", Squad.all());
      model.put("template", "templates/squads.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/squads/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Squad squad= Squad.find(Integer.parseInt(request.params(":id")));
      model.put("squad", squad);
      model.put("template", "templates/squad.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("squads/:id/heros/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Squad squad= Squad.find(Integer.parseInt(request.params(":id")));
      model.put("squad", squad);
      model.put("template", "templates/squad-heros-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/heros", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Squad squad = Squad.find(Integer.parseInt(request.queryParams("squadId")));
      String name = request.queryParams("name");
      String age = request.queryParams("age");
      String power = request.queryParams("power");
      String weakness = request.queryParams("weakness");
      Hero newHero = new Hero(name, age, power, weakness);
      squad.addHero(newHero);
      model.put("squad", squad);
      model.put("template", "templates/squad-heros-success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/heros", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("heros", Hero.all());
      model.put("template", "templates/heros.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/heros/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Hero hero=Hero.find(Integer.parseInt(request.params(":id")));
      model.put("hero", hero);
      model.put("template", "templates/hero.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


  }
}
