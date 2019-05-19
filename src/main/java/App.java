import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.Map;

public class App {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("heros/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/heros-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("heros", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("heros", Hero.all());
      model.put("template", "templates/heros.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("heros", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String name = request.queryParams("name");
      String age = request.queryParams("age");
      String power = request.queryParams("power");
      String weakness = request.queryParams("weakness");
      Hero newHero = new Hero(name);
      Hero newHero = new Hero(age);
      Hero newHero = new Hero(power);
      Hero newHero = new Hero(weakness);
      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


  }
}
