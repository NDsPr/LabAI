package alg;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearchAlgo implements ISearchAlgo{

	@Override
	public Node execute(Node root, String goal) {
		
		Stack<Node> stack = new Stack<>();
	    stack.push(root);
	    List<Node> explored = new ArrayList<>();

	    while (!stack.isEmpty()) {
	        Node current = stack.pop();

	        if (current.getLabel().equals(goal)) {
	            return current;
	        }

	        explored.add(current);

	        List<Node> children = current.getChildrenNodes();

	        for (Node child : children) {
	            if (!stack.contains(child) && !explored.contains(child)) {
	                stack.push(child);
	                child.setParent(current);
	            }
	        }
	    }

		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		Stack<Node> stack = new Stack<>();
	    stack.push(root);
	    List<Node> explored = new ArrayList<>();

	    while (!stack.isEmpty()) {
	        Node current = stack.pop();

	        if (current.getLabel().equals(goal)) {
	            return current;
	        }

	        explored.add(current);

	        List<Node> children = current.getChildrenNodes();

	        for (Node child : children) {
	            if (!stack.contains(child) && !explored.contains(child)) {
	                stack.push(child);
	                child.setParent(current);
	            }
	        }
	    }
		return null;
	}

	@Override
	public Node executeTree(Node root, String goal) {
		// TODO Auto-generated method stub
		if (root == null) {
            return null;
        }

        if (root.getLabel().equals(goal)) {
            return root;
        }

        List<Node> children = root.getChildrenNodes();

        for (Node child : children) {
            Node result = executeTree(child, goal);
            if (result != null) {
                return result;
            }
        }

        return null;
	}

	@Override
	public Node executeTree(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		 Stack<Node> stack = new Stack<>();
	        stack.push(root);
	        List<Node> explored = new ArrayList<>();

	        while (!stack.isEmpty()) {
	            Node current = stack.pop();

	            if (current.getLabel().equals(goal)) {
	                return current;
	            }

	            explored.add(current);

	            List<Node> children = current.getChildrenNodes();

	            for (Node child : children) {
	                if (!stack.contains(child) && !explored.contains(child)) {
	                    stack.push(child);
	                    child.setParent(current);
	                }
	            }
	        }

	        return null;
	    }

	@Override
	public Node execute(Node root, String goal, int limitedDepth) {
		// TODO Auto-generated method stub
		return null;
	}
	}


