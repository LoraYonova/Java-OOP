package glacialExpedition.models.states;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import static glacialExpedition.common.ExceptionMessages.STATE_NAME_NULL_OR_EMPTY;

public class StateImpl implements State {
    private String name;
    private List<String> exhibits;

    public StateImpl(String name) {
       setName(name);
       this.exhibits = new ArrayList<>();

    }


    @Override
    public List<String> getExhibits() {
        return this.exhibits;

    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(STATE_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
