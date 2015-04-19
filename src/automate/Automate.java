package automate;

import java.util.*;

public class Automate extends EnsEtat {

    private final EnsEtat initiaux;


    public Automate() {
        super();
        initiaux = new EnsEtat();
    }

    public Automate(Etat etat) {
        this();
        this.ajouteEtatRecursif(etat);
    }

    public EnsEtat getInitiaux() {
        return this.initiaux;
    }

    public boolean ajouteEtatSeul(Etat e) {
        if (!this.add(e))
            return false;
        if (e.isInit())
            initiaux.add(e);
        return true;
    }

    public boolean ajouteEtatRecursif(Etat e) {
        boolean res = false;
        if (ajouteEtatSeul(e)) {
            EnsEtat ee = e.succ();
            if (ee != null) {
                for (Etat etat : ee)
                    ajouteEtatRecursif(etat);
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean estDeterministe() {
        if (this.isEmpty()) return true;

        if (this.initiaux.size() > 1) return false;

        for (Etat etat : this) {
            Set<Character> settmp = etat.getTransitions().keySet();
            for (Character c : settmp) {
                if (etat.succ(c).size() > 1)
                    return false;
            }
        }
        return true;
    }


    public Automate union(Automate a) {
        return union(a, true);
    }

    public Automate intersection(Automate a) {
        return union(a, false);
    }


    private Automate union(Automate a, boolean estUnion) {
        if (a == null) return null;

        Automate union = new Automate();
        Set<Character> alphabet = this.alphabet();
        HashMap<Etat[], Etat> map = new HashMap<Etat[], Etat>();
        Stack<Etat[]> pile = new Stack<Etat[]>();
        ArrayList<Etat[]> listDuoEtat = new ArrayList<Etat[]>();
        int etatCompteur = 0;

        //Unions des etats initiaux
        for (Etat etatB : this.initiaux) {
            for (Etat etatA : a.initiaux) {
                Etat tmp = new Etat(true, etatB.isTerm() || etatA.isTerm(), etatCompteur++);
                union.ajouteEtatSeul(tmp);
                Etat[] duoTmp = new Etat[2];
                duoTmp[0] = etatB;
                duoTmp[1] = etatA;
                map.put(duoTmp, tmp);
                pile.push(duoTmp);
                listDuoEtat.add(duoTmp);
            }
        }

        while (!pile.empty()) {
            Etat[] duoPop = pile.pop();
            Etat etatLie = map.get(duoPop);

            for (Character lettre : alphabet) {
                ArrayList<Etat[]> duoSuccList = new ArrayList<Etat[]>();
                EnsEtat[] duoPopSucc = new EnsEtat[2];
                duoPopSucc[0] = (duoPop[0] != null) ? duoPop[0].succ(lettre.charValue()) : null;
                duoPopSucc[1] = (duoPop[1] != null) ? duoPop[1].succ(lettre.charValue()) : null;

                if (duoPopSucc[0] == null && duoPopSucc[1] == null) break;
                else if (duoPopSucc[0] == null) {
                    for (Etat etatTmp : duoPopSucc[1]) {
                        Etat[] tabTmp = new Etat[2];
                        tabTmp[0] = null;
                        tabTmp[1] = etatTmp;
                        duoSuccList.add(tabTmp);
                    }
                } else if (duoPopSucc[1] == null) {
                    for (Etat etatTmp : duoPopSucc[0]) {
                        Etat[] tabTmp = new Etat[2];
                        tabTmp[0] = etatTmp;
                        tabTmp[1] = null;
                        duoSuccList.add(tabTmp);
                    }
                } else {
                    for (Etat etatTmpB : duoPopSucc[0]) {
                        for (Etat etatTmpA : duoPopSucc[1]) {
                            Etat[] tabTmp = new Etat[2];
                            tabTmp[0] = etatTmpB;
                            tabTmp[1] = etatTmpA;
                            duoSuccList.add(tabTmp);
                        }
                    }
                }

                //Parcours la liste de tout les duo de succ trouve
                for (Etat[] duoEtat : duoSuccList) {
                    Etat[] duoRef = null;
                    for (Etat[] duoExist : listDuoEtat) {
                        if (duoEtat[0] == null && duoExist[0] == null && duoEtat[1] == null && duoExist[1] == null
                                || duoEtat[0] == null && duoExist[0] == null && duoEtat[1] != null && duoEtat[1].equals(duoExist[1])
                                || duoEtat[1] == null && duoExist[1] == null && duoEtat[0] != null && duoEtat[0].equals(duoExist[0])
                                || duoEtat[0] != null && duoEtat[1] != null && duoEtat[0].equals(duoExist[0]) && duoEtat[1].equals(duoExist[1])) {
                            duoRef = duoExist;
                            break;
                        }
                    }

                    if (duoRef == null) {
                        boolean term = (estUnion) ? ((duoEtat[0] != null) ? duoEtat[0].isTerm() : false) || ((duoEtat[1] != null) ? duoEtat[1].isTerm() : false) : ((duoEtat[0] != null) ? duoEtat[0].isTerm() : false) && ((duoEtat[1] != null) ? duoEtat[1].isTerm() : false);
                        Etat nouvelEtat = new Etat(false, term, etatCompteur++);
                        union.ajouteEtatSeul(nouvelEtat);
                        map.put(duoEtat, nouvelEtat);
                        pile.push(duoEtat);
                        listDuoEtat.add(duoEtat);
                        etatLie.ajouteTransition(lettre.charValue(), nouvelEtat);
                    } else {
                        etatLie.ajouteTransition(lettre.charValue(), map.get(duoRef));
                    }
                }
            }
        }
        union.setMapUnion(map);
        return union;

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String affiche() {
        return super.affiche();
    }

    /*
    Automate minimise(Automate automateNonMinimal) {
		return determinise(inverse(determinise(inverse(automateNonMinimal))));
	}
	  */
    
    /*
    Automate inverse(Automate automateTmp) {

        Etat etatTmp = null;
        initiaux.clear();

        for (Etat etat : this) {
            // inverser les etats
            if (etat.isInit()) {
                etat.setInit(false);
                etat.setTerm(true);
            } else { // est terminale
                etat.setInit(true);
                etat.setTerm(false);
                initiaux.add(etat);
            }

            // inverser les transitions
            HashMap<Character, EnsEtat> tmpTransitions = etat.transitions;
            for (Character succ : tmpTransitions.keySet()) {
                if (etat.isInit()) {
                    etatTmp = new Etat(true, false);
                } else {
                    etatTmp = new Etat(false, true);
                }
                etatTmp.ajouteTransition(succ, etat);
                automateTmp.add(etatTmp);
            }
        }

        // l'automate transposé
        return automateTmp;
    }*/


    Automate remove_epsilon_transition(Automate a) {
        Automate res = a;
        Set<Etat> transitory = null;
        // ajout des transitions des etats
        for (Etat e : res) {
            transitory = e.getStateFromEpsilonTransition();
            if (!transitory.isEmpty()) {
                for (Etat etat : transitory) {
                    e.transitions.putAll(etat.transitions);
                }
            }
            // on retire les transition vide
            e.transitions.remove(' ');
        }


        return res;
    }

    public Automate determinise() {
        if (this.estDeterministe())
            return this;

        Automate det = new Automate();
        HashMap<EnsEtat, Etat> map = new HashMap<EnsEtat, Etat>();
        Stack<EnsEtat> pile = new Stack<EnsEtat>();
        Set<Character> alphabet = this.alphabet();
        ArrayList<EnsEtat> listEnsEtat = new ArrayList<EnsEtat>();
        int etatCompteur = 0;

        Etat initEtat = new Etat(true, false, etatCompteur++);
        det.ajouteEtatSeul(initEtat);
        EnsEtat init = new EnsEtat();
        for (Etat etat : initiaux) init.add(etat);
        map.put(init, initEtat);
        pile.push(init);
        listEnsEtat.add(init);

        while (!pile.empty()) {
            EnsEtat ensPop = pile.pop();
            //Recupere etat lie a l'ensemble d'etat pris dans la pile
            Etat etatLie = map.get(ensPop);
            //Parcours de l'alphabet de l'automate
            for (Character a : alphabet) {
                EnsEtat etatsLieSuccA = new EnsEtat();
                //Parcours de l'ensemble d'etats pris dans la pile
                for (Etat etatPop : ensPop) {
                    //Recupere les etats succeceurs a la lettre courante
                    EnsEtat etatsSucc = etatPop.succ(a.charValue());
                    if (etatsSucc != null) {
                        //Ajoute les etats successeurs a un ensemble des successeurs de la lettre courante
                        for (Etat tmp : etatsSucc) etatsLieSuccA.add(tmp);
                    }
                }

                //Si on a trouver des successeurs pour la lettre courante
                if (!etatsLieSuccA.isEmpty()) {
                    //Cherche si on a pas deja creer un ensemble d'etat correspondant
                    // aux successeurs de la lettre courante
                    boolean existeDeja = false;
                    EnsEtat refMemeEnsEtat = null;
                    for (EnsEtat listEtat : listEnsEtat) {
                        if (listEtat.egale(etatsLieSuccA)) {
                            refMemeEnsEtat = listEtat;
                            break;
                        }
                    }

                    //Si l'ensemble des successeurs de la lettre courante existe pas deja
                    if (refMemeEnsEtat == null) {
                        Etat nouvelEtat = new Etat(false, etatsLieSuccA.contientTerminal(), etatCompteur++);
                        det.ajouteEtatSeul(nouvelEtat);
                        map.put(etatsLieSuccA, nouvelEtat);
                        pile.push(etatsLieSuccA);
                        listEnsEtat.add(etatsLieSuccA);
                        etatLie.ajouteTransition(a.charValue(), nouvelEtat);
                    } else {
                        etatLie.ajouteTransition(a.charValue(), map.get(refMemeEnsEtat));
                    }
                }
            }
        }
        det.setMapDeterminise(map);
        if (Main.INFO) System.out.println("--- AUTOMATE DETERMINISE ---\n" + det);
        return det;
    }

    public Automate copy() {
        Automate cp = new Automate();
        for (Etat e : this) {
            cp.ajouteEtatSeul(new Etat(e.isInit(), e.isTerm(), e.hashCode()));
        }
        for (Etat e : cp) {
            Etat lie = this.getEtat(e.hashCode());
            for (Map.Entry<Character, EnsEtat> entre : lie.transitions.entrySet()) {
                for (Etat succ : entre.getValue()) {
                    e.ajouteTransition(entre.getKey().charValue(), cp.getEtat(succ.hashCode()));
                }
            }
        }
        return cp;
    }

    public Automate complete() {
        Automate copie = this.copy();
        Etat puit = null;
        boolean reussi = false;
        int i = 0;
        while (!reussi) {
            puit = new Etat(false, false, i);
            if (!copie.contains(puit)) {
                reussi = true;
            }
            i++;
        }

        copie.ajouteEtatSeul(puit);

        Set<Character> alphabet = copie.alphabet();
        for (Etat etat : copie) {
            for (Character a : alphabet) {
                if (etat.succ(a.charValue()) == null) {
                    etat.ajouteTransition(a.charValue(), puit);
                }
            }
        }
        return copie;
    }

    public Automate complementaire() {
        Automate det = this.determinise();
        det.complete();
        for (Etat etat : det) {
            etat.setTerm(!etat.isTerm());
        }
        return det;
    }

    public Automate miroir() {
        Automate miroir = new Automate();
        for (Etat etat : this) {
            miroir.ajouteEtatSeul(new Etat(etat.isTerm(), etat.isInit(), etat.hashCode()));
        }

        for (Etat etat : this) {
            for (Map.Entry<Character, EnsEtat> transition : etat.getTransitions().entrySet()) {
                for (Etat etatSucc : transition.getValue()) {
                    miroir.getEtat(etatSucc.hashCode()).ajouteTransition(transition.getKey(), etat);
                }
            }
        }

        return miroir;
    }

    public boolean accepte(String s) {
        return initiaux.accepte(s, 0);
    }

    public Automate minimisation() {
        if (this.estDeterministe()) return Moore.minimisation(this);
        else return Moore.minimisation(this.determinise());
    }

        public boolean estEgale(Automate test) {
        if (this.size() != test.size()) {
            System.out.println("Ne sont pas égaux : tailles differentes");
            return false;
        }

        if (!this.alphabet().equals(test.alphabet())) {
            System.out.println("Ne sont pas égaux : alphabets differents");
            return false;
        }

        HashMap<Etat, Etat> map = new HashMap<Etat, Etat>();
        ArrayList<Etat> liste = new ArrayList<Etat>();
        Stack<Etat> pile = new Stack<Etat>();
        Set<Character> alphabet = this.alphabet();

        if (this.initiaux.size() != 1 || test.initiaux.size() != 1) {
            System.out.println("Ne sont pas égaux : il y a pas ou plus d'un état initial");
            return false;
        }

        pile.push(this.initiaux.iterator().next());
        map.put(this.initiaux.iterator().next(), test.initiaux.iterator().next());

        while (!pile.isEmpty()) {
            Etat courant = pile.pop();
            Etat lie = map.get(courant);
            for (Character c : alphabet) {
                EnsEtat ensSucc = courant.succ(c);
                EnsEtat ensLieSucc = lie.succ(c);
                if (ensSucc.size() > 0 && ensLieSucc.size() > 0) {
                    if (ensSucc.size() != 1 || ensLieSucc.size() != 1) {
                        System.out.println("Ne sont pas égaux : non déterminisé");
                        return false;
                    }
                    Etat courantSucc = ensSucc.iterator().next();
                    if (!liste.contains(courantSucc)) {
                        Etat lieSucc = ensLieSucc.iterator().next();
                        liste.add(courantSucc);
                        map.put(courantSucc, lieSucc);
                        pile.push(courantSucc);
                    }
                }
            }
        }
        return true;
    }

    /*
     * TODO
     * ------------------------------------------------------------------------     
     */     
        
	public static Automate union(Automate automateTmp1,
			Automate automateTmp2) {
		// TODO automate reconnaissant l'union de deux automates
		return null;
	}

	public static Automate concatination(Automate automateTmp1,
			Automate automateTmp2) {
		// TODO automate reconnaissant la concatination de deux automates
		return null;
	}

	public static Automate debutRegExp() {
		// TODO  automate reconnaissant le debut de ligne
		return null;
	}	
	
	public static Automate finRegExp() {
		// TODO automate reconnaissant la fin de ligne
		return null;
	}
	
	public static enum SymboleDuplication {
		Etoile,
		Plus,    		
		Interrogation,
		Min,
		Exact,
		Min_Max,
	}
		
	// borne minimal pour la duplication	
	private static int min;
	//borne maximal pour la duplication
	private static int max;
	
	public static void setMin(int min) {
		Automate.min = min;
	}
	
	public static void setMax(int max) {
		Automate.max = max;
	}
	
	public static Automate dupliquer(Automate automateTmp, 
			SymboleDuplication symbole) {
		
		switch (symbole) {
			case Etoile: {
				return etoile(automateTmp);
			}
			case Plus: {
				return plus(automateTmp);
			}
			case Interrogation: {
				return interrogation(automateTmp);
			}
			case Exact: {
				return repeter(automateTmp, min);
			}
			case Min: {
				return repeterMin(automateTmp, min);
			}
			case Min_Max: {
				return repeterMinMax(automateTmp, min, max);
			}
			default: {
				System.out.println("Erreur!");
				return null;
			}
		}		
	}
	
	private static Automate etoile(Automate automateTmp) {
		// TODO automate reconnaisant la répitition {0, ++}
		return null;
	}
	
	private static Automate plus(Automate automateTmp) {
		// TODO automate reconnaisant la répitition {1, ++}
		return null;
	}
	
	private static Automate interrogation(Automate automateTmp) {
		// TODO automate reconnaisant un langage {0, 1} 
		return null;
	}
	
	private static Automate repeter(Automate automateTmp, int nbrDuplication) {
		// TODO automate resultant de la duplication de l'automate 
		return null;
	}
	
	private static Automate repeterMin(Automate automateTmp, int nbrDuplication) {
		// TODO automate resultant de la duplication de l'automate 
		return null;
	}
	
	private static Automate repeterMinMax(Automate automateTmp, 
			int minDuplication, int maxDuplication) {
		// TODO automate resultant de la duplication de l'automate 
		return null;
	}
	
	/*
     * Fin TODO
     * ------------------------------------------------------------------------     
     */	
}


























