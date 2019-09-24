package patterns.behavioral.command.example;

// INVOKER
class Engine {

    // Execute
    void execute(Command command) {
        command.execute();
    }

}
