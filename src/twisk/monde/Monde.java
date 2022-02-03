package twisk.monde;

import java.util.ArrayList;
import java.util.Iterator;

public class Monde implements Iterable<Etape> {

    private ArrayList<Etape> SasSortie;
    private ArrayList<Etape> SasEntree;
    private GestionnaireEtapes gestionEtape;

    public Monde(){

    }

    public void aCommeEntree(Etape... etapes){

    }

    public void aCommeSortie(Etape... etapes){

    }

    public void ajouter(Etape... etapes){

    }

    public int nbEtapes(){
        return 0;
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
        return null;
    }
}
