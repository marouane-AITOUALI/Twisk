package twisk.monde;

public class SasSortie extends Activite {


    /**
     * constructeur de la classe sosSortie
     */
    public SasSortie() {
        super("Sortie", 4, 2);
    }

    public String toString(){
        return "Sortie: 0 successeur -";
    }

    public String toC(){
        return "";
    }
}
