package student;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Check {
	public boolean isAdmissibleH(Node root, String goal) {
		Node goalNode = findGoalNode(root, goal);
		if (goalNode == null) {
			return false; // Goal not found
		}

		// Set the true cost h*(G) to 0 for the goal node
		goalNode.setH(0);

		// Perform A* traversal to compute true costs h*(n)
		performAStarTraversal(root, goal);

		// Check admissibility condition for each node
		return checkAdmissibilityCondition(root);
	}

	private Node findGoalNode(Node root, String goal) {
		Queue<Node> queue = new LinkedList<>();
		Set<Node> visited = new HashSet<>();

		queue.add(root);
		visited.add(root);

		while (!queue.isEmpty()) {
			Node current = queue.poll();

			if (current.getLabel().equals(goal)) {
				return current; // Goal node found
			}

			for (Node child : current.getChildrenNodes()) {
				if (!visited.contains(child)) {
					queue.add(child);
					visited.add(child);
				}
			}
		}

		return null; // Goal node not found
	}

	private void performAStarTraversal(Node root, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<>(Comparator.comparingDouble(Node::getTotalCost));
		Set<Node> explored = new HashSet<>();

		frontier.add(root);

		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			explored.add(current);

			if (current.getLabel().equals(goal)) {
				// Goal reached, no need to explore further
				break;
			}

			for (Edge edge : current.getChildren()) {
				Node child = edge.getEnd();

				if (!explored.contains(child) && !frontier.contains(child)) {
					child.setG(current.getG() + edge.getWeight());
					child.setH(child.getH()); // Assume h values are already set
					child.setParent(current);
					frontier.add(child);
				}
			}

		}
	}
	private boolean checkAdmissibilityCondition(Node node) {
        if (node == null) {
            return true;
        }

        double h = node.getH();
        double trueCost = node.getTotalCost();

        if (h > trueCost || h < 0) {
            return false;
        }

        for (Node child : node.getChildrenNodes()) {
            if (!checkAdmissibilityCondition(child)) {
                return false;
            }
        }

        return true;
    }
}

