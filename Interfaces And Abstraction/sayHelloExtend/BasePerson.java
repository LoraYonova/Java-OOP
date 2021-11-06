package interfacesAndAbstraction.sayHelloExtend;

public abstract class BasePerson implements Person{
    private String name;

    protected BasePerson(String name) {
        this.name = name;
    }

   // protected abstract String setName();

    @Override
    public String getName() {
        return name;
    }


}
