package alg;

import java.util.ArrayList;
import java.util.List;

public class DepthLimitedSearchAlgo implements ISearchAlgo {

    @Override
    public Node execute(Node root, String goal) {
        // Assuming no depth limit, calling the execute method without the depth parameter
        return execute(root, goal, Integer.MAX_VALUE);
    }

    public Node execute(Node root, String goal, int limitedDepth) {
        return depthLimitedSearch(root, goal, limitedDepth, 0);
    }

    private Node depthLimitedSearch(Node current, String goal, int limitedDepth, int currentDepth) {
        if (currentDepth > limitedDepth) {
            // Reached the depth limit, backtrack
            return null;
        }

        if (current.getLabel().equals(goal)) {
            // Goal found
            return current;
        }

        List<Node> children = current.getChildrenNodes();
        for (Node child : children) {
            Node result = depthLimitedSearch(child, goal, limitedDepth, currentDepth + 1);
            if (result != null) {
                // Goal found in the subtree
                return result;
            }
        }

        return null;
    }

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
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
}
