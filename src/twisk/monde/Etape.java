package twisk.monde;

import java.util.Iterator;

public abstract class Etape implements Iterable<Etape> {

    private String nom;
    private GestionnaireSuccesseurs

    public Etape(String nom){
        this.nom = nom;
    }


    @Override
    public Iterator<Etape> iterator() {
        return null;
    }
}
