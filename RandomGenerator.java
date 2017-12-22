// La classe Randomizer è una copia dell'algoritmo 8 Random(seed) sugli appunti del professore Policriti

// Update: Aggiunto un costruttore di default ed una funzione setSeed, in questo modo non si
// è costretti passare il seed nel momento in cui si istanzia la classe ed/od è possibile modificare il
// valore del seed in qualunque momento.

/*
public class Randomizer {
	
	double seed;
	
	public Randomizer(double seed) {
		this.seed = Math.abs(seed % 2147483647);
	}
	
	public Randomizer() {}
	
	public void setSeed(double seed) {
		this.seed = seed;
	}
	
	public double get() {
		final int a = 16087;
		final int m = 2147483647;
		final int q = 127773;
		final int r = 2836;
		double lo, hi, test;
		hi = Math.ceil(seed/q);
		lo = seed - q * hi;
		test = a * lo - r * hi;
		if (test < 0.0) {
			seed = test + m;
		} else {
			seed = test;
		}
		return seed / m;
	}
    
	public double getSeed() {
		return seed;
	}
	
}
*/

//
// Classe che genera numeri casuali,
// migliore del random di sistema
//
public class RandomGenerator {
   //
   // get(): restituisce un numero compreso tra 0 e 1 (e aggiorna il seme)
   //
   public double get()
   {
      //
      // Costanti
      //
      final int a = 16087;
      final int m = 2147483647;
      final int q = 127773;
      final int r = 2836;

      //
      // Variabili
      //
      double lo, hi, test;

      hi = Math.ceil(seed / q);
      lo = seed - q * hi;
      test = a * lo - r * hi;
      if (test < 0.0) {
         seed = test + m;
      } else {
         seed = test;
      }
      return seed / m;
   }
	
	public double getSeed() {
		return seed;
	}
	
   //
   // setSeed(s): imposta il valore del seme a s
   //
   public void setSeed(double s)
   {
      seed = s;
   }

   //
   // costruttore della classe, genera un'istanza di RandomGenerator,
   // fissando il seme iniziale a s.
   //
   public RandomGenerator(double s)
   {
      seed = s;
   }

   //
   // variabile che tiene memorizzato il seme
   //
   private double seed;

   //
   // esempio di uso della classe RandomGenerator,
   // stampa 10 numeri casuali compresi tra 1 e 100
   //
   public static void main(String[] args)
   {
      long n, i;
      //
      // crea un istanza della classe RandomGenerator
      //
      RandomGenerator r = new RandomGenerator(123456789);

      System.out.println("Il valore iniziale del seme e': " + r.getSeed());

      for (i = 0; i < 10; i++) {
         n = Math.round(r.get() * 100);
         System.out.println(n);
      }
   }

}