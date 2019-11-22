import java.util.HashMap;
import java.util.Map;

public class State {
    private static int ids = 0;
    private int stateId;
    private Map<String, Transition> transitionMap;
    private Action action; //action of the state
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
        if(!transitionMap.containsKey(res)){
            System.out.println("invalid transition result");
            return null;
        }
        return transitionMap.get(res);
    }

}
