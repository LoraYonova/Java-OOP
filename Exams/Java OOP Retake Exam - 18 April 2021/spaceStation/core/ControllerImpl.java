package spaceStation.core;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;
import spaceStation.models.astronauts.Geodesist;
import spaceStation.models.astronauts.Meteorologist;
import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static spaceStation.common.ConstantMessages.*;
import static spaceStation.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private Astronaut astronaut;
    private Planet planet;
    private AstronautRepository astronautRepository;
    private PlanetRepository planetRepository;
    private Mission mission;
    private int countExploredPlanet;


    public ControllerImpl() {
        this.astronautRepository = new AstronautRepository();
        this.planetRepository = new PlanetRepository();
        this.mission = new MissionImpl();
    }

    @Override
    public String addAstronaut(String type, String astronautName) {

        if (type.equals("Biologist")) {
            astronaut = new Biologist(astronautName);
        } else if (type.equals("Geodesist")) {
            astronaut = new Geodesist(astronautName);
        } else if (type.equals("Meteorologist")) {
            astronaut = new Meteorologist(astronautName);
        } else {
            throw new IllegalArgumentException(ASTRONAUT_INVALID_TYPE);
        }

        astronautRepository.add(astronaut);
        return String.format(ASTRONAUT_ADDED, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        planet = new PlanetImpl(planetName);

            for (String item : items) {
                planet.getItems().add(item);
            }

        planetRepository.add(planet);

        return String.format(PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut name = astronautRepository.findByName(astronautName);

        if (name == null) {
            throw new IllegalArgumentException(String.format(ASTRONAUT_DOES_NOT_EXIST, astronautName));
        }
        astronautRepository.remove(name);

        return String.format(ASTRONAUT_RETIRED, astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {
        List<Astronaut> astronauts = astronautRepository.getModels().stream().filter(a -> a.getOxygen() > 60).collect(Collectors.toList());
        planet = planetRepository.findByName(planetName);


        if (astronauts.isEmpty()) {
            throw new IllegalArgumentException(PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }

        mission.explore(planet, astronauts);
        List<Astronaut> deadAstronauts = astronauts.stream().filter(a -> a.getOxygen() <= 0).collect(Collectors.toList());
        countExploredPlanet++;

        return String.format(PLANET_EXPLORED, planetName, deadAstronauts.size());
    }

    @Override
    public String report() {
        StringBuilder out = new StringBuilder(String.format(REPORT_PLANET_EXPLORED, countExploredPlanet));
        out.append(System.lineSeparator());
        out.append(REPORT_ASTRONAUT_INFO);
        out.append(System.lineSeparator());

        Collection<Astronaut> models = astronautRepository.getModels();
        for (Astronaut model : models) {
            out.append(String.format(REPORT_ASTRONAUT_NAME, model.getName()));
            out.append(System.lineSeparator());
            out.append(String.format(REPORT_ASTRONAUT_OXYGEN, model.getOxygen()));
            out.append(System.lineSeparator());

            if (model.getBag().getItems().isEmpty()) {
                out.append(String.format(REPORT_ASTRONAUT_BAG_ITEMS, "none"));
            } else {
                out.append(String.format(REPORT_ASTRONAUT_BAG_ITEMS, String.join(REPORT_ASTRONAUT_BAG_ITEMS_DELIMITER, model.getBag().getItems())));
            }
            out.append(System.lineSeparator());
        }
        return out.toString().trim();
    }
}
