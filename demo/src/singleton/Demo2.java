package singleton;

public class Demo2 {
}


abstract class MazeFactory {
    //宣告成 protected 這樣子類別才看得到
    protected static MazeFactory uniqueInstance = null;
    protected int data = 0;

    //藏起來不讓外界的呼叫。但因為有子類別，不能宣告為 private
    protected MazeFactory() {
    }

    // Return a reference to the single instance.
    public static MazeFactory instance() {
        return uniqueInstance;
    }

    public int getData() {
        return this.data;
    }

    public void setData(int d) {
        this.data = d;
    }
}

class EnchantedMazeFactory extends MazeFactory {
    private EnchantedMazeFactory() {
    }

    //參考到父類別的 uniqueInstance
    public static MazeFactory instance() {
        if (uniqueInstance == null) uniqueInstance = new EnchantedMazeFactory();
        return uniqueInstance;
    }
}

class AgentMazeFactory extends MazeFactory {
    private AgentMazeFactory() {
    }

    //同樣的參考到父類別的 uniqueInstance
    public static MazeFactory instance() {
        if (uniqueInstance == null) uniqueInstance = new AgentMazeFactory();
        return uniqueInstance;
    }
}