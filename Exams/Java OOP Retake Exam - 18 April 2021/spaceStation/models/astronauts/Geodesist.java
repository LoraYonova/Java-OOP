package spaceStation.models.astronauts;

public class Geodesist extends BaseAstronaut {
    private static final double UNITS_OF_OXYGEN = 50;

    public Geodesist(String name) {
        super(name, UNITS_OF_OXYGEN);
    }
}
