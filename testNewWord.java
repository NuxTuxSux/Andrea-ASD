import java.util.*;
//import NewWord.java;

class testNewWord {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Inserire stringa:");
		String prova = scanner.next();
		NewWord diz = new NewWord(prova);
		System.out.println(diz);

		System.out.println("\n----Prova confronto----");

		String cmd = "";
		NewWord prima, seconda;
		while(!cmd.equals("x")) {
			System.out.print("Prima:");
			prima = new NewWord(scanner.next());
			System.out.print("Seconda:");
			seconda = new NewWord(scanner.next());
			if (prima.lessThan(seconda)) {
				System.out.println("La prima è minore strettamente della seconda");
			}
			if (prima.leq(seconda)) {
				if (seconda.leq(prima)) {
					System.out.println("Le due parole sono anagrammi");
				} else {
					System.out.println("La prima parola è più piccola");
				}
			} else if (seconda.leq(prima)) {
				System.out.println("La seconda parola è più piccola");
			} else {
				System.out.println("Le parole non sono confrontabili");
			}

			cmd = scanner.next();
		}
	}

}