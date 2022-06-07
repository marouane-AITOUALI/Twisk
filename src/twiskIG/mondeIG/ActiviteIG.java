package twiskIG.mondeIG;

import java.util.Arrays;
import java.util.Iterator;

public class ActiviteIG extends EtapeIG {

    public ActiviteIG(String nom, String idf, int larg, int haut) {
        super(nom, idf, larg, haut);
    }

    @Override
    public Boolean estUneActivite() {
        return true;
    }

    @Override
    public Boolean estUnGuichet() {
        return false;
    }


    @Override
    public Iterator<PointDeControleIG> iterator() {
        return pdc.iterator();
    }

}
