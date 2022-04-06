package twisk.monde;

public class SasEntree extends Activite {


    /**
     * constructeur de la class sosEntree
     */
    public SasEntree() {
        super("Entree", 4,2);
    }

    public String toC(){
        Etape next = this.iterator().next();
        return "    entrer("+this.getNom()+");\n    delai("+getTemps()+","+getEcartTemps()+");\n"
                +"    transfert("+this.getNom()+","
                + next.getNom()+");\n"+next.toC();
    }
}
