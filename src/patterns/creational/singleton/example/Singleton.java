package patterns.creational.singleton.example;

public class Singleton {

    private static Singleton INSTANCE = null;

    private Singleton() {}

    public static Singleton getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }

}
