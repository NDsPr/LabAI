package alg;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public interface ISearchAlgo {
	public Node execute(Node root, String goal);

	// find the path from root node to the goal node
	public Node execute(Node root, String start, String goal);
	public Node executeTree(Node root, String goal);

	// find the path from root node to the goal node
	public Node executeTree(Node root, String start, String goal);
	public Node execute(Node root, String goal, int limitedDepth);

}
