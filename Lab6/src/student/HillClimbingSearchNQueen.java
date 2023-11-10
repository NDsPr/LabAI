package student;

import java.util.List;

public class HillClimbingSearchNQueen {

	int stepClimed=0;
	int stepClimbedAfterRandomRestrart=0;
	int randomRestarts=0;
	
	public Node execute(Node initialState) {
		
		Node currentState=initialState;
		
		int currentH=currentState.getH();
		
		while(currentH !=0) {
			List<Node> candidates=currentState.generateAllCandidates();
			Node bestNeighbor = null;
			int bestNeighborH = currentH;
			
			for(Node neighbor : candidates) {
				
				int neighborH = neighbor.getH();
				
				if( neighborH < bestNeighborH) {
					bestNeighbor = neighbor;
					bestNeighborH = neighborH;
				}
			}
			if(bestNeighborH >= currentH) {
				//Local optium reached
				break;
			}
			currentState=bestNeighbor;
			currentH=bestNeighborH;
			stepClimed++;
		}
		return currentState;
	}
	public Node executeHillClimbingWithRandomRestart(Node initialState) {
		Node currentState = execute(initialState);
		while(currentState.getH()!=0) {
			//random
			currentState.generateBoard();
			currentState = execute(currentState);
			stepClimbedAfterRandomRestrart++;
			randomRestarts++;
		}
		return currentState;
	}
}
