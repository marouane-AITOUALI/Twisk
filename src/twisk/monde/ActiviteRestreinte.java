package twisk.monde;

public class ActiviteRestreinte extends Activite{


    /**
     * constructeur de la class Activite Restriente
     * @param nom Nom de l'activité
     */
    public ActiviteRestreinte(String nom){
        super(nom);
    }

    public String toC(){
        return iterator().next().toC();
    }

    /**
     * constructeur de la class Activite Restriente
     * @param nom
     */
    public ActiviteRestreinte(String nom, int t, int e) {
        super(nom, t, e);
    }
}
