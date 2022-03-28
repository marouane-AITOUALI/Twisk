package twisk.monde;

import java.util.ArrayList;
import java.util.Iterator;

public class GestionnaireEtapes implements Iterable<Etape> {

    private ArrayList<Etape> etapes;

    /**
     * contructeur de la class getionnaireEtapes
     */
    public GestionnaireEtapes(){
        etapes = new ArrayList<>();
    }


    /**
     * fonction qui ajoute des etapes
     * @param etapes
     */
    void ajouter(Etape... etapes){
        for (int i = 0; i < etapes.length; i++){
            this.etapes.add(etapes[i]);
        }
    }

    /**
     * fonction qui retourne le nombre des Etaps
     * @return
     */
    public int nbEtapes(){
        return etapes.size();
    }

    public Etape getEtape(int i){
        return etapes.get(i);
    }


    public int getJetonsParSemaphore(int sem){
        for(Etape e: etapes){
            if(e.estUnGuichet()){
                if (((Guichet)e).getSemaphore() == sem){
                    return ((Guichet)e).getNbJetons();
                }
            }
        }
        return 0;
    }

    /**
     * Retourne l'iterateur du gestionnaire d'étapes
     * @return Iterateur de gestionnaire d'étapes
     */
    @Override
    public Iterator<Etape> iterator() {
        return etapes.iterator();
    }


}