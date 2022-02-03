package twisk.monde;

public class Activite extends Etape{

    private int temps;
    private int ecartTemps;


    /**
     * constructeur de class activite
     * @param nom
     */
    public Activite(String nom){
        super(nom);

    }

    /**
     * fonction qui verifie que la class est bien une Activite
     * @return
     */
    @Override
    public boolean estUneActivite() {
        return true;
    }

    @Override
    public boolean estUnGuichet() {
        return false;
    }


    /**
     * constructure de class activite
     * @param nom
     * @param t
     * @param e
     */
    public Activite(String nom, int t, int e){
        super(nom);
        this.ecartTemps = e;
        this.temps = t;
    }


}
