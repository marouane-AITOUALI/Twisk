package twisk.monde;

import java.util.Iterator;

public class ActiviteRestreinte extends Activite{


    /**
     * constructeur de la class Activite Restriente
     * @param nom Nom de l'activité
     */
    public ActiviteRestreinte(String nom){
        super(nom);
    }

    public String toC(){
        Iterator<Etape> iterator = this.iterator();
        if(iterator.hasNext()){
            return iterator.next().toC();
        }
        return "";
    }

    /**
     * constructeur de la class Activite Restriente
     * @param nom
     */
    public ActiviteRestreinte(String nom, int t, int e) {
        super(nom, t, e);
    }
}
