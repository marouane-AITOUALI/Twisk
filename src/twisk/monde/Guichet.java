package twisk.monde;

import java.util.Random;

public class Guichet extends Etape {

    private int nbJetons;


    /**
     * constructeur dela class guichet
     * @param nom
     */
    public Guichet(String nom){
        super(nom);
        Random r = new Random();
        nbJetons = 1+r.nextInt(4);

    }

    @Override
    public boolean estUneActivite() {
        return false;
    }

    /**
     * fonctoin qui verifier que la class est bien un guichet
     * @return
     */
    @Override
    public boolean estUnGuichet(){
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
        return ""+getNom();
    }





}
