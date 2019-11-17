import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FSM {
    private List<State> stateList;
    private Map<String, Integer> statesMap;
    private String name;

    FSM(String n) {
        name = n;
        stateList = new ArrayList<>();
        statesMap = new HashMap<>();
    }

    public void addState(State state, String name) {}

    public void removeState(String name) {}

    public void addStateTransition(String stateName, Transition transition, String transitionName) {}

    public void removeStateTransition(String stateName, String transitionName) {}

    public void addStateAction(String stateName, Action action, String actionName) {}

    public void removeStateAction(String stateName, String actionName) {}

    public void run() {}
}
