package twisk.monde;

public class Guichet extends Etape {

    private int nbJetons;


    /**
     * constructeur dela class guichet
     * @param nom
     */
    public Guichet(String nom){
        super(nom);

    }

    @Override
    public boolean estUneActivite() {
        return false;
    }

    @Override
    public boolean estUnGuichet() {
        return  true;
    }


    /**
     * fonctoin qui verifier que la class est bien un guichet
     * @return
     */
    @Override
    public boolean estunGuichet(){
        return true;
    }

    /**
     * construceur de la class guichet
     * @param nom
     * @param nb
     */
    public Guichet(String nom, int nb){
        super(nom);
        this.nbJetons = nb;

    }

    public String toString(){
        return "";
    }





}