package interfacesAndAbstraction.sayHelloExtend;

public class European extends BasePerson{
    String sayHello;

    public European(String name) {
        super(name);
        this.sayHello = sayHello();
    }
    @Override
    public String sayHello() {
        return "Hello";
    }
}
