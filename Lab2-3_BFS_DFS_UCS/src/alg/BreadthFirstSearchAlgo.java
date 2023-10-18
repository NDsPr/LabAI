package alg;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BreadthFirstSearchAlgo implements ISearchAlgo {

	
   @Override
   public  Node execute(Node root, String goal) {
	Queue<Node> frontier = new LinkedList<Node>();
	frontier.add(root);// Bắt đầu từ node gốc để duyệt
	List<Node> explored = new ArrayList<Node>();
	while (!frontier.isEmpty()) {
		Node current = frontier.poll() ;
		if (current.getLabel().equals(goal)) {
			return current;
	}
		explored.add(current);
		//nếu là tree thì không có hàng trên
		List<Node> childrent=current.getChildrenNodes();
		// nếu là tree thì node thay bằng Ege(hàng trên)
		for (Node child :childrent) {
			if(!frontier.contains(child) &&  !explored.contains(child)) {
				frontier.add(child);
			child.setParent(current);
		}
			
		}
	}
	return null;
}

@Override
public Node execute(Node root, String start, String goal) {
	// TODO Auto-generated method stub
	 Queue<Node> frontier = new LinkedList<>();
	    frontier.add(root);
	    List<Node> explored = new ArrayList<>();

	    while (!frontier.isEmpty()) {
	        Node current = frontier.poll();

	        if (current.getLabel().equals(goal)) {
	            return current;
	        }

	        explored.add(current);

	        List<Node> children = current.getChildrenNodes();

	        for (Node child : children) {
	            if (!frontier.contains(child) && !explored.contains(child)) {
	                frontier.add(child);
	                child.setParent(current);
	            }
	        }
	    }

	    return null;
	}

@Override
public Node executeTree(Node root, String goal) {
	// TODO Auto-generated method stub
	 Queue<Node> frontier = new LinkedList<>();
     frontier.add(root);
     List<Node> explored = new ArrayList<>();

     while (!frontier.isEmpty()) {
         Node current = frontier.poll();

         if (current.getLabel().equals(goal)) {
             return current;
         }

         explored.add(current);

         List<Node> children = current.getChildrenNodes();

         for (Node child : children) {
             if (!frontier.contains(child) && !explored.contains(child)) {
                 frontier.add(child);
                 child.setParent(current);
             }
         }
     }

     return null;
}

@Override
public Node executeTree(Node root, String start, String goal) {
	// TODO Auto-generated method stub
	 Queue<Node> frontier = new LinkedList<>();
     frontier.add(root);
     List<Node> explored = new ArrayList<>();

     while (!frontier.isEmpty()) {
         Node current = frontier.poll();

         if (current.getLabel().equals(goal)) {
             return current;
         }

         explored.add(current);

         List<Node> children = current.getChildrenNodes();

         for (Node child : children) {
             if (!frontier.contains(child) && !explored.contains(child)) {
                 frontier.add(child);
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
