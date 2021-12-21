package catHouse.entities.cat;

public class ShorthairCat extends BaseCat {
        private static final int INITIAL_KILOGRAMS = 7;

    public ShorthairCat(String name, String bread, double price) {
        super(name, bread, price);
        setKilograms(INITIAL_KILOGRAMS);
    }

    @Override
    public void eating() {
        super.setKilograms(super.getKilograms() + 1);

    }
}
