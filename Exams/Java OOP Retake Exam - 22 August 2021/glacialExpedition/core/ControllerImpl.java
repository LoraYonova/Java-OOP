package glacialExpedition.core;

import glacialExpedition.models.explorers.*;
import glacialExpedition.models.mission.MissionImpl;
import glacialExpedition.models.states.State;
import glacialExpedition.models.states.StateImpl;

import glacialExpedition.repositories.ExplorerRepository;
import glacialExpedition.repositories.StateRepository;

import java.util.List;
import java.util.stream.Collectors;

import static glacialExpedition.common.ConstantMessages.*;
import static glacialExpedition.common.ExceptionMessages.*;


public class ControllerImpl implements Controller {
    private ExplorerRepository repository;
    private StateRepository stateRepository;
    private MissionImpl mission;
    private int exploredStatesCount;

    public ControllerImpl() {
        this.repository = new ExplorerRepository();
        this.stateRepository = new StateRepository();
        this.mission = new MissionImpl();
    }


    @Override
    public String addExplorer(String type, String explorerName) {
        Explorer explorer;

        switch (type) {
            case "NaturalExplorer":
                explorer = new NaturalExplorer(explorerName);
                break;
            case "GlacierExplorer":
                explorer = new GlacierExplorer(explorerName);
                break;
            case "AnimalExplorer":
                explorer = new AnimalExplorer(explorerName);
                break;
            default:
                throw new IllegalArgumentException(EXPLORER_INVALID_TYPE);
        }
        repository.add(explorer);
        return String.format(EXPLORER_ADDED, type, explorerName);
    }

    @Override
    public String addState(String stateName, String... exhibits) {
        State state = new StateImpl(stateName);
        stateRepository.add(state);

        if (exhibits.length > 0) {
            for (String exhibit : exhibits) {
                state.getExhibits().add(exhibit);
            }
        }
        return String.format(STATE_ADDED, stateName);
    }

    @Override
    public String retireExplorer(String explorerName) {
        Explorer name = repository.byName(explorerName);
        if (name == null) {
            throw new IllegalArgumentException(String.format(EXPLORER_DOES_NOT_EXIST, explorerName));
        }
        repository.remove(name);
        return String.format(EXPLORER_RETIRED, explorerName);

    }

    @Override
    public String exploreState(String stateName) {
        List<Explorer> explorersGetEnergy = repository.getCollection().stream().filter(e -> e.getEnergy() > 50).collect(Collectors.toList());
        if (explorersGetEnergy.isEmpty()) {
            throw new IllegalArgumentException(STATE_EXPLORERS_DOES_NOT_EXISTS);
        }
        State state = stateRepository.byName(stateName);

        mission.explore(state, explorersGetEnergy);



        List<Explorer> explorers = explorersGetEnergy.stream().filter(e -> e.getEnergy() > 0).collect(Collectors.toList());
        int retiredExplorer = explorersGetEnergy.size() - explorers.size();
        exploredStatesCount++;
        return String.format(STATE_EXPLORER, stateName, retiredExplorer);
    }

    @Override
    public String finalResult() {
        StringBuilder out = new StringBuilder();
        out.append(String.format(FINAL_STATE_EXPLORED, exploredStatesCount));
        out.append(System.lineSeparator());
        out.append(FINAL_EXPLORER_INFO);
        out.append(System.lineSeparator());

        for (Explorer explorer : repository.getCollection()) {
            out.append(String.format(FINAL_EXPLORER_NAME, explorer.getName()));
            out.append(System.lineSeparator());
            out.append(String.format(FINAL_EXPLORER_ENERGY, explorer.getEnergy()));
            out.append(System.lineSeparator());

            if (explorer.getSuitcase().getExhibits().isEmpty()) {
                out.append(String.format(FINAL_EXPLORER_SUITCASE_EXHIBITS, "None"));
            } else {
                out.append(String.format(FINAL_EXPLORER_SUITCASE_EXHIBITS, String.join(FINAL_EXPLORER_SUITCASE_EXHIBITS_DELIMITER, explorer.getSuitcase().getExhibits())));
            }
            out.append(System.lineSeparator());

        }

        return out.toString().trim();
    }
}
