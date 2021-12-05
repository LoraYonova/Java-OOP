package bakery.repositories;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.repositories.interfaces.FoodRepository;


import java.util.ArrayList;
import java.util.Collection;


public class FoodRepositoryImpl implements FoodRepository<BakedFood> {
    private Collection<BakedFood> models;

    public FoodRepositoryImpl() {
        this.models = new ArrayList<>();
    }

    @Override
    public BakedFood getByName(String name) {
        return models.stream().filter(n -> n.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Collection<BakedFood> getAll() {
        return this.models;
    }

    @Override
    public void add(BakedFood bakedFood) {
        this.models.add(bakedFood);
    }
}
