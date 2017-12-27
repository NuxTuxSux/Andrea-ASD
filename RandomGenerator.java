// La classe Randomizer è una copia dell'algoritmo 8 Random(seed) sugli appunti del professore Policriti

// Update: Aggiunto un costruttore di default ed una funzione setSeed, in questo modo non si
// è costretti passare il seed nel momento in cui si istanzia la classe ed/od è possibile modificare il
// valore del seed in qualunque momento.


//
// Classe che genera numeri casuali,
// migliore del random di sistema
//
public class RandomGenerator {
   //
   // Costanti
   //
   static int a = 16087;
   static int m = 2147483647;
   static int q = 127773;
   static int r = 2836;

   // Probabilità di estrazione di un carattere secondo lo schema:
   // {lettera maiusc-minusc, cifra, spazio, a-capo}
   // la somma è minore di uno per permettere altri caratteri "strani"
   static double prob [] = {0.5, 0.25, 0.125, 0.0078125};

   private double seed;

   //
   // costruttore della classe, genera un'istanza di RandomGenerator,
   // fissando il seme iniziale a s.
   //
   public RandomGenerator(double s)
   {
      seed = s;
   }

   //
   // get(): restituisce un numero compreso tra 0 e 1 (e aggiorna il seme)
   //

   public double get()
   {      
      double lo, hi, test;
      System.out.println();
      System.out.println("seed:"+seed);
      hi = Math.ceil(seed / q);
      System.out.println("hi:"+hi);
      lo = seed - q * hi;
      System.out.println("lo:"+lo);
      test = a * lo - r * hi;
      System.out.println("test:"+test);
      
      if (test < 0.0) {
         seed = test + m;
      } else {
         seed = test;
      }
      return seed / m;
   }

   public double myRand() {
      long hi, lo;
   
      hi = Math.round(seed) / q;
      lo = Math.round(seed) - hi * q;
      seed = (double)(a * lo - hi * r);
      if (seed < 0)
         seed += m;
      return (double)(seed / m);
   }

   public char getChar() {
      return 0;
   }

   public char getLetter() {
      return 0;
   }

   public char getDigit() {
      return 0;
   }

   public char getStrangeChar() {
      return 0;
   }

}