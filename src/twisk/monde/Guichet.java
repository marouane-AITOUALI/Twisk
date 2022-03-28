package twisk.monde;

import twisk.outils.FabriqueNumero;

import java.util.Iterator;
import java.util.Random;

public class Guichet extends Etape {

    private int nbJetons;
    private int semaphore;


    /**
     * constructeur dela class guichet
     * @param nom Nom du guichet
     */
    public Guichet(String nom){
        super(nom);
        Random r = new Random();
        nbJetons = 1+r.nextInt(4);
        semaphore = FabriqueNumero.getInstance().getNumeroSemaphore();
    }

    /**
     * construceur de la class guichet
     * @param nom Nom du guichet
     * @param nb Nombre de jetons
     */
    public Guichet(String nom, int nb){
        super(nom);
        this.nbJetons = nb;
        semaphore = FabriqueNumero.getInstance().getNumeroSemaphore();
    }

    /**
     * Retourne le numero de semaphore
     * @return Retourne le numero de semaphore
     */
    public int getSemaphore(){
        return semaphore;
    }

    @Override
    public boolean estUneActivite() {
        return false;
    }

    /**
     * Retourne le nombre de jetons du guichet
     * @return Nombre de jetons du guichet
     */
    public int getNbJetons(){
        return nbJetons;
    }

    /**
     * fonction qui vérifie que l'étape est bien un guichet
     * @return True, si l'étape est un guichet, false sinon
     */
    @Override
    public boolean estUnGuichet(){
        return true;
    }

    /**
     * fonction qui retourne le code C en chaine de caractere
     * @return
     */
    @Override
    public String toC() {
        StringBuilder s = new StringBuilder();
        Iterator<Etape> iterator = this.iterator();
        ActiviteRestreinte etapeNext = (ActiviteRestreinte) iterator.next();
        s.append("\n    P(ids,num_sem_"+getNom()+");\n");
        s.append("        transfert("+this.getNom()+","+etapeNext.getNom()+");\n");
        s.append("        delai("+etapeNext.getTemps()+","+etapeNext.getEcartTemps()+");\n");
        s.append("    V(ids,num_sem_"+getNom()+");\n");

        if (etapeNext.iterator().hasNext()){
            Etape next = etapeNext.iterator().next();
            s.append("    transfert("+etapeNext.getNom()+","
                    +next.getNom()+");\n");
            if (next.iterator().hasNext()){
                s.append(next.toC());
            }
            else{
                s.append("    transfert("+next.getNom()+",Sortie);\n");
            }
        }
        else{
            s.append("    transfert("+etapeNext.getNom()+",Sortie);\n");
        }






        return s.toString();
    }


    /**
     * Retourne Nom du guichet et le nombre de jetons
     * @return Nom du guichet et le nombre de jetons
     */
    public String toString(){
        return getNom()+":  "+this.gestionSucc.nbEtapes()+" successeur - "+gestionSucc.toString();
    }





}
