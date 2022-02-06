package twisk.monde;

import java.util.ArrayList;
import java.util.Iterator;

public class GestionnaireEtapes implements Iterable<Etape> {

    private ArrayList<Etape> etapes;

    /**
     * contructeur de la class getionnaireEtapes
     */
    public GestionnaireEtapes(){
        etapes = new ArrayList<>();
    }


    /**
     * fonction qui ajoute des etapes
     * @param etapes
     */
    void ajouter(Etape... etapes){
        for (int i = 0; i < etapes.length; i++){
            this.etapes.add(etapes[i]);
        }
    }

    /**
     * fonction qui retourne le nombre des Etaps
     * @return
     */
    public int nbEtapes(){
        return etapes.size();
    }

    @Override
    public Iterator<Etape> iterator() {
        return etapes.iterator();
    }


}