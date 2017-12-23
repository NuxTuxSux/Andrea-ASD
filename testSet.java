import java.util.*;

class testSet {
	public static void main(String args[]) {
		/*System.out.println((new Integer(3)).equals(new Integer(3)));
		System.out.println((new Integer(3)).compareTo(new Integer(4)));
		System.out.println((new Integer(12)).compareTo(new Integer(4)));*/
		Set<String> s = new Set<String>(Arrays.asList("ciao","sono","nunzio","nunzio","sono","io","ciao","tu"));
		s.add("prova");
		System.out.println(s);
		System.out.println(s.asList());
		System.out.println(s.size());
		
	}
}