package glacialExpedition.repositories;

import glacialExpedition.models.explorers.BaseExplorer;
import glacialExpedition.models.explorers.Explorer;

import java.util.ArrayList;
import java.util.List;

public class ExplorerRepository implements Repository<Explorer>{
    private List<Explorer> explorers;

    public ExplorerRepository() {
        explorers = new ArrayList<>();
    }

    @Override
    public List<Explorer> getCollection() {
        return this.explorers;
    }


    @Override
    public void add(Explorer entity) {
        this.explorers.add(entity);

    }

    @Override
    public boolean remove(Explorer entity) {
        return explorers.remove(entity);
    }

    @Override
    public Explorer byName(String name) {
        return explorers.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);

    }
}
