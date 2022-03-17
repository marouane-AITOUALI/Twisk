package twisk.monde;

public class SasEntree extends Activite {


    /**
     * constructeur de la class sosEntree
     */
    public SasEntree() {
        super("Entree", 2,1);
    }

    public String toC(){
        return "    entrer("+this.getNom()+");\n    delai("+getTemps()+","+getEcartTemps()+");\n"
                +"    transfert("+this.getNom()+","
                + this.iterator().next().getNom()+");\n"+this.iterator().next().toC();
    }
}
