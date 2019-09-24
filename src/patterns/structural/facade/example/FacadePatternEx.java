package patterns.structural.facade.example;

public class FacadePatternEx {

    public static void main(String[] args) {
        Facade facade = new Facade();

        System.out.println(facade.getInfoA());
        System.out.println(facade.getInfoB());
        System.out.println(facade.getInfoC());
    }

}
