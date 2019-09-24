package patterns.other.reactor.example;

class ConcreteEventHandler implements EventHandler {

    @Override
    public void handle(Event event) {
        event.getInfo();
    }

}
