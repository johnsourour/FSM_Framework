import java.util.HashMap;
import java.util.Map;

public class FSM {
    private Map<String, State> statesMap;
    private String initState, endState;
    private String name;
    private Data data;

    FSM(String n) {
        name = n;
        statesMap = new HashMap<>();
        data = new Data();
    }

    public void addVariable(String name, Object value) {
        data.addVariable(name, value);
    }

    public Object getVariable(String name) {
        return data.getVariable(name);
    }

    public boolean changeVariableValue(String name, Object value) {
        return data.changeVariable(name, value);
    }

    public void removeVariable(String name) {
        data.removeVariable(name);
    }

    public void setInitState(String initState) {
        this.initState = initState;
    }

    public void setEndState(String endState) {
        this.endState = endState;
    }

    public void addState(State state, String name) {
        state.setData(data);
        statesMap.put(name, state);
    }

    public boolean removeState(String name) {
        if(!statesMap.containsKey(name)){
            return false;
        }
        statesMap.remove(name);
        return true;
    }

    /** add Transition from srcState to destState.
     * Both must be added using AddState method before calling this method
     */
    public boolean addStateTransition(String srcState,
                                      String destState,
                                      String transitionName) {
        if (!statesMap.containsKey(srcState)) {
            System.out.println("srcState not found, add first");
            return false;
        }
        if (!statesMap.containsKey(destState)) {
            System.out.println("destState not found, add first");
            return false;
        }
        State state1 = statesMap.get(srcState);
        State state2 = statesMap.get(destState);
        Transition transition = new Transition(state2);
        state1.addTransition(transitionName, transition);
        return true;
    }

    public boolean removeStateTransition(String stateName,
                                         String transitionName) {
        if (!statesMap.containsKey(stateName)) {
            return false;
        }
        State state = statesMap.get(stateName);
        state.removeTransition(transitionName);
        return true;
    }

    public boolean setStateAction(String stateName,
                               Action action,
                               String actionName) {
        State state = statesMap.get(stateName);
        if(state == null) {
            return false;
        }
        state.setAction(action);
        return true;
    }

    public boolean removeStateAction(String stateName, String actionName) {
        State state = statesMap.get(stateName);
        if(state == null) {
            return false;
        }
        state.removeAction();
        return true;
    }

    public boolean run() {
        if (initState == null) {
            System.out.println("Initial State not set");
            return false;
        }
        if (endState == null) {
            System.out.println("End State not set");
            return false;
        }
        State curState = statesMap.get(initState);
        State stopState = statesMap.get(endState);

        while (true) {
            System.out.println("State: " + curState.getStateName());
            Transition nextTransition = curState.run();
            if (nextTransition == null) {
                return false;
            }
            if(curState.getStateId() == stopState.getStateId()) {
                break;
            }
            curState = nextTransition.getDestination();
        }
        return true;
    }
}
