import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class Main {

	public static void main(String[] args) {
		Etat e1 = new Etat(true,false,1);
		Etat e2 = new Etat(2);
		Etat e3 = new Etat(3);
		Etat e4 = new Etat(false,true,4);
		e1.ajouteTransition('a', e1);
		e1.ajouteTransition('b', e1);
		e1.ajouteTransition('a', e2);
		e2.ajouteTransition('a', e3);
		e2.ajouteTransition('b', e3);
		e3.ajouteTransition('a', e4);
		Set<Etat> se = new HashSet<Etat>();
		se.add(e1);
		se.add(e2);
		se.add(e3);
		se.add(e4);
		Automate auto =  new Automate(se);
		auto.add(e1);
		auto.add(e2);
		auto.add(e3);
		auto.add(e4);
		
		System.out.println(auto.toString());
		System.out.println(auto.estDeterministe());
		
	}
}
