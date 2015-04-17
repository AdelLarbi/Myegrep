package automate;
import java.io.FileReader;

import filesReader.BufferReader;

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
        System.out.println(auto.toString());*/
        
        /*try {
        	regExp.Parser p = new regExp.Parser(new regExp.Lexer(new FileReader("text")));
            System.out.println("\nLe resultat est:");
            Object result = p.parse().value;
        } catch (Exception e) {
            System.out.println("\nSyntax Error");
            e.printStackTrace();
        }*/
    	
    	BufferReader bufferReader = new BufferReader();
    	String mot = "debian";
    	String chemin = "text";
    	
    	bufferReader.trouver(mot, chemin);    	
    	bufferReader.getLignes(mot);
    }
}
