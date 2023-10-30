package student;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class SearchAlgorithms {
    // Uniform-Cost Search
    public static Node uniformCostSearch(Node root, String goal) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(Node::getG));
        Set<Node> explored = new HashSet<>();

        priorityQueue.add(root);

        while (!priorityQueue.isEmpty()) {
            Node current = priorityQueue.poll();

            if (current.getLabel().equals(goal)) {
                return current;
            }

            explored.add(current);

            List<Node> children = getUnexploredChildren(current, explored);

            for (Node child : children) {
                if (!priorityQueue.contains(child)) {
                    priorityQueue.add(child);
                    child.setParent(current);
                    child.setG(current.getG() + getEdgeCost(current, child));
                }
            }
        }

        return null;
    }

    // Greedy Best-First Search
    public static Node greedyBestFirstSearch(Node root, String goal) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(Node::getH));
        Set<Node> explored = new HashSet<>();

        priorityQueue.add(root);

        while (!priorityQueue.isEmpty()) {
            Node current = priorityQueue.poll();

            if (current.getLabel().equals(goal)) {
                return current;
            }

            explored.add(current);

            List<Node> children = getUnexploredChildren(current, explored);

            for (Node child : children) {
                if (!priorityQueue.contains(child)) {
                    priorityQueue.add(child);
                    child.setParent(current);
                }
            }
        }

        return null;
    }

    // A* Search
    public static Node aStarSearch(Node root, String goal) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(node -> node.getG() + node.getH()));
        Set<Node> explored = new HashSet<>();

        priorityQueue.add(root);

        while (!priorityQueue.isEmpty()) {
            Node current = priorityQueue.poll();

            if (current.getLabel().equals(goal)) {
                return current;
            }

            explored.add(current);

            List<Node> children = getUnexploredChildren(current, explored);

            for (Node child : children) {
                if (!priorityQueue.contains(child)) {
                    priorityQueue.add(child);
                    child.setParent(current);
                    child.setG(current.getG() + getEdgeCost(current, child));
                }
            }
        }

        return null;
    }

    // Helper method to get unexplored children of a node
    private static List<Node> getUnexploredChildren(Node node, Set<Node> explored) {
        List<Node> unexploredChildren = new ArrayList<>();
        for (Edge edge : node.getChildren()) {
            Node child = edge.getEnd();
            if (!explored.contains(child)) {
                unexploredChildren.add(child);
            }
        }
        return unexploredChildren;
    }

    // Example edge cost function
    private static double getEdgeCost(Node start, Node end) {
        // Replace this with your actual edge cost function
        for (Edge edge : start.getChildren()) {
            if (edge.getEnd().equals(end)) {
                return edge.getWeight();
            }
        }
        return Double.POSITIVE_INFINITY; // Default value if edge not found
    }
}