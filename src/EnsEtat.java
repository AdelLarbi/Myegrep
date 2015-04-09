
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class EnsEtat extends HashSet<Etat> {
	HashSet<Etat> liste_etat;
	public EnsEtat() {
		// TODO Auto-generated constructor stub
		liste_etat = new HashSet<Etat>();
	}
	public EnsEtat(Set<Etat> ce) {
		liste_etat = new HashSet<Etat>();
		for(Etat ee : ce){
			liste_etat.add(ee);
		}
	}
	public HashSet<Etat> getListeEtat(){
		return liste_etat;
	}
	// fonction qui renvoi l'union de tout les 
	//successeurs de cette ensmble d'etat
	public EnsEtat succ(){
		EnsEtat ensres = new EnsEtat() ;
		
		HashSet<EnsEtat> list_union_etat = new HashSet<>();
		for(Etat e : this.liste_etat){
			for(EnsEtat et : e.transitions.values()){
					list_union_etat.add(et);
			}
		}
		for(EnsEtat et : list_union_etat){
			ensres.liste_etat.addAll(et.liste_etat);
		}
		return ensres;
	}
	public EnsEtat succ(char c) {
		EnsEtat ensres = new EnsEtat();
		
		for(Etat e : this.liste_etat){
			ensres.liste_etat.addAll(e.succ(c).liste_etat);
		}
		
		return ensres ;
	}
	public boolean contientTerminal() {
		for(Etat e :this.liste_etat){
			if(e.isTerm())
				return true ;
		}
		return false ;
	}
	
	public boolean accepte(String s, int i) {
		return true ;
	}
	
}
