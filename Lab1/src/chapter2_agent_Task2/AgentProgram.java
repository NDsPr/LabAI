package chapter2_agent_Task2;

import chapter2_agent_Task2.Environment.LocationState;

public class AgentProgram {

	public Action execute(Percept p) {// location, status
		//TODO
		if (p.getLocationState() == LocationState.DIRTY) {
			return Environment.SUCK_DIRT;
	}
		
		 String currentLocation = p.getAgentLocation();

	        // Randomly choose a direction to move
	        int randomMove = (int) (Math.random() * 4); // 0, 1, 2, or 3
	        switch (randomMove) {
	            case 0:
	                return Environment.MOVE_RIGHT;
	            case 1:
	                return Environment.MOVE_LEFT;
	            case 2:
	                return Environment.MOVE_UP;
	            case 3:
	                return Environment.MOVE_DOWN;
	        }
//		if (p.getAgentLocation().equals(Environment.LOCATION_A)) {
//            int randomMove = (int) (Math.random() * 3); // 0, 1, 2
//            switch (randomMove) {
//            case 0:
//                return Environment.MOVE_RIGHT;
//            case 1:
//                return Environment.MOVE_LEFT;
//            case 2:
//                return DynamicAction.MOVE_UP;
//            case 3:
//                return DynamicAction.MOVE_DOWN;
//            }
//        }  if (p.getAgentLocation().equals(Environment.LOCATION_B)) {
//            int randomMove = (int) (Math.random() * 4); // 0, 1, 2, or 3
//            switch (randomMove) {
//                case 0:
//                    return Environment.MOVE_LEFT;
//                case 1:
//                    return DynamicAction.MOVE_UP;
//                case 2:
//                    return DynamicAction.MOVE_DOWN;
//                case 3:
//                    return Environment.MOVE_RIGHT;
//            }
//        }if (p.getAgentLocation().equals(Environment.LOCATION_C)) {
//            int randomMove = (int) (Math.random() * 4); // 0, 1, 2, or 3
//            switch (randomMove) {
//                case 0:
//                    return Environment.MOVE_RIGHT;
//                case 1:
//                    return Environment.MOVE_LEFT;
//                case 2:
//                    return DynamicAction.MOVE_UP;
//                case 3:
//                    return DynamicAction.MOVE_DOWN;
//            }
//        }else if (p.getAgentLocation().equals(Environment.LOCATION_D)) {
//                int randomMove = (int) (Math.random() * 4); // 0, 1, 2, or 3
//                switch (randomMove) {
//                    case 0:
//                        return Environment.MOVE_RIGHT;
//                    case 1:
//                        return Environment.MOVE_LEFT;
//                    case 2:
//                        return DynamicAction.MOVE_UP;
//                    case 3:
//                        return DynamicAction.MOVE_DOWN;
//                }}
		return NoOpAction.NO_OP;}}
	
		
		
		
		
		
		
		
//		if (p.getAgentLocation().equals(Environment.LOCATION_A))
//			return Environment.MOVE_RIGHT;
//
//		if (p.getAgentLocation().equals(Environment.LOCATION_B))
//			return Environment.MOVE_LEFT;
//
//		return NoOpAction.NO_OP;
//		
//	}
//}