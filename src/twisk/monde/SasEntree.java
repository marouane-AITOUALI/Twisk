package twisk.monde;

public class SasEntree extends Activite {


    /**
     * constructeur de la class sosEntree
     */
    public SasEntree() {
        super("Entree");
    }

    public String toC(){
        return "entrer("+this.getNom()+"), delai("+getTemps()+","+getEcartTemps()+")\n"
                +this.iterator().next().toC();
    }
}
