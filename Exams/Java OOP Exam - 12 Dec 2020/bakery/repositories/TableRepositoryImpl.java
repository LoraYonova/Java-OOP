package bakery.repositories;

import bakery.entities.tables.interfaces.Table;
import bakery.repositories.interfaces.TableRepository;

import java.util.ArrayList;
import java.util.Collection;


public class TableRepositoryImpl implements TableRepository<Table> {
    private Collection<Table> models;

    public TableRepositoryImpl() {
        this.models = new ArrayList<>();
    }
    @Override
    public Collection<Table> getAll() {
        return this.models;
    }

    @Override
    public void add(Table table) {
        this.models.add(table);
    }

    @Override
    public Table getByNumber(int number) {
       return models.stream().filter(n -> n.getTableNumber() == (number)).findFirst().orElse(null);

    }
}
