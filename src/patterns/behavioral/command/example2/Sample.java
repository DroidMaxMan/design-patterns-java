package patterns.behavioral.command.example2;

class Sample {

    public static void main(String[] args) {
        Receiver intendedreceiver = new Receiver();

        Undo unCmd = new Undo(intendedreceiver);
        Redo reCmd = new Redo(intendedreceiver);

        /*Client holds Invoker and Command Objects*/
        Invoker inv = new Invoker();
        inv.execute(unCmd);
        inv.execute(reCmd);
    }

}
