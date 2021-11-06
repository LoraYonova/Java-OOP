package interfacesAndAbstraction.sayHelloExtend;

public class Bulgarian extends BasePerson{

    String sayHello;

    public Bulgarian(String name) {
        super(name);
        this.sayHello = sayHello();
    }



    @Override
    public String sayHello() {
        return "Здравей";
    }
}
