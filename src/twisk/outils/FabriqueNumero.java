package twisk.outils;

public class FabriqueNumero {
    private int cptEtape = 0;
    private int cptSemaphore = 1;

    /**
     */
    private static FabriqueNumero instance = new FabriqueNumero();

    /**
     * fonction pour retourner une instance de fabrique numero
     * @return
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
     * @return
     */
    public int getNumeroSemaphore(){
        return cptSemaphore++;
    }

    /**
     * fonction qui retourne le numero d'etapes
     * @return
     */
    public int getNumeroEtape(){
        return cptEtape++;
    }

    /**
     * fonction qui réinitialise les compteurs
     */
    public void reset(){
        cptEtape = 0;
        cptSemaphore = 0;
    }

}
