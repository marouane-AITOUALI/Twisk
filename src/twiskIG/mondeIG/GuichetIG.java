package twiskIG.mondeIG;

import java.util.Iterator;

public class GuichetIG extends EtapeIG {

    public GuichetIG(String nom, String idf, int larg, int haut) {
        super(nom, idf, larg, haut);
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
