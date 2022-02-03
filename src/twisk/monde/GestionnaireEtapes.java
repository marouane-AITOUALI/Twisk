package twisk.monde;

import java.util.ArrayList;
import java.util.Iterator;

public class GestionnaireEtapes implements Iterable<Etape> {

    private ArrayList<Etape> etapes;

    public GestionnaireEtapes(){
        etapes = new ArrayList<>();
    }

    void ajouter(Etape... etapes){
        for (int i = 0; i < etapes.length; i++){
            this.etapes.add(etapes[i]);
        }
    }

    public int nbEtapes(){
        return etapes.size();
    }

    @Override
    public Iterator<Etape> iterator() {
        return etapes.iterator();
    }


}