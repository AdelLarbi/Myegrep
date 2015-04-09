
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class Etat {

	HashMap<Character, EnsEtat> transitions;
	boolean init=false;
	boolean term=false;
	int id;

	public Etat() {
		this.transitions = new HashMap<Character, EnsEtat>();
	}

	public Etat(int id) {
		this.transitions = new HashMap<Character, EnsEtat>();
		this.id = id;
	}

	public Etat(boolean init, boolean term, int id) {
		this.transitions = new HashMap<Character, EnsEtat>();
		this.init = init;
		this.term = term;
		this.id = id;
	}

	public Etat(boolean estInit, boolean estTerm) {
		this.init = estInit;
		this.term = estTerm;
		this.transitions = new HashMap<Character, EnsEtat>();
	}

	public boolean isInit() {
		return init;
	}

	public boolean isTerm() {
		return term;
	}

	public void setInit(boolean init) {
		this.init = init;
	}

	public void setTerm(boolean term) {
		this.term = term;
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		} else {
			final Etat other = (Etat) obj;
			return (id == other.id);
		}
	}
	
	EnsEtat succ(char c) {
		return transitions.get(c);
	}
	
	public EnsEtat succ() {
		EnsEtat ee = new EnsEtat();
		Collection<EnsEtat> ensemblecomplet;
		ensemblecomplet = transitions.values();
		for (Iterator iterator = ensemblecomplet.iterator(); iterator.hasNext();) {
			EnsEtat ensEtat = (EnsEtat) iterator.next();
			ee.liste_etat.addAll(ensEtat);
			
		}
		// on une liste pleine de doublons on vas les retirer 
		Set<Etat> myset = new HashSet<Etat>(ee.liste_etat);
	
	    
	    ee.liste_etat.clear();
	    for (Etat etat : myset) {
			ee.liste_etat.add(etat);
		}
	    return ee;
	}
	
	void ajouteTransition(char c ,Etat e) {
		// si la transition existe
		if (transitions.containsKey(c)) {
			transitions.get(c).add(e);
		} else {
			Set<Etat> ce = new HashSet<>();
			ce.add(e);
			EnsEtat tmp = new EnsEtat(ce);
			transitions.put(c, tmp);
		}
	}
	
	public  String toStringEtat() {
//		String res = " \n Etat "+this.id+"\n";
//		res+= "\n "+"is term  :"+this.term+"\n";
//		res+= "\n "+"is init  :"+this.init+"\n"+"transitions :\n";
//		
		String res = "" ;
		String tmp = "\n" ;
		for(Character c : transitions.keySet()){
			res+= "\n "+"char: "+c+" -> :\n";
			for(Etat e: transitions.get(c).liste_etat){
				tmp += "\t Etat "+e.id+"\n";
				tmp += "\t "+"is term  :"+e.term+"\n";
				tmp += "\t "+"is init  :"+e.init+"\n";
				
			}
			res += tmp;
		}
		return res ;
	}
	
}












