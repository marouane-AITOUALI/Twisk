package twisk.monde;

import java.util.ArrayList;
import java.util.Iterator;

public class Monde implements Iterable<Etape> {

    private ArrayList<Etape> SasSortie;
    private ArrayList<Etape> SasEntree;
    private GestionnaireEtapes gestionEtape;

    /**
     * costructeur de la class Monde
     */
    public Monde(){
        SasSortie = new ArrayList<>();
        SasEntree = new ArrayList<>();
        gestionEtape = new GestionnaireEtapes();
    }

    /**
     * fonction qui verifie si a est une entree
     */
    public void aCommeEntree(Etape... etapes){
        for(int i = 0; i < etapes.length;++i){
            SasEntree.add(etapes[i]);
        }
    }

    /**
     * fonction qui verifie si a est une sorie
     * @param etapes Etapes à ajouter
     */
    public void aCommeSortie(Etape... etapes){
        for(int i = 0; i < etapes.length;++i){
            SasSortie.add(etapes[i]);
        }
    }

    /**
     * fonction qui ajoute des etapes
     * @param etapes Etapes à ajouter
     */
    public void ajouter(Etape... etapes){
        gestionEtape.ajouter(etapes);
    }

    /**
     * fonction sui retourne le nombre des etapes
     * @return nbr des Etapes
     */
    public int nbEtapes(){
        return gestionEtape.nbEtapes();
    }

    /**
     * fonction qui retourne le nombre de guichet
     * @return nbr guichet
     */
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
