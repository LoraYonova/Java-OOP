package catHouse.entities.cat;

public class LonghairCat extends BaseCat {
    private static final int INITIAL_KILOGRAMS = 9;

    public LonghairCat(String name, String bread, double price) {
        super(name, bread, price);
        super.setKilograms(INITIAL_KILOGRAMS);

    }


    @Override
    public void eating() {
        setKilograms(super.getKilograms() + 3);

    }
}
