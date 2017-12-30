import java.util.*;

class TestRandom {
	public static void main (String args[]) {
		// Prendo le ultime nove cifre dei millisecondi come seed per RandomGenerator per evitare overflow
		// Fare anche il reverse?

		String millisecs = String.valueOf(System.currentTimeMillis()).substring(4);
		RandomGenerator gen = new RandomGenerator((double)Integer.parseInt(millisecs));

		/*System.out.println(Integer.parseInt(millisecs));
		System.out.println(System.currentTimeMillis());*/
		System.out.println(millisecs);
		
		System.out.println("Prima chiamata rnd:" + gen.rnd());

		float mean = 0;
		for (int i = 0; i < 10000000; i++)
			mean += gen.myRand();
		System.out.println("myRand mean:" + mean / 10000000);

		mean = 0;
		for (int i = 0; i < 10000000; i++)
			mean += gen.rnd();
		System.out.println("rnd mean:" + mean / 10000000);

		System.out.println("Test Dado:");
		for (int i = 0; i < 250; i++)
			System.out.print(gen.rnd(1,7) + " ");
		
		System.out.println();
		System.out.println("Test Caratteri:");
		for (int i = 0; i < 5000; i++)
			System.out.print(gen.rndChr());
		System.out.println();

		


	}
}