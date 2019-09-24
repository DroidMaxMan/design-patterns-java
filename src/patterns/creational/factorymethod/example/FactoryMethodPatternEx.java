package patterns.creational.factorymethod.example;

public class FactoryMethodPatternEx {

    public static void main(String[] args) {
        Creator creatorA = new ConcreteCreatorA();
        Product productA = creatorA.factoryMethod();

        Creator creatorB = new ConcreteCreatorB();
        Product productB = creatorB.factoryMethod();

        productA.operacion();
        productB.operacion();
    }

}
