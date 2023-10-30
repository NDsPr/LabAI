package student;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class GreedyBestFirstSearchAlgo implements IInformedSearchAlgo {

    @Override
    public Node execute(Node root, String goal) {
        PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparatorByGn());
        List<Node> explored = new ArrayList<>();    

        frontier.add(root);
        while (!frontier.isEmpty()) {
        	Node current=frontier.poll();
        	if(current.getLabel().equals(goal)) {
        		return current;
        	}
        	explored.add(current);
        	List<Edge> childrent=current.getChildren();
        	for(Edge edge:childrent) {
        		Node child=edge.getEnd();
        		if(!explored.contains(child) && !frontier.contains(child)) {
        			child.setParent(current);
        			child.setG(current.getG()+edge.getWeight());
        			
        		}
        	}
        }
        return null;
        
        //        Set<Node> explored = new HashSet<>();
//
//        priorityQueue.add(root);
//
//        while (!priorityQueue.isEmpty()) {
//            Node current = priorityQueue.poll();
//
//            if (current.getLabel().equals(goal)) {
//                return current;
//            }
//
//            explored.add(current);
//
//            List<Node> children = getUnexploredChildren(current, explored);
//
//            for (Node child : children) {
//                if (!priorityQueue.contains(child)) {
//                    priorityQueue.add(child);
//                    child.setParent(current);
//                }
//            }
//        }
//
//        return null;
//    }
//
//    // Helper method to get unexplored children of a node
//    private List<Node> getUnexploredChildren(Node node, Set<Node> explored) {
//        List<Node> unexploredChildren = new ArrayList<>();
//        for (Edge edge : node.getChildren()) {
//            Node child = edge.getEnd();
//            if (!explored.contains(child)) {
//                unexploredChildren.add(child);
//            }
//        }
//        return unexploredChildren;
    }

	@Override
	public Node execute(Node root, String start, String goal) {
	
	        // Find the start and goal nodes
	        Node startNode = findNode(root, start);
	        Node goalNode = findNode(root, goal);

	        // Check if start and goal nodes are found
	        if (startNode == null || goalNode == null) {
	            System.out.println("Start or goal node not found");
	            return null;
	        }

	        PriorityQueue<Node> frontier = new PriorityQueue<>(new NodeComparatorByHn());
	        Set<Node> explored = new HashSet<>();

	        frontier.add(startNode);

	        while (!frontier.isEmpty()) {
	            Node current = frontier.poll();
	            explored.add(current);

	            if (current.equals(goalNode)) {
	                return current; // Goal reached
	            }

	            for (Edge edge : current.getChildren()) {
	                Node child = edge.getEnd();

	                if (!explored.contains(child) && !frontier.contains(child)) {
	                    child.setParent(current);
	                    frontier.add(child);
	                }
	            }
	        }

	        System.out.println("Goal not reached");
	        return null;
	    
	}
}
