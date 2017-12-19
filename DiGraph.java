import java.util.*;

class DiGraph {

	public int N;
	private List<List<Integer>> sons;
	private List<Integer> heights;

	public DiGraph(int N) {
		this.N = N;
		this.sons = new ArrayList<List<Integer>>();
		for (List<Integer> nodeSons: this.sons)
			nodeSons = new ArrayList<Integer>();
			
	}



}