package twisk.outils;

public class FabriqueNumero {
    private int cptEtape = 0;
    private int cptSemaphore = 1;
    private int numLib = 1;

    /**
     */
    private static FabriqueNumero instance = new FabriqueNumero();

    /**
     * fonction pour retourner une instance de fabrique numero
     * @return Retourne l'instance de FabriqueNumero
     */
    public static FabriqueNumero getInstance(){
        return instance;
    }

    /**
     * constructeur dela class fabrique Numero
     */
    private FabriqueNumero(){
        this.instance = instance;
    }

    /**
     * fonction qui retourne le numero de semaphore
     * @return Retourne le numéro de sémaphore
     */
    public int getNumeroSemaphore(){
        return cptSemaphore++;
    }

    /**
     * fonction qui retourne le numero d'etapes
     * @return Retourne le nombre d'étapes
     */
    public int getNumeroEtape(){
        return cptEtape++;
    }

    /**
     * fonction qui réinitialise les compteurs
     */
    public void reset(){
        cptEtape = 0;
        cptSemaphore = 1;
    }

    public int getNumLib(){
        return numLib;
    }

    public int getNumLibLoad(){
        return numLib++;
    }

}
