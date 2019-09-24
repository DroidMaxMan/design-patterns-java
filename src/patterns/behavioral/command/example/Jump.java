package patterns.behavioral.command.example;

class Jump implements Command {

    private Character character;

    Jump(Character character) {
        this.character = character;
    }

    @Override
    public void execute() {
        character.jump();
    }

}
