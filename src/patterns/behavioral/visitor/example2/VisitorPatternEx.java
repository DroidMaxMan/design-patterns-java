package patterns.behavioral.visitor.example2;

class VisitorPatternEx {

    public static void main(String[] args) {
        IVisitor v = new Visitor();
        MyClass myClass = new MyClass();
        myClass.accept(v);
    }

}
