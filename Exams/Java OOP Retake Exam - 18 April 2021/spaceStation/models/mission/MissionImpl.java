package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class MissionImpl implements Mission {


    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {
        List<String> planetItems = new ArrayList<>(planet.getItems());
        List<Astronaut> astronautList = new ArrayList<>(astronauts);

        for (Astronaut astronaut : astronautList) {
            for (int i = 0; i < planetItems.size() ; i++) {
                if (!astronaut.canBreath()) {
                    break;
                }
                astronaut.getBag().getItems().add(planetItems.get(i));
                astronaut.breath();
                planetItems.remove(planetItems.get(i));
                i--;

            }

        }
    }

}