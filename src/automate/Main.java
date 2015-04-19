package automate;

import regExp.Parser;

public class Main {

    public static final boolean INFO = true;

    public static void main(String[] args) {

    	String lienDeFichier = "text";
    	
    	try {
    		Parser p = new Parser().getParser(lienDeFichier);
    		Automate resultat = p.getAutomate();
    		System.out.println("L'automate générer est:\n" + resultat);
        	
    	} catch (Exception e) {
        	System.out.println("\nErreur de syntaxe");
        	e.printStackTrace();        	
    	}
    }
}
