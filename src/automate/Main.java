package automate;

import java.io.FileReader;
import regExp.*;

public class Main {

    public static final boolean INFO = true;

    public static void main(String[] args) {
        /*Etat e0 = new Etat(true, false, 0);
        Etat e1 = new Etat(1);
        Etat e2 = new Etat(2);
        Etat e3 = new Etat(3);
        Etat e4 = new Etat(4);
        Etat e5 = new Etat(false, true, 5);
        //  Etat e6 = new Etat(false,true,6);

        System.out.println("AJOUT DES ETATS");
        e0.ajouteTransition('a', e1);
        e1.ajouteTransition('b', e3);
        e1.ajouteTransition(' ', e2);

        e2.ajouteTransition('a', e2);
        e2.ajouteTransition('c', e5);
        e3.ajouteTransition('c', e4);
        e3.ajouteTransition('a', e5);
        e4.ajouteTransition('b', e4);
        e4.ajouteTransition('a', e5);


        Automate auto = new Automate();
        System.out.println("AJOUT DES ETATS A L'AUTOMATE");
        auto.ajouteEtatSeul(e0);
        auto.ajouteEtatSeul(e1);
        auto.ajouteEtatSeul(e2);
        auto.ajouteEtatSeul(e3);
        auto.ajouteEtatSeul(e4);
        auto.ajouteEtatSeul(e5);
	
        System.out.println("AFFICHAGE DE L'AUTOMATE NON DETERMINISTE");
        System.out.println(auto.toString());
        System.out.println(auto.estDeterministe());
        System.out.println("ON ENLEVE LES EPSILON TRANSISTION");
        auto = auto.remove_epsilon_transition(auto);
        System.out.println("AFFICHAGE DE L'AUTOMATE SANS LES TRANSITIONS");
        System.out.println(auto.toString());
        System.out.println("MINIMISATION");
        Automate autoMin = auto.minimisation();
        System.out.println("AFFICHAGE DE L'AUTOMATE MIN");
        System.out.println(autoMin.toString());        
    	
    	System.out.println("# DÉBUT:");
    	Automate aaa = new Automate();
    	aaa.union(auto);
    	
    	System.err.println(aaa);*/
    	//System.out.println("# TESTE SI UNE REGEXP");
    	String lienDeFichier = "text";
    	// TODO parser lexer job
    	//System.out.println("(TODO parser lexer job)");
    	try {
//    		regExp.Parser p = new regExp.Parser(new regExp.Lexer(new FileReader(lienDeFichier)));
        	//Object result = p.parse();
    		
    		Parser p = new Parser().getParser(lienDeFichier);
    		Automate result = p.getAutomate();
    		//System.out.println(result);
        	
    	} catch (Exception e) {
        	System.out.println("\nErreur de syntaxe");
        	e.printStackTrace();        	
    	}
    	/*
    	System.out.println("# CONSTRUCTION DE L'AUTOMATE");
    	// FIXME construcion ne donne pas un bon automate
    	System.out.println("(FIXME construcion ne donne pas un bon automate)");		
		
		System.out.println("# AFFICHAGE DE L'AUTOMATE NON DETERMINISTE");
		System.out.println(automate);
		
		System.out.println("# TESTE SI L'AUTOMATE EST DETERMINISTE");
		System.out.println(automate.estDeterministe());		
		
		System.out.println("# MINIMISATION MOORE");
		Automate automateMin = null;
		automateMin = automate.minimisation();
		System.out.println(automateMin);
		
		System.out.println("# TEST SI UN MOT EST ACCEPTÉ");
		String mot = "debian";		
		// FIXME fonction accepte ne marche pas
		System.out.println("(FIXME fonction accepte ne marche pas)");
		System.out.println(automateMin.accepte(mot));		
		        
		System.out.println("# FAIS LA RECHERCHE");
		String chemin = "DossierTest/";
    	BufferReader bufferReader = new BufferReader();
        bufferReader.explorerDossier(mot, chemin, true);

        System.out.println("# FIN.");*/
    }
}
