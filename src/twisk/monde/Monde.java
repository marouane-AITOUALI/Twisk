package twisk.monde;

import java.util.ArrayList;
import java.util.Iterator;

public class Monde implements Iterable<Etape> {

    private SasSortie SasSortie;
    private SasEntree SasEntree;
    private GestionnaireEtapes gestionEtape;

    /**
     * Constructeur de la classe Monde
     */
    public Monde(){
        SasSortie = new SasSortie();
        SasEntree = new SasEntree();
        gestionEtape = new GestionnaireEtapes();
        this.ajouter(this.SasEntree, this.SasSortie);
    }

    /**
     * fonction qui ajoute les entrées du monde
     * @param etapes Etapes à rajouter dans l'entrée
     */
    public void aCommeEntree(Etape... etapes){
        this.SasEntree.ajouterSuccesseur(etapes);
    }

    /**
     * fonction qui ajoute les sorties du monde
     * @param etapes Etapes à rajouter dans la sortie
     */
    public void aCommeSortie(Etape... etapes){
        this.SasSortie.ajouterSuccesseur(etapes);
    }

    /**
     * fonction qui ajoute les étapes
     * @param etapes Etapes à ajouter dans le monde
     */
    public void ajouter(Etape... etapes){
        gestionEtape.ajouter(etapes);
    }

    /**
     * fonction qui retourne le nombre des etapes
     * @return Nombre des Etapes
     */
    public int nbEtapes(){
        return gestionEtape.nbEtapes();
    }

    /**
     * fonction qui retourne le nombre de guichet
     * @return Nombre des guichets guichet
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
