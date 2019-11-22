public class ToggleCellColor extends Action {
    private static final String COLOR = "Color";
    private static final int THREE = 3;
    private static final int ALIVE = 1;
    private static final int TWO = 2;
    private static final int NEIGHBORS = 8;
    private static final Integer[] DR = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final Integer[] DC = {-1, 0, 1, 1, -1, 1, -1, 0};
    private Integer posX;
    private Integer posY;

    ToggleCellColor(String actionName, Integer x, Integer y) {
        super(actionName);
        posX = x;
        posY = y;
    }

    private boolean checkBoundaries(int sx, int sy, int ex,
                                    int ey, int x, int y) {
        if (x > ex || x < sx || y < sy || y > ey) {
            return false;
        }
        return true;
    }
    private Integer countAliveAround(int sx, int sy, int ex,
                                     int ey, int x, int y, int[][] grid) {
        int res = 0;
        for (int i = 0; i < NEIGHBORS; i++) {
            int curx = x + DR[i];
            int cury = y + DC[i];
            if (checkBoundaries(sx, sy, ex, ey, curx, cury)) {
                res += grid[curx][cury];
            }
        }
        return res;
    }
    @Override
    public String execute(Data d) {
        Integer sx = (Integer) d.getVariable("sx");
        Integer ex = (Integer) d.getVariable("ex");
        Integer sy = (Integer) d.getVariable("sy");
        Integer ey = (Integer) d.getVariable("ey");
        int[][] grid = (int[][]) d.getVariable("prev_grid");
        int[][] grid2 = (int[][]) d.getVariable("grid");
        int cur = grid[posX][posY];
        int count = countAliveAround(sx, sy, ex, ey, posX, posY, grid);
        Integer alive;
        if (cur == ALIVE) {
            if (count == TWO || count == THREE) {
                alive = 1;
            } else {
                alive = 0;
            }
        } else {
            if (count == THREE) {
                alive = 1;
            } else {
                alive = 0;
            }
        }
        grid2[posX][posY] = alive;
        d.changeVariable("grid", grid2);
        if (alive == 0) {
            return "DEAD";
        } else {
            return "ALIVE";
        }

    }
}
