import java.util.List;
import java.util.ArrayList;

public class Squad {
  private String mName;
  private int mId;
  private String mCause;
  private int mSize;
  private List<Hero> mHeros;

  public Squad(String name, String cause, int size, int id) {
    mName = name;
    mCause = cause;
    mSize = size;
    mId = id;
    mHeros = new ArrayList<Hero>();
  }
  public String getName() {
    return mName;
  }
  public String getCause() {
    return mCause;
  }
  public int getSize() {
    return mSize;
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
}
