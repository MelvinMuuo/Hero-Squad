import java.util.List;
import java.util.ArrayList;

public class Squad {
  private String mName;
  private static List<Squad> instances = new ArrayList<Squad>();
  private int mId;
  private String mCause;
  private int mSize;
  private List<Hero> mHeros;

  public Squad(String name, String cause) {
    mName = name;
    mCause = cause;
    instances.add(this);
    mId = instances.size();
    mHeros = new ArrayList<Hero>();
  }
  public String getName() {
    return mName;
  }
  public static Squad find(int id) {
    return instances.get(id - 1);
  }
  public static List<Squad> all() {
    return instances;
  }
  public String getCause() {
    return mCause;
  }
  public int getId() {
    return mId;
  }
  public List<Hero> getHeros() {
    return mHeros;
  }
  public void addHero(Hero hero){
    mHeros.add(hero);
  }
  public static void clear() {
    instances.clear();
  }
}
