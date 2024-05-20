package adapter;

public class Demo1 {
    public static void main(String[] args) {
        Target t = new Adapter(new Adaptee());
        doIt(t);
    }

    private static void doIt(Target target) {
        target.request(100);
    }
}

class Target {
    public void request(Object arg) {
        System.out.println("This is request in target");
    }
}

class Adapter extends Target {
    Adaptee adaptee;

    public Adapter(Adaptee a) {
        this.adaptee = a;
    }

    public void request(Object arg) {
        adaptee.specificRequest(arg);
    }
}

class Adaptee {
    public void specificRequest(Object arg) {
        System.out.println("This is specific request in adaptee");
    }
}