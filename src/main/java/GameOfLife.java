import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameOfLife {

    private static final int WIDTH = 8;
    private static final int HEIGHT = 8;
    private static final int SLEEP_MS = 1000;
    private int[][] grid;
    private int[][] grid2;
    private List<GameOfLifeCell> cellList;
    private Random r;
    private Data gridData;

    GameOfLife() {
        r = new Random();
        gridData = new Data();
        grid = new int[HEIGHT][WIDTH];
        grid2 = new int[HEIGHT][WIDTH];
        cellList = new ArrayList<>();
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                grid[i][j] = r.nextInt(2);
                grid2[i][j] = grid[i][j];
            }
        }

        gridData.addVariable("sx", 0);
        gridData.addVariable("ex", HEIGHT - 1);
        gridData.addVariable("sy", 0);
        gridData.addVariable("ey", WIDTH - 1);
        gridData.addVariable("grid", grid);
        gridData.addVariable("prev_grid", grid2);

        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                cellList.add(new GameOfLifeCell(i, j, gridData));
            }
        }

    }

    public boolean run() throws InterruptedException {
        int iteration = 0;
        while (true) {
            iteration++;
            Thread.sleep(SLEEP_MS);
            for (GameOfLifeCell cell : cellList) {
                int curRun = cell.run();
                if (curRun == -1) {
                    return false;
                }

            }
            int[][] cur = (int[][]) gridData.getVariable("grid");
            int[][] prev = new int[HEIGHT][WIDTH];
            if (iteration % 2 == 1) {
                for (int i = 0; i < HEIGHT; i++) {
                    for (int j = 0; j < WIDTH; j++) {
                        System.out.print(Integer.toString(cur[i][j]) + " ");
                        prev[i][j] = cur[i][j];
                    }
                    System.out.println("");
                }
            }
            gridData.changeVariable("prev_grid", prev);

            if (iteration % 2 == 1) {
                System.out.println("");
                System.out.println("");
            }
        }

    }
}
