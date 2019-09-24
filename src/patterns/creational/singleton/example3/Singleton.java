package patterns.creational.singleton.example3;

public class Singleton {

    // Early initialization
    private static Singleton INSTANCE = new Singleton();

    private Singleton() {}

    public static Singleton getInstance() {
        return INSTANCE;
    }

}
