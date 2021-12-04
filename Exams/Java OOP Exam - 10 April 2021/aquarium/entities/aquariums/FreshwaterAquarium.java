package aquarium.entities.aquariums;

public class FreshwaterAquarium extends BaseAquarium {
    private static final int CAPACITY_FRESHWATER_AQUARIUM = 50;
    public static final String AQUARIUM_TYPE_CONST = "FreshwaterAquarium";

    public FreshwaterAquarium(String name) {
        super(name, CAPACITY_FRESHWATER_AQUARIUM);
    }
    @Override
    public String getInfo() {

        return String.format("%s (%s):", super.getName(), AQUARIUM_TYPE_CONST) +
                System.lineSeparator() +
                super.getInfo();
    }

}
