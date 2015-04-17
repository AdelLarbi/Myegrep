package automate;
/**
 * Created by nizar on 16/04/15.
 */
public class EtatMoore {
    /**
     * Etat correspondant dans l'automate
     */
    public Etat etat;

    /**
     * Bilan de depart de l'etape pour le mot vide
     */
    public int motVide;

    /**
     * Bilan de fin d'etape
     */
    public int bilan;

    /**
     * Valeur des transitions pour chaque lettre de l'alphabet de l'automate
     */
    public int[] transitions;

    /**
     * Constructeur
     *
     * @param etat etat correspondant dans l'automate
     * @param size cardinal de l'alphabet de l'automate
     */
    public EtatMoore(Etat etat, int size) {
        this.etat = etat;
        this.motVide = (etat.isTerm()) ? 2 : 1;
        this.bilan = 0;
        this.transitions = new int[size];
    }


}
