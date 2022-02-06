package twisk.monde;

import java.util.ArrayList;
import java.util.Iterator;

public class Monde implements Iterable<Etape> {

    private ArrayList<Etape> SasSortie;
    private ArrayList<Etape> SasEntree;
    private GestionnaireEtapes gestionEtape;

    public Monde(){
        SasSortie = new ArrayList<>();
        SasEntree = new ArrayList<>();
        gestionEtape = new GestionnaireEtapes();
    }

    public void aCommeEntree(Etape... etapes){
        for(int i = 0; i < etapes.length;++i){
            SasEntree.add(etapes[i]);
        }
    }

    public void aCommeSortie(Etape... etapes){
        for(int i = 0; i < etapes.length;++i){
            SasSortie.add(etapes[i]);
        }
    }

    public void ajouter(Etape... etapes){
        gestionEtape.ajouter(etapes);
    }

    public int nbEtapes(){
        return gestionEtape.nbEtapes();
    }

    public int nbGuichets(){
        int nombre = 0;
        Iterator<Etape> iterator = gestionEtape.iterator();
        while(iterator.hasNext()){
            Etape etape = iterator.next();
            if(etape.estUnGuichet()){
                nombre++;
            }
        }
        return nombre;
    }

    public Iterator<Etape> iterator(){
        return gestionEtape.iterator();
    }
}
