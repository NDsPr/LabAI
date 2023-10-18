package alg;

import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class UniformCostSearchAlgo implements ISearchAlgo {

	 @Override
	    public Node execute(Node root, String goal) {
	        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(Node::getPathCost));
	        List<Node> explored = new ArrayList<>();

	        priorityQueue.add(root);

	        while (!priorityQueue.isEmpty()) {
	            Node current = priorityQueue.poll();

	            if (current.getLabel().equals(goal)) {
	                return current;
	            }

	            explored.add(current);

	            List<Node> children = current.getChildrenNodes();

	            for (Node child : children) {
	                if (!priorityQueue.contains(child) && !explored.contains(child)) {
	                    priorityQueue.add(child);
	                    child.setParent(current);
	                    child.setPathCost(current.getPathCost() + 1); // Assuming uniform cost
	                } else if (priorityQueue.contains(child)) {
	                    // Update the priority queue if a shorter path is found
	                    double newPathCost = current.getPathCost() + 1; // Assuming uniform cost
	                    if (newPathCost < child.getPathCost()) {
	                        priorityQueue.remove(child);
	                        child.setPathCost(newPathCost);
	                        priorityQueue.add(child);
	                        child.setParent(current);
	                    }
	                }
	            }
	        }

	        return null;
	    }
	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		
	        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(Node::getPathCost));
	        List<Node> explored = new ArrayList<>();

	        priorityQueue.add(root);

	        while (!priorityQueue.isEmpty()) {
	            Node current = priorityQueue.poll();

	            if (current.getLabel().equals(goal)) {
	                return current;
	            }

	            explored.add(current);

	            List<Node> children = current.getChildrenNodes();

	            for (Node child : children) {
	                if (!priorityQueue.contains(child) && !explored.contains(child)) {
	                    priorityQueue.add(child);
	                    child.setParent(current);
	                    child.setPathCost(current.getPathCost() + 1); // Assuming uniform cost
	                } else if (priorityQueue.contains(child)) {
	                    // Update the priority queue if a shorter path is found
	                    double newPathCost = current.getPathCost() + 1; // Assuming uniform cost
	                    if (newPathCost < child.getPathCost()) {
	                        priorityQueue.remove(child);
	                        child.setPathCost(newPathCost);
	                        priorityQueue.add(child);
	                        child.setParent(current);
	                    }
	                }
	            }
	        }

	        return null;
	}

	@Override
	public Node executeTree(Node root, String goal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeTree(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Node execute(Node root, String goal, int limitedDepth) {
		// TODO Auto-generated method stub
		return null;
	}
}

