package chapter2_agent_Task3;

import java.util.Random;

public class AdvancedEnvironment extends Environment {
	protected EnvironmentState envState;
    private static final double DIRT_RATE = 0.2;
    private static final double WALL_RATE = 0.1;

    private Random random = new Random();

    public AdvancedEnvironment(LocationState locAState, LocationState locBState, int rows, int cols) {
        super(locAState, locBState);
        addDirtAndObstacles(rows, cols);
    }
    public void addAgent(Agent agent, int row, int col) {
        envState.setAgentLocation(row, col);
        envState.display(); // Hiển thị trạng thái môi trường sau khi thêm đại lý
    }
    private void addDirtAndObstacles(int rows, int cols) {
        int totalCells = rows * cols;
        int numDirt = (int) (totalCells * DIRT_RATE);
        int numWalls = (int) (totalCells * WALL_RATE);

        // Add dirt
        for (int i = 0; i < numDirt; i++) {
            int row = random.nextInt(rows);
            int col = random.nextInt(cols);
            envState.setLocationState(row, col, LocationState.DIRTY);
        }

        // Add walls
        for (int i = 0; i < numWalls; i++) {
            int row = random.nextInt(rows);
            int col = random.nextInt(cols);
            envState.setLocationState(row, col, LocationState.WALL);
        }
    }

    // Override executeAction to consider obstacles and update scoring
    @Override
    public EnvironmentState executeAction(Action action) {
        String agentLoc = envState.getAgentLocation();

        if (action.equals(SUCK_DIRT)) {
            if (envState.getLocationState(agentLoc) == LocationState.DIRTY) {
                envState.setLocationState(agentLoc, LocationState.CLEAN);
                return envState; // +500 points for cleaning dirt
            } else {
                return envState; // NoOp, no points
            }
        } else if (action.equals(MOVE_RIGHT) || action.equals(MOVE_LEFT) || action.equals(MOVE_UP) || action.equals(MOVE_DOWN)) {
            int[] newLocation = getNewLocation(agentLoc, action);
            int newRow = newLocation[0];
            int newCol = newLocation[1];

            if (isValidMove(newRow, newCol)) {
                envState.setAgentLocation(newRow, newCol);
                if (envState.getLocationState(newRow, newCol) == LocationState.WALL) {
                    return envState; // -100 points for hitting a wall
                } else {
                    return envState; // -10 points for moving
                }
            } else {
                return envState; // NoOp, no points for invalid move
            }
        }

        return envState;
    }

    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < envState.getRows() && col >= 0 && col < envState.getCols();
    }

    // Other methods remain unchanged
    private int[] getNewLocation(String agentLoc, Action action) {
        int currentRow = Integer.parseInt(agentLoc.substring(1, 2)); // Assuming the format "R2C3"
        int currentCol = Integer.parseInt(agentLoc.substring(3, 4));

        int[] newLocation = {currentRow, currentCol};

        switch (action.toString()) {
            case "UP":
                newLocation[0]--;
                break;
            case "DOWN":
                newLocation[0]++;
                break;
            case "LEFT":
                newLocation[1]--;
                break;
            case "RIGHT":
                newLocation[1]++;
                break;
        }

        return newLocation;
    }
}