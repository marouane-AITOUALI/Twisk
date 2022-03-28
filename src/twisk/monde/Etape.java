package twisk.monde;

import twisk.outils.FabriqueNumero;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Pattern;

public abstract class Etape implements Iterable<Etape> {

    protected String nom;
    protected GestionnaireSuccesseurs gestionSucc;
    protected int numEtape;
    protected int indiceEtapeDuplique = 2;

    /**
     * constructeur de la classe Etape
     * @param nom Nom de l'étape
     */
    public Etape(String nom){
        nom = nom.replaceAll(" ", "_");
        nom = sansAccent(nom);
        gestionSucc = new GestionnaireSuccesseurs();
        this.nom = nom;
        numEtape = FabriqueNumero.getInstance().getNumeroEtape();
    }

    /**
     * Retourne s sans accent
     * @param s String à enlever les accents
     * @return String s passé en paramètre sans accent
     */
    public static String sansAccent(String s)
    {
        String strTemp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(strTemp).replaceAll("");
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
     * Modifie le nom de l'étape
     * @param nom Nouveau nom de l'étape
     */
    public void setNom(String nom){
        this.nom = nom;
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



