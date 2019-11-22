
public class GameOfLifeCell {
    private FSM machine;
    private int posX;
    private int posY;
    private int color;

    GameOfLifeCell(int x, int y, Data d) {
        machine = new FSM("GOL Cell");
        machine.setData(d);
        posX = x;
        posY = y;
        int[][] grid = (int[][]) d.getVariable("grid");
        color = grid[posX][posY];
        init();
    }

    private void init() {
        Action calc = new ToggleCellColor("calc", posX, posY);
        Action go = new ActionGo("go");

        State dead = new State("dead");
        State alive = new State("alive");
        State check = new State("check");


        machine.addState(dead, dead.getStateName());
        machine.addState(alive, alive.getStateName());
        machine.addState(check, check.getStateName());
        if (color == 0) {
            machine.setInitState(dead.getStateName());
        } else {
            machine.setInitState(alive.getStateName());
        }
        machine.setStateAction(dead.getStateName(), go, "nextFromDead");
        machine.setStateAction(alive.getStateName(), go, "nextFromAlive");
        machine.setStateAction(check.getStateName(), calc, "checkAction");

        machine.addStateTransition(dead.getStateName(),
                check.getStateName(), "CALC");
        machine.addStateTransition(alive.getStateName(),
                check.getStateName(), "CALC");
        machine.addStateTransition(check.getStateName(),
                dead.getStateName(), "DEAD");
        machine.addStateTransition(check.getStateName(),
                alive.getStateName(), "ALIVE");

    }

    public int run() {
        return machine.runOne();
    }
}
