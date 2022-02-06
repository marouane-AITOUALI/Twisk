package twisk.monde;

import java.util.Random;

public class Activite extends Etape{

    private int temps;
    private int ecartTemps;


    /**
     * constructeur de class activite
     * @param nom
     */
    public Activite(String nom){
        super(nom);
        Random r = new Random();
        temps = 1 + r.nextInt(3);
        ecartTemps = 1 + r.nextInt(2);
    }

    /**
     * fonction qui verifie que la class est bien un guichet
     * @return
     */
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

    /**
     * fonction qui verifie que la class est bien une Activite
     * @return
     */
    @Override
    public boolean estUneActivite() {
        return true;
    }

    /**
     * fonction qui retourne le temps de l'activite
     * @return
     */
    public int getTemps(){
        return this.temps;
    }

    /**
     * fonction qui retourne le temps d'ecarte
     * @return
     */
    public int getEcartTemps(){
        return this.ecartTemps;
    }

    /**
     * Retourne le nom de l'étape, temps et l'écart temps
     * @return Nom de l'étape, son temps et son écart temps
     */
    public String toString(){
        return "Activité "+getNom()+": Time "+getTemps()+" - EcartTemps :"+getEcartTemps();
    }

}
