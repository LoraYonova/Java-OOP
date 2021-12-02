package spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut {
    private static final double UNITS_OF_OXYGEN = 70;

    public Biologist(String name) {
        super(name, UNITS_OF_OXYGEN);
    }

    @Override
    public void breath() {
        super.setOxygen(super.getOxygen() - 5);
    }
}
