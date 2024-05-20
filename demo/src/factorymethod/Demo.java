package factorymethod;

public class Demo {
}

abstract class Creator {
    Product p;

    public void doSomething() {
        p = factoryMethod();
    }

    public abstract Product factoryMethod();
}

class ConcreteCreator extends Creator {
    public Product factoryMethod() {
        return new ConcreteProduct();
    }
}

abstract class Product {
    abstract void operation();
}

class ConcreteProduct extends Product {
    void operation() {
        System.out.println("Concrete product is created");
    }
}
