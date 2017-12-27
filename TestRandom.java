import java.util.*;

class TestRandom {
	public static void main (String args[]) {
		// Prendo le ultime nove cifre dei millisecondi come seed per RandomGenerator per evitare overflow
		// Fare anche il reverse?

		String millisecs = String.valueOf(System.currentTimeMillis()).substring(4);
		RandomGenerator gen = new RandomGenerator((double)Integer.parseInt(millisecs));

		System.out.println(Integer.parseInt(millisecs));
		System.out.println(System.currentTimeMillis());
		System.out.println(millisecs);
		
		float mean = 0;
		for (int i = 0; i < 10000000; i++)
			mean+=gen.myRand();
		System.out.println(mean/10000000);
	}
}