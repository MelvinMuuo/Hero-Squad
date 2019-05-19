import org.junit.*;
import static org.junit.Assert.*;

public class HeroTest {
  @Test
  public void Hero_instantiatesCorrectly_true() {
    Hero myHero = new Hero("superman", "18", "Aqua Strength", "women");
    assertEquals(true, myHero instanceof Hero);

  }

}
