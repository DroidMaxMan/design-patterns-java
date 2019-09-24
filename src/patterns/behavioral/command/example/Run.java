package patterns.behavioral.command.example;

class Run implements Command {

    private Character character;

    Run(Character character) {
        this.character = character;
    }

    @Override
    public void execute() {
        character.run();
    }

}
