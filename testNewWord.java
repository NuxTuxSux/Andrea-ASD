import java.util.*;
//import NewWord.java;

class testNewWord {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Inserire stringa:");
		String prova = scanner.next();
		NewWord diz = new NewWord(prova);
		System.out.println(diz);
	}

}