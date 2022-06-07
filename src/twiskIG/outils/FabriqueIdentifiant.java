package twiskIG.outils;

public class FabriqueIdentifiant {

    private static FabriqueIdentifiant instance = new FabriqueIdentifiant();
    private int noEtape = 0;

    public static FabriqueIdentifiant getInstance(){
        return instance;
    }

    public String getIdentifiantEtape(){
        noEtape++;
        return "Etape"+noEtape;
    }
}
