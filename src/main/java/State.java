import java.util.HashMap;
import java.util.Map;

public class State {
    private static int ids = 0;
    // unique id for each state
    private int stateId;
    private Map<String, Transition> transitionMap;
    //customized action of the state
    private Action action;
    private Data data;
    private String stateName;

    State(String name) {
        stateId = ids;
        ids++;
        stateName = name;
        transitionMap = new HashMap<>();
    }

    public String getStateName() {
        return stateName;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public void addTransition(String name, Transition transition) {
        transitionMap.put(name, transition);
    }

    public void removeTransition(String name) {
        transitionMap.remove(name);
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public void removeAction() {
        this.action = null;
    }
    public Action getAction() {
        return action;
    }

    public int getStateId() {
        return stateId;
    }

    public Transition getTransition(String result) {
        return transitionMap.get(result);
    }

    public Transition run() {
        String res = action.execute(data);
        return transitionMap.get(res);
    }

}
