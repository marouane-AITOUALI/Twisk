package twisk.monde;

import twisk.outils.FabriqueNumero;

import java.util.Iterator;

public abstract class Etape implements Iterable<Etape> {

    private String nom;
    private GestionnaireSuccesseurs gestionSucc;
    private int numEtape;

    public Etape(String nom){
        this.nom = nom;
        gestionSucc = new GestionnaireSuccesseurs();
        numEtape = FabriqueNumero.getInstance().getNumeroEtape();
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



