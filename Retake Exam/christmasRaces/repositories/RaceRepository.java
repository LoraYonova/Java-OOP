package christmasRaces.repositories;

import christmasRaces.entities.races.Race;
import christmasRaces.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;

public class RaceRepository implements Repository<Race> {
    private Collection<Race> model;

    public RaceRepository() {
        this.model = new ArrayList<>();
    }

    @Override
    public Race getByName(String name) {
        return this.model.stream().filter(n -> n.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Collection<Race> getAll() {
        return this.model;
    }

    @Override
    public void add(Race model) {
        this.model.add(model);
    }

    @Override
    public boolean remove(Race model) {
        return this.model.remove(model);
    }
}
