package chapter2_agent_Task3;
import chapter2_agent_Task3.Environment.LocationState;

public class AgentProgram {

	public Action execute(Percept p) {// location, status
		//TODO
		if (p.getLocationState() == LocationState.DIRTY)
			return Environment.SUCK_DIRT;

		if (p.getAgentLocation().equals(Environment.LOCATION_A))
			return Environment.MOVE_RIGHT;

		if (p.getAgentLocation().equals(Environment.LOCATION_B))
			return Environment.MOVE_LEFT;

		return NoOpAction.NO_OP;
		
	}
}