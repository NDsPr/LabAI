package game_alphabeta_student;

public class TestAlphaBeta {
	public static void main(String[] args) {
		
		
		Node A = new Node("A");
		Node B = new Node("B");
		Node C = new Node("C");
		Node D = new Node("D", 0);
		Node E = new Node("E");
		Node F = new Node("F");
		Node N = new Node("N", 4);
		Node O = new Node("O");
		Node W = new Node("W", -3);
		Node X = new Node("X", -5);
//
		Node G = new Node("G", -5);
		Node H = new Node("H", 3);
		Node I = new Node("I", 8);
		Node J = new Node("J");
		Node P = new Node("P", 9);
		Node Q = new Node("Q", -6);
		Node R = new Node("R", 0);
//
		Node K = new Node("K");
		Node L = new Node("L", 2);
		Node M = new Node("M");
		Node S = new Node("S", 3);
		Node T = new Node("T", 5);
		Node U = new Node("U", -7);
		Node V = new Node("V", -9);
		A.addChild(B);
		A.addChild(C);
		A.addChild(D);
		A.addChild(E);

		B.addChild(F);
		B.addChild(G);
		F.addChild(N);
		F.addChild(O);
		O.addChild(W);
		O.addChild(X);
		
		C.addChild(H);
		C.addChild(I);
		C.addChild(J);
		J.addChild(P);
		J.addChild(Q);
		J.addChild(R);
		
		E.addChild(K);
		E.addChild(L);
		E.addChild(M);
		K.addChild(S);
		K.addChild(T);
		M.addChild(U);
		M.addChild(V);


//		Node A = new Node("A");
//		Node B = new Node("B");
//		Node C = new Node("C");
//		Node D = new Node("D");
//		Node E = new Node("E");
//		Node F = new Node("F");
//		Node G = new Node("G");
//		Node H = new Node("H");
//		Node I = new Node("I");
//		Node J = new Node("J");
//
//		Node K = new Node("K");
//		Node L = new Node("L");
//		Node M = new Node("M");
//		Node N = new Node("N");
//		Node O = new Node("O");
//		Node P = new Node("P");
//		Node Q = new Node("Q");
//		Node R = new Node("R");
//		Node S = new Node("S");
//		Node T = new Node("T");
////
//		Node K1 = new Node("K1", 4);
//		Node K2 = new Node("K2", 9);
//		Node L1 = new Node("L1", 2);
//
//		Node M1 = new Node("M1", 1);
//		Node M2 = new Node("M2", 10);
//		Node N1 = new Node("N1", 0);
//		Node N2 = new Node("N2", 7);
//
//		Node O1 = new Node("O1", 4);
//		Node P1 = new Node("P1", 2);
//		Node Q1 = new Node("Q1", 1);
//		Node Q2 = new Node("Q2", 8);
//
//		Node R1 = new Node("R1", 3);
//		Node S1 = new Node("S1", 7);
//		Node S2 = new Node("S2", 4);
//		Node T1 = new Node("T2", 3);
//		Node T2 = new Node("T2", 1);
//
//		A.addChild(B);
//		A.addChild(C);
//		A.addChild(D);
//
//		B.addChild(E);
//		B.addChild(F);
//		E.addChild(K);
//		E.addChild(L);
//		K.addChild(K1);
//		K.addChild(K2);
//		L.addChild(L1);
//		F.addChild(M);
//		F.addChild(N);
//		M.addChild(M1);
//		M.addChild(M2);
//		N.addChild(N1);
//		N.addChild(N2);
//		
//		C.addChild(G);
//		C.addChild(H);
//		G.addChild(O);
//		H.addChild(P);
//		H.addChild(Q);
//		O.addChild(O1);
//		P.addChild(P1);
//		Q.addChild(Q1);
//		Q.addChild(Q2);
//
//		D.addChild(I);
//		D.addChild(J);
//		I.addChild(R);
//		I.addChild(S);
//		R.addChild(R1);
//		S.addChild(S1);
//		S.addChild(S2);
//		J.addChild(T);
//		T.addChild(T1);
//		T.addChild(T2);
//
//		

		ISearchAlgo alphaBeta = new AlphaBetaSearchAlgo();
		ISearchAlgo alphaBetaRTL = new AlphaBetaRightToLeftSearchAlgo();
		System.out.println("Task 2 : AlphaBetaSearchAlgo  &&   Task 4 : UPDATE AlphaBetaSearchAlgo ");
		alphaBeta.execute(A);
		System.out.println("Task 3 : AlphaBetaRightToLeftSearchAlgo");
		alphaBetaRTL.execute(A);
	}
}
