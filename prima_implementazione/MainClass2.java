package progetto_java_2019;

import java.util.Iterator;

import javax.xml.crypto.Data;

public class MainClass2 {
	public static <E extends Data> void main (String[] args) throws Exception {
		
		MyDataBoard<Type> bacheca = new MyDataBoard<Type> ("psw");
		
		// PROVA METODO createCategory ---------------------------------
		try {
			bacheca.createCategory("categoria 1", "psw");
			bacheca.createCategory("categoria 2", "psw");
			bacheca.createCategory("categoria 3", "psw");
			bacheca.createCategory("categoria 4", "psw");
			bacheca.createCategory("categoria 5", "psw");
			bacheca.createCategory("categoria 6", "psw");
			bacheca.createCategory("categoria 6", "psw");
		}
		catch(Exception ex) {
			System.out.print("Errore:\n" + ex.getMessage() + " : non tutte le richieste di inserimento di categoria sono andate a buon fine.\n");
		}
		// PROVA METODO removeCategory ---------------------------------
		try {
			bacheca.removeCategory("categoria 5", "psw");
			bacheca.removeCategory("categoria 6", "wrong");
		}
		catch(Exception ex) {
			System.out.print("\nErrore:\n" + ex.getMessage() + " : non tutte le richieste di rimozione di categoria sono andate a buon fine.\n");
		}
		// PROVA METODO printCategories --------------------------------
		bacheca.printCategories();
		
		
		// PROVA METODO addFriend --------------------------------------
		try {
			bacheca.addFriend("categoria 4", "psw", "marco");
			bacheca.addFriend("categoria 6", "psw", "marco");
			bacheca.addFriend("categoria 2", "psw", "marco");
			bacheca.addFriend("categoria 4", "psw", "antonio");
			bacheca.addFriend("categoria 6", "psw", "antonio");
			bacheca.addFriend("categoria 3", "psw", "antonio");
			bacheca.addFriend("categoria 1", "psw", "antonio");
			bacheca.addFriend("categoria 4", "psw", "grabriele");
			bacheca.addFriend("categoria 3", "psw", "elisa");
			bacheca.addFriend("categoria 6", "psw", "andrea");
			bacheca.addFriend("categoria 1", "psw", "andrea");
			bacheca.addFriend("categoria 1", "psw", "andrea");
		}
		catch(Exception ex) {
			System.out.print("\nErrore:\n" + ex.getMessage() + " : non tutte le richieste di inserimento di amicizia/categoria sono andate a buon fine.\n");
		}
		// PROVA METODO removeFriend -----------------------------------
		try {
			bacheca.removeFriend("categoria 6", "psw", "antonio");
			bacheca.removeFriend("categoria 1", "psw", "filippo");
		}
		catch(Exception ex) {
			System.out.print("\nErrore:\n" + ex.getMessage() + " : non tutte le richieste di rimozione di amicizia/categoria sono andate a buon fine.\n");
		}
		// PROVA METODO printFriend ------------------------------------
		bacheca.printFriend();
		// PROVA METODO printFriendCategories --------------------------
		bacheca.printFriendCategories("andrea");
		
		
		Type a = new Type("dato 1");
		Type b = new Type("dato 2");
		Type c = new Type("dato 3");
		Type d = new Type("dato 4");
		Type e = new Type("dato 5");
		Type f = new Type("dato 6");
		Type g = new Type("dato 7");
		// PROVA METODO put --------------------------------------------
		try {
			bacheca.put("psw", a, "categoria 6");
			bacheca.put("psw", b, "categoria 1");
			bacheca.put("psw", c, "categoria 4");
			bacheca.put("psw", d, "categoria 3");
			bacheca.put("psw", e, "categoria 3");
			bacheca.put("psw", f, "categoria 6");
			bacheca.put("psw", g, "categoria 8");
		}
		catch(Exception ex) {
			System.out.print("\nErrore:\n" + ex.getMessage() + " : non tutte le richieste di inserimento dei dati sono andate a buon fine.\n");
		}
		// PROVA METODO remove -----------------------------------------
		try {
			bacheca.remove("psw", a);
			bacheca.remove("wrong", g);
		}
		catch(Exception ex) {
			System.out.print("\nErrore:\n" + ex.getMessage() + " : non tutte le richieste di rimozione dei dati sono andate a buon fine.\n");
		}
		// PROVA METODO get --------------------------------------------
		try {
			System.out.println("\nRESTITUISCO LA COPIA DEL DATO  d (N° 4):");
			((Type)(bacheca.get("psw", d))).display();
			System.out.println("RESTITUISCO LA COPIA DEL DATO g (N° 7):");
			((Type)(bacheca.get("wrong", g))).display();
		}
		catch(Exception ex) {
			System.out.print("Errore:\n" + ex.getMessage() + " : questa richiesta di estrazione dei dati non è andata a buon fine.\n");
		}
		// PROVA METODO insertLike -------------------------------------
		try {
			bacheca.insertLike("marco", c);
			bacheca.insertLike("antonio", c);
			bacheca.insertLike("elisa", d);
			bacheca.insertLike("antonio", b);
			bacheca.insertLike("grabriele", c);
			bacheca.insertLike("andrea", b);
			bacheca.insertLike("andrea", f);
			bacheca.insertLike("grabriele", c);
		}
		catch(Exception ex) {
				System.out.print("\nErrore:\n" + ex.getMessage() + " : non tutte le richiesta di aggiunta dei like sono andate a buon fine.\n");
		}
		// PROVA METODO getBoardDatas ---------------------------------
		System.out.println("\nQUESTI SONO I DATI PRESENTI SULLA BACHECA:");
		for(int i = 0; i < bacheca.getBoardDatas().size(); i++) {
			bacheca.getBoardDatas().get(i).getData().display();
			System.out.print("(categoria: " + bacheca.getBoardDatas().get(i).getDataCategory() + ")");
			System.out.print(" (like: " + bacheca.getBoardDatas().get(i).getLike() + ")");
			System.out.print("\n");
		}
		// PROVA METODO getDataCategory -------------------------------
		try {
			System.out.println("\nQUESTI SONO TUTTI I DATI DELLA CATEGORIA N° 4:");
			for(int i = 0; i < bacheca.getDataCategory("psw", "categoria 4").size(); i++)
				bacheca.getDataCategory("psw", "categoria 4").get(i).display();
			System.out.println("QUESTI SONO TUTTI I DATI DELLA CATEGORIA N° 8:");
			for(int i = 0; i < bacheca.getDataCategory("psw", "categoria 8").size(); i++)
				bacheca.getDataCategory("psw", "categoria 8").get(i).display();
		}
		catch(Exception ex) {
				System.out.print("Errore:\n" + ex.getMessage() + " : non tutte le richieste di visualizzazioni per cattegoria sono andate a buon fine.\n");
		}
		
		
		// PROVA METODO getIterator -----------------------------------
		try {
			System.out.println("\nQUESTI SONO TUTTI I DATI ORDINATI PER LIKE DECRESCENTI:");
			Iterator<Type> itLike = (Iterator<Type>)(bacheca.getIterator("wrong"));
			while(itLike.hasNext())
				itLike.next().display();
		}
		catch(Exception ex) {
				System.out.print("Errore:\n" + ex.getMessage() + " : non tutte le operazioni richieste sono andate a buon fine.\n");
		}
		// PROVA METODO getFriendIterator -----------------------------
		try {
			System.out.println("\nQUESTI SONO TUTTI I DATI VISIBILI DA GIUSEPPE:");
			Iterator<Type> itFriend = (Iterator<Type>)(bacheca.getFriendIterator("giuseppe"));
			while(itFriend.hasNext())
				itFriend.next().display();
		}
		 catch(Exception ex) {
				System.out.print("Errore:\n" + ex.getMessage() + " : non tutte le operazioni richieste sono andate a buon fine.\n");
		} 
	}
}
