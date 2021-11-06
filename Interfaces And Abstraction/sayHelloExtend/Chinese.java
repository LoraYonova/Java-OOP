package interfacesAndAbstraction.sayHelloExtend;

public class Chinese extends BasePerson{
    String sayHello;
    public Chinese(String name) {
        super(name);
        this.sayHello = sayHello();
    }

    @Override
    public String sayHello() {
        return "Djydjybydjy";
    }
}
