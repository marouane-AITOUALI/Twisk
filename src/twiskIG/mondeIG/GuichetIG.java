package twiskIG.mondeIG;

import java.util.Iterator;

public class GuichetIG extends EtapeIG {

    protected int nbJetons = 3;

    public GuichetIG(String nom, String idf, int larg, int haut) {
        super(nom, idf, larg, haut);
    }

    @Override
    public boolean estUneEntree() {
        return false;
    }

    @Override
    public boolean estUneSortie() {
        return false;
    }

    public int getNbJetons(){
        return nbJetons;
    }

    public void setNbJetons(int nbJetons){
        this.nbJetons = nbJetons;
    }

    @Override
    public boolean estUneActivite() {
        return false;
    }

    @Override
    public boolean estUnGuichet() {
        return true;
    }

    @Override
    public Iterator<PointDeControleIG> iterator() {
        return pdc.iterator();
    }
}
