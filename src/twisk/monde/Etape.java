package twisk.monde;

import java.util.Iterator;

public abstract class Etape implements Iterable<Etape> {

    private String nom;
    private GestionnaireSuccesseurs gestionSucc;

    public Etape(String nom){
        this.nom = nom;
        gestionSucc = new GestionnaireSuccesseurs();
    }

    public void ajouterSuccesseur(Etape... e){
        gestionSucc.ajouter(e);
    }

    public abstract boolean estUneActivite();

    public String getNom(){
        return nom;
    }

    public abstract boolean estUnGuichet();


    @Override
    public Iterator<Etape> iterator() {
        return gestionSucc.iterator();
    }

}



