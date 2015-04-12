import java.io.FileReader;

public class Main {

	public static void main(String[] args) {
        /*Etat e0 = new Etat(true, false, 0);
        Etat e1 = new Etat(1);
        Etat e2 = new Etat(2);
        Etat eepsi = new Etat(3);
        Etat e3 = new Etat(false, true, 4);        e0.ajouteTransition('a', e0);
        e0.ajouteTransition('b', e0);
        e0.ajouteTransition('a', e1);
        e1.ajouteTransition('a', e2);
        e1.ajouteTransition('b', e2);
        e2.ajouteTransition('a', e3);		
		
        Automate auto = new Automate();
        auto.ajouteEtatRecursif(e0);

		System.out.println(auto.toString());
		System.out.println(auto.estDeterministe());*/
				
		try {
			sample.Parser p = new sample.Parser(new sample.Lexer( new FileReader("text")));
			System.out.println("\nLe resultat est:");
			Object result = p.parse().value;			
		} catch (Exception e) {		
			System.out.println("\nSyntax Error");
			e.printStackTrace();
		}	
	
	}
}
