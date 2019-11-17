import java.util.HashMap;
import java.util.Map;

public abstract class State {
    private static int ids = 0;
    private int stateId;
    private Map<String, Transition> transitionMap;
    private Map<String, Action> actionMap;
    private String name;

    State() {
        stateId = ids;
        ids++;
        transitionMap = new HashMap<>();
        actionMap = new HashMap<>();
    }

    public void addTransition(String result, Transition transition) {}

    public void addAction(String result, Transition transition) {}

    public int getStateId() {
        return stateId;
    }

    public Transition getTransition(String result) {
        return null;
    }

    public abstract void run();

}
