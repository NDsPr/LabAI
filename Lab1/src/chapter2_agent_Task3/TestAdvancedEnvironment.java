package chapter2_agent_Task3;

public class TestAdvancedEnvironment {
	 public static void main(String[] args) {
	        AdvancedEnvironment env = new AdvancedEnvironment(AdvancedEnvironment.LocationState.CLEAN, AdvancedEnvironment.LocationState.DIRTY, 5, 5);
	        Agent agent = new Agent(new AgentProgram());
	        env.addAgent(agent, 2, 2); // Place the agent in the center of the grid

	        env.step(3);
	    }
	}