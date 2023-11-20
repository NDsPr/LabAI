package genetic_Algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GA_NQueenAlgo {
	public static final int POP_SIZE = 100;// Population size
	public static final double MUTATION_RATE = 0.03;
	public static final int MAX_ITERATIONS = 1000;
	List<Node> population = new ArrayList<Node>();
	Random rd = new Random();

	// initialize the individuals of the population
	public void initPopulation() {
		for (int i = 0; i < POP_SIZE; i++) {
			Node ni = new Node();
			ni.generateBoard();
			population.add(ni);
		}
	}

	public Node execute() {
		// Enter your code here
		for (int iteration = 0; iteration < MAX_ITERATIONS; iteration++) {
			List<Node> newPopulation = new ArrayList<>();

			// Generate new population through crossover and mutation
			while (newPopulation.size() < POP_SIZE) {
				// Select parents using tournament selection
				Node parent1 = getParentByTournamentSelection();
				Node parent2 = getParentByTournamentSelection();

				// Perform crossover to create a child
				Node child = reproduce(parent1, parent2);

				// Mutate the child
				mutate(child);

				newPopulation.add(child);
			}

			// Replace the old population with the new one
			population = newPopulation;
		}

		// Return the best solution from the final population
		return getBestSolution();
	}

	// Mutate an individual by selecting a random Queen and
	// move it to a random row.
	public void mutate(Node node) {
		// Enter your code here
		if (rd.nextDouble() < MUTATION_RATE) {
			int randomQueen = rd.nextInt(Node.N);
			int randomRow = rd.nextInt(Node.N);
			node.setRow(randomQueen, randomRow);
		}
	}

	// Crossover x and y to reproduce a child
	public Node reproduce(Node x, Node y) {
		// Enter your code here
		Node child = new Node();

		for (int i = 0; i < Node.N; i++) {
			if (rd.nextBoolean()) {
				child.setRow(i, x.getRow(i));
			} else {
				child.setRow(i, y.getRow(i));
			}
		}

		return child;
	}

	// Select K individuals from the population at random and
	// select the best out of these to become a parent.
	public Node getParentByTournamentSelection() {
		// Enter your code here
		int tournamentSize = 5;
		Node best = null;

		for (int i = 0; i < tournamentSize; i++) {
			Node randomIndividual = population.get(rd.nextInt(POP_SIZE));

			if (best == null || randomIndividual.getH() < best.getH()) {
				best = randomIndividual;
			}
		}

		return new Node(best);
	}

	// Select a random parent from the population
	public Node getParentByRandomSelection() {
		// Enter your code here
		return new Node(population.get(rd.nextInt(POP_SIZE)));
	}

	// Get the best solution from the current population
	private Node getBestSolution() {
		Node best = population.get(0);

		for (Node individual : population) {
			if (individual.getH() < best.getH()) {
				best = individual;
			}
		}

		return best;
	}
}
