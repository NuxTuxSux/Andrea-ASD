// Il programma da lancia per testare la classe Grafo.java, versione 2 fatto per essere eseguito da Standard Input

import java.io.*;
import java.util.*;

public class Tester {

	public static void main(String[] args) throws IOException{
		
		Scanner input_file_scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		final double DELTA = 0.05;
		final double ZA = 2.33;
		final int N = 13;
		
		// N.B. La classe Grafo.java può gestire una file con al massimo 6000 nodi distinti
		//N è il numero di volte che ripeto lo stesso test sullo stesso grafo
		Misurazione result = new Misurazione(N, ZA, DELTA, input_file_scanner);
		
		System.out.println( "Granularità: " + (result.getTMin()*DELTA) );
		System.out.println( "Confidenza: " + result.getDelta() );
		System.out.println( "Tempo medio impiegato: " + result.getE() );
		System.out.println();
		System.out.println();
		
	}
	
}