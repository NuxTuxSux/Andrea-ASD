import java.util.*;

class DiGraph {

	public int N;
	private List<List<Integer>> sons;
	private List<Integer> heights;
	//public int

	public DiGraph(int N) {
		this.N = N;
		this.sons = new ArrayList<List<Integer>>(N);
		for (List<Integer> nodeSons: this.sons) {
			nodeSons = new ArrayList<Integer>();
			heights.add(-1);
		}
	}

	public void connect(int parent, int son) {
		if (parent < N)
			sons.get(parent).add(son);
	}

	public int height(int node) {
		int h = heights.get(node);
		if (h > -1)
			return h;
		
	}

}