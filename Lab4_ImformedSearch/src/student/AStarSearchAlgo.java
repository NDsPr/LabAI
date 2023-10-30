package student;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class AStarSearchAlgo implements IInformedSearchAlgo {

    @Override
    public Node execute(Node root, String goal) {
        // PriorityQueue with NodeComparatorByGn
        PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparatorByGn());
        List<Node> explored=new ArrayList<>();
        

        // Add the root node to the frontier
        frontier.add(root);

        while (!frontier.isEmpty()) {
            Node current = frontier.poll();

            // Check if the current node is the goal
            if (current.getLabel().equals(goal)) {
                return current;
            }

            // Mark the current node as explored
            explored.add(current);
            List<Edge> children = current.getChildren();
            // Expand the current node's children
            for (Edge edge : children) {
            	Node child =edge.getEnd();
                // Check if the child is not in the explored set and not in the frontier
                if (!explored.contains(child) && !frontier.contains(child)) {
                    child.setParent(current);
                    child.setG(current.getG()+edge.getWeight());
                   
                    // Add the child to the frontier
                    frontier.add(child);
                }else if(frontier.contains(child)&& child.getG()>current.getG()+edge.getWeight()) {
                	frontier.remove(child);
                	child.setG(current.getG()+edge.getWeight());
                	child.setParent(current);
                	frontier.add(child);
                }
            }
        }

        // If no goal is found
        return null;
    }

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		return null;
	}
}

