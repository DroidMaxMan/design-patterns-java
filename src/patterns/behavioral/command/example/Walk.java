package patterns.behavioral.command.example;

class Walk implements Command {

    private Character character;

    Walk(Character character) {
        this.character = character;
    }

    @Override
    public void execute() {
        character.walk();
    }

}
