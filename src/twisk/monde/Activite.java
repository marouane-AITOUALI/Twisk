package twisk.monde;

import java.util.Iterator;
import java.util.Random;

public class Activite extends Etape{

    private int temps;
    private int ecartTemps;


    /**
     * constructeur de class activite, temps et écartTemps par défaut
     * @param nom Nom de l'activité
     */
    public Activite(String nom){
        super(nom);
        Random r = new Random();
        ecartTemps = 1 + r.nextInt(2);
        temps = 1 + ecartTemps;

    }

    /**
     * fonction qui verifie que la class est bien un guichet
     * @return Retourne true si l'étape est guichet, false sinon
     */
    @Override
    public boolean estUnGuichet() {
        return false;
    }


    /**
     * fonction qui verifie que la class est bien une Activite
     * @return true si l'étape est une activité, false sinon
     */
    @Override
    public boolean estUneActivite() {
        return true;
    }

    /**
     * Retourne le temps de l'activite
     * @return Retourne le temps de l'activité
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
        return getNom()+":  "+this.gestionSucc.nbEtapes()+" successeur - "+gestionSucc.toString();
    }

    public String toC(){
        StringBuilder s = new StringBuilder();
        Iterator<Etape> iterator = this.iterator();
        if(iterator.hasNext()){
            Etape etapeNext = iterator.next();
            s.append("    delai("+getTemps()+","+getEcartTemps()+");\n");
            s.append("    transfert("+this.getNom()+","+ etapeNext.getNom()+");\n");
            s.append(etapeNext.toC());

        }
        else{
            s.append("    transfert("+getNom()+",Sortie);\n");
        }


        return s.toString();
    }

}
