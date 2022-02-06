package twisk.monde;

import twisk.outils.FabriqueNumero;

import java.util.Iterator;

public abstract class Etape implements Iterable<Etape> {

    private String nom;
    private GestionnaireSuccesseurs gestionSucc;
    private int numEtape;

    /**
     * constructeur de la class Etapes
     * @param nom
     */
    public Etape(String nom){
        this.nom = nom;
        gestionSucc = new GestionnaireSuccesseurs();
        numEtape = FabriqueNumero.getInstance().getNumeroEtape();
    }

    /**
     * fonction qui ajout un successeur
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


    @Override
    public Iterator<Etape> iterator() {
        return gestionSucc.iterator();
    }

}



