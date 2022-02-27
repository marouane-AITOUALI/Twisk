package twisk.monde;

import java.util.ArrayList;
import java.util.Iterator;

public class Monde implements Iterable<Etape> {

    private SasSortie SasSortie;
    private SasEntree SasEntree;
    private GestionnaireEtapes gestionEtape;

    /**
     * costructeur de la class Monde
     */
    public Monde(){
        SasSortie = new SasSortie();
        SasEntree = new SasEntree();
        gestionEtape = new GestionnaireEtapes();
        this.ajouter(this.SasEntree, this.SasSortie);
    }

    /**
     * fonction qui verifie si a est une entree
     */
    public void aCommeEntree(Etape... etapes){
        this.SasEntree.ajouterSuccesseur(etapes);
    }

    /**
     * fonction qui verifie si a est une sorie
     * @param etapes Etapes à ajouter
     */
    public void aCommeSortie(Etape... etapes){
        this.SasSortie.ajouterSuccesseur(etapes);
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
