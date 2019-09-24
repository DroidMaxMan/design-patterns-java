package patterns.behavioral.command.example;

public class Sample {

    public static void main(String[] args) {
        // Receiver
        Character character = new Character();

        // Invoker
        Engine engine = new Engine();

        // Executing commands
        engine.execute(new Jump(character));
        engine.execute(new Run(character));
        engine.execute(new Walk(character));
    }

}
