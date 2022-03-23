package twisk.monde;

import twisk.outils.FabriqueNumero;

import java.util.Iterator;

public abstract class Etape implements Iterable<Etape> {

    protected String nom;
    protected GestionnaireSuccesseurs gestionSucc;
    protected int numEtape;




    /**
     * constructeur de la classe Etape
     * @param nom Nom de l'étape
     */
    public Etape(String nom){
        this.nom = nom;
        gestionSucc = new GestionnaireSuccesseurs();
        numEtape = FabriqueNumero.getInstance().getNumeroEtape();
    }

    public int nbSuccesseurs(){
        return gestionSucc.nbEtapes();
    }

    public void setNumEtape(int num){
        numEtape = num;
    }

    /**
     * fonction qui ajoute un successeur
     */
    public void ajouterSuccesseur(Etape... e){
        gestionSucc.ajouter(e);
    }


    /**
     * fonction qui verifie qu'il s'agit d'une activite
     * @return true, si l'étape est une activité, false sinon
     */
    public abstract boolean estUneActivite();

    /**
     * Retourne le nom d'etape
     * @return Retourne le nom de l'étape
     */
    public String getNom(){
        return nom;
    }


    /**
     * Retourne s'il s'agit d'un guichet
     * @return true, si l'etape est un giuchet , false sinon
     */
    public abstract boolean estUnGuichet();


    /**
     * Retourne le numéro de l'étape
     * @return Numero de l'étape
     */
    public int getNumEtape(){
        return numEtape;
    }


    public abstract String toC();

    /**
     * Retourne l'itérateur de l'étape
     * @return Retourne Iterator<Etape>
     */
    @Override
    public Iterator<Etape> iterator() {
        return gestionSucc.iterator();
    }

}



