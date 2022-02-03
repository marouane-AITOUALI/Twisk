package twisk.monde;

public class Guichet extends Etape {

    private int nbjetons;


    /**
     * constructeur dela class guichet
     * @param nom
     */
    public Guichet(String nom){
        super(nom);

    }

    /**
     * construceur de la class guichet
     * @param nom
     * @param nb
     */
    public Guichet(String nom, int nb){
        super(nom);
        this.nbjetons = nb;

    }

    /**
     * fonctoin qui verifier que la class est bien un guichet
     * @return
     */
    public boolean estUnGuichet(){
        return true;
    }


}
