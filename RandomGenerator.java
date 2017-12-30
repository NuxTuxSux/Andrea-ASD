// La classe è una copia dell'algoritmo 8 Random(seed) sugli appunti del professore Policriti


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
   // {lettera-maiusc, lettera-minusc, cifra, spazio, a-capo}
   // la somma è minore di uno per permettere altri caratteri "strani"
   static double prob [] = {0.25, 0.25, 0.25, 0.125, 0.007};

   static char interv [][] = {{65,91},{97,123},{48,58}};

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
   // rnd(): restituisce un numero compreso tra 0 e 1 (e aggiorna il seme)
   //

   public double rnd()
   {      
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

   public int rnd(int a, int b) {
      return (int)Math.ceil(rnd()*(b-a)+a-1);
   }

   // versione alternativa del generatore di numeri casuali
   public double myRand() {
      long hi, lo;
   
      hi = Math.round(seed) / q;
      lo = Math.round(seed) - hi * q;
      seed = (double)(a * lo - hi * r);
      if (seed < 0)
         seed += m;
      return (double)(seed / m);
   }

   // Restituisce un carattere casuale seguendo le probabilità date da prob[][]
   public char rndChr() {
      double choice = rnd();
      int res;
      if (choice < prob[0]) {
         // return an uppercase letter
         return (char)rnd(interv[0][0],interv[0][1]);
      } else if (choice < prob[0] + prob[1]) {
         // return a lowercase letter
         return (char)rnd(interv[1][0],interv[1][1]);
      } else if (choice < prob[0] + prob[1] + prob[2]) {
         // return a digit
         return (char)rnd(interv[0][0],interv[0][1]);
      } else if (choice < prob[0] + prob[1] + prob[2] + prob[3]) {
         // return a space
         return ' ';
      } else if (choice < prob[0] + prob[1] + prob[2] + prob[3] + prob[4]) {
         // return a newline-end of string
         return '\n';
      } else {
         // return a random char
         return (char)rnd(33,127);
      }
   }


}