package glacialExpedition.models.mission;

import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.states.State;
import glacialExpedition.models.suitcases.Suitcase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MissionImpl implements Mission {

    @Override
    public void explore(State state, Collection<Explorer> explorers) {
        Collection<String> exhibits = state.getExhibits();
        List<String> deleteExhibits = new ArrayList<>();
        for (Explorer explorer : explorers) {

            for (String exhibit : exhibits) {
                if (explorer.canSearch()) {
                    explorer.getSuitcase().getExhibits().add(exhibit);

                    deleteExhibits.add(exhibit);
                    explorer.search();

                } else {
                    break;
                }
            }
            exhibits.removeAll(deleteExhibits);
            deleteExhibits.clear();
        }


    }




}
