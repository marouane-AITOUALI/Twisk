package twiskIG.mondeIG;

import java.util.Iterator;

public class GuichetIG extends EtapeIG {

    protected int nbJetons = 3;

    public GuichetIG(String nom, String idf, int larg, int haut) {
        super(nom, idf, larg, haut);
    }

    public int getNbJetons(){
        return nbJetons;
    }

    public void setNbJetons(int nbJetons){
        this.nbJetons = nbJetons;
    }

    @Override
    public Boolean estUneActivite() {
        return false;
    }

    @Override
    public Boolean estUnGuichet() {
        return true;
    }

    @Override
    public Iterator<PointDeControleIG> iterator() {
        return pdc.iterator();
    }
}
