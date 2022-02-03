package twisk.monde;

public class Activite {

    private int temps;
    private int ecartTemps;


    /**
     * constructeur de class activite
     * @param nom
     */
    public Activite(String nom){

    }



    /**
     * constructure de class activite
     * @param nom
     * @param t
     * @param e
     */
    public Activite(String nom, int t, int e){
        this.ecartTemps = e;
        this.temps = t;
    }

    public boolean estActivite(){
        return true;
    }

}
