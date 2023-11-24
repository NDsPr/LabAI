package game_alphabeta_student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlphaBetaSearchAlgo implements ISearchAlgo {

    private Node bestMoveNode; // To store the best move node

    @Override
    public void execute(Node node) {
        bestMoveNode = null; // Reset the best move node
        int v = maxValue(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println("Value: " + v);
        if (bestMoveNode != null) {
            System.out.println("Best Move: " + bestMoveNode.getLabel());
        }
    }

    public int maxValue(Node node, int alpha, int beta) {
        if (node.isTerminal())
            return node.getValue();
        int v = Integer.MIN_VALUE;
        List<Node> childrens = node.getChildren();
        List<Node> tmp = new ArrayList<Node>();
        tmp.addAll(childrens);
        childrens.sort(Node.LabelLeftToRigthComparator);
        for (Node child : childrens) {
            int minValue = minValue(child, alpha, beta);
            if (minValue > v) {
                v = minValue;
                bestMoveNode = child; // Update the best move node
            }
            tmp.remove(child);
            if (v >= beta) {
                System.out.println("Cut node: " + tmp);
                return v;
            }
            alpha = Math.max(alpha, v);

        }
        return v;
    }

    public int minValue(Node node, int alpha, int beta) {
        if (node.isTerminal())
            return node.getValue();
        int v = Integer.MAX_VALUE;
        List<Node> childrens = node.getChildren();
        List<Node> tmp = new ArrayList<Node>();
        tmp.addAll(childrens);
        childrens.sort(Node.LabelLeftToRigthComparator);
        for (Node child : childrens) {
            int maxValue = maxValue(child, alpha, beta);
            if (maxValue < v) {
                v = maxValue;
                bestMoveNode = child; // Update the best move node
            }
            tmp.remove(child);
            if (v <= alpha) {
                System.out.println("Cut node: " + tmp);
                return v;
            }
            beta = Math.min(beta, v);

        }
        return v;
    }
}
