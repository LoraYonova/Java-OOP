package interfacesAndAbstraction.sayHello;

public class Bulgarian implements Person{
    String name;
    String sayHello;

    public Bulgarian(String name) {
        this.name = name;
        this.sayHello = sayHello();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String sayHello() {
        return "Здравей";
    }
}

