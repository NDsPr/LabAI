package game_nim_student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Node {
	private List<Integer> data = new ArrayList<Integer>();

	public void add(Integer val) {
		this.data.add(val);
	}

	public void addAll(List<Integer> data) {
		this.data.addAll(data);
	}

	// Get children of the current nodes
	public List<Node> getSuccessors() {
		Collections.sort(this.data, DESCOMPARATOR);
		List<Node> childrens = new ArrayList<Node>();
		for (int i = 0; i < this.data.size(); i++) {
			// lấy phần tử thứ i để chia
			int current = this.data.get(i);
			int re = current / 2;
			for (int j = 1; j <= re; j++) {
				Node child = new Node();
				if ((current - j) != re) {
					child.add(j);
					child.add(current - j);
					for (int k = 0; k < this.data.size(); k++) {
						if (k != i)
							child.add(this.data.get(k));
					}
					if (!childrens.contains(child))
						childrens.add(child);
				}

			}
		}

		return childrens;
	}

	// Check whether a node is terminal or not
	public boolean isTerminal() {
		Collections.sort(this.data, DESCOMPARATOR);
		if (this.data.get(0) <= 2)
			return true;
		return false;
	}

	public static final Comparator<Integer> DESCOMPARATOR = new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
	};

	@Override
	public String toString() {
		Collections.sort(this.data, DESCOMPARATOR);
		return this.data.toString();
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		Collections.sort(this.data, DESCOMPARATOR);
		Collections.sort(other.data, DESCOMPARATOR);

		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		return true;
	}

}
