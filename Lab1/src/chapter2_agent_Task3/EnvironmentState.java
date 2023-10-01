package chapter2_agent_Task3;
import java.util.HashMap;

import java.util.Map;

import chapter2_agent_Task3.Environment.LocationState;


public class EnvironmentState {
	private Map<String, Environment.LocationState> state = new HashMap<String, Environment.LocationState>();
	private String agentLocation = null;//
	 private int agentRow;
	    private int agentCol;
	    private int rows;  // Số hàng trong lưới
	    private int cols;  // Số cột trong lưới

	public EnvironmentState(Environment.LocationState locAState, Environment.LocationState locBState) {
		this.state.put(Environment.LOCATION_A, locAState);
		this.state.put(Environment.LOCATION_B, locBState);
	}
	public EnvironmentState(LocationState locAState, LocationState locBState, int rows, int cols) {
        // Khởi tạo giá trị rows và cols khi tạo một thể hiện của EnvironmentState
        this.rows = rows;
        this.cols = cols;

        // Các phương thức khác ...
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
	public void setAgentLocation(String location) {
		this.agentLocation = location;
	}

	public String getAgentLocation() {
		return this.agentLocation;
	}

	public LocationState getLocationState(String location) {
		return this.state.get(location);
	}

	public void setLocationState(String location, LocationState locationState) {
		this.state.put(location, locationState);
	}

	public void display() {
		System.out.println("Environment state: \n\t" + this.state);
	}
	public void setLocationState(int row, int col, LocationState locationState) {
	    String location = generateLocationKey(row, col);
	    this.state.put(location, locationState);
	}

	private String generateLocationKey(int row, int col) {
	    return "R" + row + "C" + col;
	}
	
	   

	    public void setAgentLocation(int row, int col) {
	        agentRow = row;
	        agentCol = col;
	    }

	    public int getAgentRow() {
	        return agentRow;
	    }

	    public int getAgentCol() {
	        return agentCol;
	    }
	    public LocationState getLocationState(int row, int col) {
	        String location = generateLocationKey(row, col);
	        return state.getOrDefault(location, LocationState.CLEAN);
	    }
}