import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class UnitTesting {
    FSM fsm;
    @Before
    public void setUp() throws Exception {
        fsm = new FSM("test");
    }

    @Test
    public void addVariable() {
        Integer num = 2;
        String str = "str";
        ArrayList arr = new ArrayList();
        arr.add(num);
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(num, num);

        fsm.addVariable("num", num);
        fsm.addVariable("arr", arr);
        fsm.addVariable("str", str);
        fsm.addVariable("map", map);

        boolean testVar = true;
        testVar = testVar && fsm.getVariable("num").equals(num);
        testVar = testVar && fsm.getVariable("arr").equals(arr);
        testVar = testVar && fsm.getVariable("str").equals(str);
        testVar = testVar && fsm.getVariable("map").equals(map);

        assertTrue(testVar);

    }

    @Test
    public void changeVariableValue() {
        Integer num = 2;
        fsm.addVariable("num", num);
        fsm.changeVariableValue("num", num+2);
        assertEquals(num+2, fsm.getVariable("num"));
    }

    @Test
    public void removeVariable() {
        Integer num = 2;
        fsm.addVariable("num", num);
        boolean checkVar = fsm.getVariable("num")!=null;
        fsm.removeVariable("num");
        checkVar = checkVar && fsm.getVariable("num")==null;
        assertTrue(checkVar);
    }

    @Test
    public void addStateWithAction() {
        fsm.addVariable("name", "john");
        State state1 = new State("state1");
        Action action1 = new ActionPrint("print1", "name");
        fsm.addState(state1, state1.getStateName());
        assertTrue(fsm.setStateAction(state1.getStateName(), action1, "printName"));
    }

    @Test
    public void removeState() {
        fsm.addVariable("name", "john");
        State state1 = new State("state1");
        fsm.addState(state1, state1.getStateName());
        assertTrue(fsm.removeState("state1"));
    }

    @Test
    public void addStateTransition() {
        fsm.addVariable("name", "john");
        State state1 = new State("state1");
        State state2 = new State("state2");
        fsm.addState(state1, state1.getStateName());
        fsm.addState(state2, state2.getStateName());
        assertTrue(fsm.addStateTransition(state1.getStateName(), state2.getStateName(), "testTransition"));
    }

    @Test
    public void removeStateTransition() {
        fsm.addVariable("name", "john");
        State state1 = new State("state1");
        State state2 = new State("state2");
        fsm.addState(state1, state1.getStateName());
        fsm.addState(state2, state2.getStateName());
        fsm.addStateTransition(state1.getStateName(), state2.getStateName(), "testTransition");
        assertTrue(fsm.removeStateTransition(state1.getStateName(), "testTransition"));
    }


    @Test
    public void removeStateAction() {
        fsm.addVariable("name", "john");
        State state1 = new State("state1");
        Action action1 = new ActionPrint("print1", "name");
        fsm.addState(state1, state1.getStateName());
        boolean check = fsm.setStateAction(state1.getStateName(), action1, "printName");
        check = check && fsm.removeStateAction(state1.getStateName(), "printName");
        assertTrue(check);
    }

    @Test
    public void twoStatesTwoPrints() {
        fsm.addVariable("name", "john");
        fsm.addVariable("age", 21);
        State state1 = new State("state1");
        State state2 = new State("state2");
        fsm.addState(state1, state1.getStateName());
        fsm.addState(state2, state2.getStateName());
        fsm.addStateTransition(state1.getStateName(), state2.getStateName(), "SUCCESS");

        Action printJohn = new ActionPrint("printJohn", "name");
        Action printAge = new ActionPrint("printAge", "age");
        fsm.setStateAction(state1.getStateName(), printJohn, "printJohn");
        fsm.setStateAction(state2.getStateName(), printAge, "printAge");

        fsm.setInitState(state1.getStateName());
        fsm.setEndState(state2.getStateName());
        fsm.run();
        assertTrue(true);
    }
}