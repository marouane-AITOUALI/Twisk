package twiskIG.mondeIG;

import java.util.Arrays;
import java.util.Iterator;

public class ActiviteIG extends EtapeIG {

    public ActiviteIG(String nom, String idf, int larg, int haut) {
        super(nom, idf, larg, haut);
    }

    @Override
    public boolean estUneActivite() {
        return true;
    }

    @Override
    public boolean estUnGuichet() {
        return false;
    }

    @Override
    public boolean estUneEntree() {
        return estUneEntree;
    }

    @Override
    public boolean estUneSortie() {
        return estUneSortie;
    }


    @Override
    public Iterator<PointDeControleIG> iterator() {
        return pdc.iterator();
    }

}