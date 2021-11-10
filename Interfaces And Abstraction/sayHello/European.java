package interfacesAndAbstraction.sayHello;

public class European implements Person{
    String name;
    String sayHello;

    public European(String name) {
        this.name = name;
        this.sayHello = sayHello();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}
