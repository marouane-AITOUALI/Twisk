package twisk.monde;

import java.util.Iterator;

public abstract class Etape implements Iterable<Etape> {

    private String nom;
    private GestionnaireSuccesseurs gestionSucc;

    public Etape(String nom){
        this.nom = nom;
    }

    public void ajouterSuccesseur(Etape... e){
        gestionSucc.ajouter(e);
    }

    public abstract boolean estUneActivite();

    public abstract boolean estUnGuichet();


    @Override
    public Iterator<Etape> iterator() {
        return gestionSucc.iterator();
    }


}
