package twisk.outils;

public class FabriqueNumero {
    private int cptEtape = 0;
    private int cptSemaphore = 0;

    private static FabriqueNumero instance = new FabriqueNumero();

    public static FabriqueNumero getInstance(){
        return instance;
    }

    private FabriqueNumero(){
        this.instance = instance;
    }

    public int getNumeroSemaphore(){
        return cptSemaphore++;
    }

    public int getNumeroEtape(){
        return cptEtape++;
    }

    public void reset(){
        cptEtape = 0;
    }

}
