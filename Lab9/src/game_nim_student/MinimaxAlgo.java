package game_nim_student;

import java.util.List;
public class MinimaxAlgo {
	 private Node bestMove; // Keep track of the best move

	    public void execute(Node node) {
	        int v = minValue(node);
	        System.out.println("Best move for MIN player: " + bestMove.toString());
	        System.out.println("Minimax value: " + v);
	    }

	    public int maxValue(Node node) {
	        if (node.isTerminal())
	            return 0;

	        int v = Integer.MIN_VALUE;
	        List<Node> children = node.getSuccessors();
	        System.out.println(node.toString());
			System.out.println(children.toString());
	        for (Node child : children) {
	            v = Math.max(v, minValue(child));
	        }

	        return v;
	    }

	    public int minValue(Node node) {
	        if (node.isTerminal())
	            return 1;

	        int v = Integer.MAX_VALUE;
	        List<Node> children = node.getSuccessors();
	        System.out.println(node.toString());
			System.out.println(children.toString());
	        for (Node child : children) {
	            int currentMaxValue = maxValue(child);

	            // Update the best move if a better move is found
	            if (currentMaxValue < v) {
	                v = currentMaxValue;
	                bestMove = child;
	            }
	        }

	        return v;
	    }
	}