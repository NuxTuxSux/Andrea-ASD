import java.io.*;
import java.util.*;

public class Misurazione {

	double e;
	double delta;
	long tMin;
	
	boolean cycle;
	
	static Scanner input_file_scanner;
	
	public double getE() {
		return e;
	}
    
	public long getTMin() {
		return tMin;
	}
   
	public double getDelta() {
		return delta;
	}
	
	// copiato direttamente dall'algoritmo 9 delle dispense del professore Polocriti
	public Misurazione(int n, double za, double DELTA, Scanner i_f_s) throws FileNotFoundException, IOException{
        
        this.esecuzioni = 0;

		this.cycle = false;
		
		this.input_file_scanner = i_f_s;
		
		long t = 0;
        long sum2 = 0;
        long cn = 0;
        long m;
        double s;
        tMin = calcolaTMin(DELTA);
        do {
            for (int i=0;i<n;i++) {
                // ATTENZIONE
                m = tempoMedioNetto(tMin);
                t += m;
                sum2 += Math.pow(m,2);
                System.out.println(i);
            }
            cn += n;
            e = (double)t/(double)cn;
            s = Math.sqrt((double)sum2/(double)cn-Math.pow(e,2));
            delta = 1.0/Math.sqrt(cn)*za*s;
        } while (delta < DELTA);
    }
	
	// funzione ausiliaria a Misurazione
	public long calcolaTMin(double DELTA) {
        long gran = granularita();
        return (long)(gran / DELTA);
    }
	
	// copiato direttamente dall'algoritmo 4 delle dispense del professore Polocriti
	public long granularita() {
        long t0 = System.currentTimeMillis();
        long t1 = System.currentTimeMillis();
        while (t0 == t1) {
            t1 = System.currentTimeMillis();
        }
        return t1-t0;
    }
    
	// copiato direttamente dall'algoritmo 7 delle dispense del professore Polocriti
	// tempoMedioNetto non fa uso di tempo di tara perchè non c'è tempo di preparazione, il Grafo() prende in input il file passato dalla shell
	public long tempoMedioNetto(long tMin) throws FileNotFoundException, IOException{
        // ATTENZIONE
        int ripLordo = calcolaRipLordo(tMin);
        long t0 = System.currentTimeMillis();
        long t1 = System.currentTimeMillis();
        long tTara = t1-t0;
        t0 = System.currentTimeMillis();
        for (int i=0;i<ripLordo;i++) {
            nowGo();
        }
        t1 = System.currentTimeMillis();
        long tLordo = t1-t0;
        long tMedio = (tLordo/ripLordo);
        return tMedio;
    }
	
	// copiato direttamente dall'algoritmo 5 delle dispense del professore Polocriti
	// non ho messo calcolaRipTara perchè non c'è tempo di preparazione, il mio programma prende in input il file passato dalla shell
	public int calcolaRipLordo(long tMin) throws FileNotFoundException, IOException{
        // QUESTO VIENE CHIAMATO ATTUALMENTE 4 VOLTE, a colpa del for dentro il while ()
        long t0 = 0;
        long t1 = 0;
        int rip = 1;
        while (t1-t0 <= tMin) {
            rip = rip*2;
            t0 = System.currentTimeMillis();
            for (int i=0;i<rip;i++) {
                nowGo();
            }
            t1 = System.currentTimeMillis();
        }
        int max = rip;
        int min = rip/2;
        int cicliErrati = 5;
        while (max-min >= cicliErrati) {
            rip = (max-min)/2;
            t0 = System.currentTimeMillis();
            for (int i=0;i<rip;i++) {
                nowGo();
            }
            t1 = System.currentTimeMillis();
            if (t1-t0 <= tMin) {
                min = rip;
            } else {
                max = rip;
            }
        }
        return max;
    }

	
	String g_n;
	String[] g_c;
	int l_g_c;
	String[] ns;
	int l_n;
	
	//lancio la mia classe Grafo e le sue funzioni per creare i minimum_height_tree dei grafi del mio file di input
	/*public void nowGo() throws FileNotFoundException, IOException{
		if(cycle==false){
			Grafo g = new Grafo(this.input_file_scanner);
			
			this.g_n = g.getGraphName();
			this.g_c = g.getGraph_Components();
			this.l_g_c = g.getLengthGraphComponents();
			this.ns = g.getNodes();
			this.l_n = g.getLengthNodes();
			
			g.createTrees();
			g.find_minimum_height_tree();
			g.create_output_file();
			cycle = true;
		} else {
			Grafo g = new Grafo(this.g_n, this.g_c, this.l_g_c, this.ns, this.l_n);
			g.createTrees();
			g.find_minimum_height_tree();
		}

	}*/

    int esecuzioni;
    public void nowGo() throws IOException {
        System.out.println(++esecuzioni);
        WordOrder program = new WordOrder();
        //program.main(new String [0]);
        program.main(new String[]{"se","nonna","non","era","serena","non","si","rasserenerava","nonno"});
    }
	
}
