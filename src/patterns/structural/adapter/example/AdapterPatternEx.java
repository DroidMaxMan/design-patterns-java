package patterns.structural.adapter.example;

public class AdapterPatternEx {

    public static void main(String[] args) {
        Target target = new patterns.structural.adapter.example.Adapter();
        System.out.println("Método adaptado: " + target.method());
    }

}
