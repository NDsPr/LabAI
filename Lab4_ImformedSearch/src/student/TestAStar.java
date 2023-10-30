package student;

import java.util.Arrays;

public class TestAStar {
	public static void main(String[] args) {
		Node s = new Node("S", 6);
		Node b = new Node("B", 4);
		Node a = new Node("A", 4);
		Node c = new Node("C", 4);
		Node d = new Node("D", 3.5);
		Node e = new Node("E", 1);
		Node f = new Node("F", 1);
		Node g = new Node("G", 0);
		
		s.addEdge(b, 3);
		s.addEdge(a, 2);
		a.addEdge(c, 3);
		b.addEdge(d, 3);
		b.addEdge(c, 1);
		c.addEdge(e, 3);
		c.addEdge(d, 1);
		d.addEdge(f, 2);
		f.addEdge(g, 1);
		e.addEdge(g, 2);
		
//		IInformedSearchAlgo aStar = new AStarSearchAlgo();
//		Node res = aStar.execute(s, g.getLabel());
//		System.out.println(NodeUtils.printPath(res));

		 s.getChildren().addAll(Arrays.asList(new Edge(s, b, 3), new Edge(s, a, 2)));
	        b.getChildren().addAll(Arrays.asList(new Edge(b, d, 3), new Edge(b, c, 1)));
	        a.getChildren().add(new Edge(a, c, 3));
	        c.getChildren().addAll(Arrays.asList(new Edge(c, e, 3), new Edge(c, d, 1)));
	        d.getChildren().add(new Edge(d, f, 2));
	        f.getChildren().add(new Edge(f, g, 1));
	        e.getChildren().add(new Edge(e, g, 2));

//	        String goal = "G";
//
//	        // Uniform-Cost Search
//	        Node ucsResult = uniformCostSearch(s, goal);
//	        System.out.println("Uniform-Cost Search Result: " + NodeUtils.printPath(ucsResult));
//
//	        // Greedy Best-First Search
//	        Node greedyResult = greedyBestFirstSearch(s, goal);
//	        System.out.println("Greedy Best-First Search Result: " + NodeUtils.printPath(greedyResult));
//
//	        // A* Search
//	        Node aStarResult = aStarSearch(s, goal);
//	        System.out.println("A* Search Result: " + NodeUtils.printPath(aStarResult));
	        
	        System.out.println("Greedy: ");
	        IInformedSearchAlgo agreedy = new GreedyBestFirstSearchAlgo();
	        Node result = agreedy.execute(s,g.getLabel());
	        System.out.println(NodeUtils.printPath(result));

	       
	        System.out.println("AStar: ");
	        IInformedSearchAlgo aStar=new AStarSearchAlgo();
	        Node res=aStar.execute(s, g.getLabel());
	        System.out.println(NodeUtils.printPath(res));
	        
	        
	        System.out.println(" Bai tap test mơ rong:from S to G1 or G2 ");
			Node s1 = new Node("S1", 30);
			Node b1 = new Node("B1", 25);
			Node a1 = new Node("A1", 22);
			Node c1 = new Node("C1", 20);
			Node d1 = new Node("D1", 10);
			Node e1 = new Node("E1", 6);
			Node f1 = new Node("F1", 8);
			Node k1 = new Node("K1",26);
			Node h1 = new Node("H1",16);
			Node g1 = new Node("G1", 0);
			Node g2 = new Node("G2",0);
			
			
			s1.addEdge(b1, 8);
			s1.addEdge(k1, 6);
			s1.addEdge(c1, 19);
			a1.addEdge(b1,8);
			a1.addEdge(d1,15);
			b1.addEdge(a1, 7);
			b1.addEdge(c1, 11);
			c1.addEdge(e1, 12);
			d1.addEdge(g2, 9);
			e1.addEdge(g1, 7);
			f1.addEdge(g1, 10);
			h1.addEdge(s1,9);
			h1.addEdge(f1,7);
			h1.addEdge(g1,19);
			k1.addEdge(a1,13);
			k1.addEdge(h1,10);
			
			
			   System.out.println("Greedy ex: ");
		        IInformedSearchAlgo agreedy2 = new GreedyBestFirstSearchAlgo();
		        Node result2 = agreedy2.execute(s,g.getLabel());
		        System.out.println(NodeUtils.printPath(result2));

		       
		        System.out.println("AStar ex : ");
		        IInformedSearchAlgo aStar2=new AStarSearchAlgo();
		        Node res2=aStar2.execute(s, g.getLabel());
		        System.out.println(NodeUtils.printPath(res2));
		        
		        
		        System.out.println("task 3 : ");
		        boolean isAdmissible = lopCuaBan.laHeuristicHopLe(s, "G");
		        System.out.println("Heuristic is admissible: " + isAdmissible);
	    }
	
	
	
}
