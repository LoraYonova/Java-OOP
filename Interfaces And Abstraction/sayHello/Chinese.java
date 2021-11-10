package interfacesAndAbstraction.sayHello;

public class Chinese implements Person{
    String name;
    String sayHello;

    public Chinese(String name) {
        this.name = name;
        this.sayHello = sayHello();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String sayHello() {
        return "Djydjybydjy";
    }
}
