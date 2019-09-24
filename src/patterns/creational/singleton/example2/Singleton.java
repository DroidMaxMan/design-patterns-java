package patterns.creational.singleton.example2;

public class Singleton {

    private static Singleton INSTANCE = null;

    private Singleton() {}

    private static synchronized void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton();
        }
    }

    public static Singleton getInstance() {
        if (INSTANCE == null) {
            createInstance();
        }
        return INSTANCE;
    }

}
