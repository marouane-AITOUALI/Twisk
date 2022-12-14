package twisk.monde;

import java.util.ArrayList;
import java.util.Iterator;

public class GestionnaireSuccesseurs implements Iterable<Etape> {

    private ArrayList<Etape> etapes;

    public GestionnaireSuccesseurs(){
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

    public String toString(){
        StringBuilder s = new StringBuilder();
        for(int i =0; i < nbEtapes();i++){
            s.append(etapes.get(i).getNom());
            if(i != nbEtapes()){
                s.append(" ");
            }
        }
        return s.toString();

    }
}
