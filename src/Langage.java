
import java.util.Set;
import java.util.HashSet;

class Langage {

	Set<String> mots;

	Langage() {
		this.mots = new HashSet<String>();
	}

	Langage(String chaines[]) {
		this();
		for (int i = 0; i < chaines.length; i++) {
			ajoute(chaines[i]);
		}
	}

	public void ajoute(String u) {
		mots.add(u);
	}

	public Langage inter(Langage L) {
		return null;
	}

	public Langage union(Langage L) {
		return null;
	}

	public Langage concat(Langage L) {
		return null;
	}

	public Langage difference(Langage L) {
		return null;
	}

	public static String miroirMot(String u) {
		return null;
	}

	public Langage miroir() {
		return null;
	}

	public String toString() {
		String res = "{ ";
		for (String u : mots) {
			if (u.length() == 0) {
				res += "mot_vide ";
			} else {
				res += u.toString() + " ";
			}
		}
		return res + "}";
	}

	public static void main(String args[]) {
		String langs[] = {"yolo", "hello", "foo"};
		Langage L = new Langage(langs);
		System.out.println(L);
	}
}