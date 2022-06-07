package twiskIG.mondeIG;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public abstract class EtapeIG implements Iterable<PointDeControleIG> {

    protected String nom;
    protected String identifiant;
    protected ArrayList<PointDeControleIG> pdc = new ArrayList<>();
    protected int posX;
    protected int posY;
    protected int largeur;
    protected boolean estSelectionnee = false;
    protected boolean estUneEntree = false;
    protected boolean estUneSortie = false;
    protected boolean estAffiche = true;
    protected int hauteur;


    public EtapeIG(String nom, String idf, int larg, int haut){
        Random r = new Random();
        this.nom = nom;
        this.identifiant = idf;
        this.posX = r.nextInt(600);
        this.posY = r.nextInt(600);
        this.largeur = larg;
        this.hauteur = haut;
        ajouterPointDeControle();
    }

    public boolean getEstAffiche(){
        return estAffiche;
    }

    public void setEstAffiche(boolean b){
        estAffiche = b;
    }

    public void setEstSelectionnee(){
        estSelectionnee = !estSelectionnee;
    }

    public Iterator<PointDeControleIG> pdcIterator(){
        return pdc.iterator();
    }

    public void ajouterPointDeControle() {
        EtapeIG e = this;
        pdc.add(new PointDeControleIG(posX, posY+(hauteur/2),identifiant,e));
        pdc.add(new PointDeControleIG(posX + (largeur/2), posY, identifiant, e));
        pdc.add(new PointDeControleIG(posX+(largeur/2),posY+hauteur,identifiant,e));
        pdc.add(new PointDeControleIG(posX+largeur,posY+(hauteur/2),identifiant,e));
    }

    public String getNom(){
        return this.nom;
    }

    public int getPosX(){
        return this.posX;
    }

    public void setPosX(int x){
        posX = x;
    }

    public void setPosY(int y){
        posY = y;
    }

    public int getPosY(){
        return this.posY;
    }

    public int getLargeur(){
        return this.largeur;
    }

    public int getHauteur(){
        return this.hauteur;
    }

    public String getIdentifiant(){
        return this.identifiant;
    }

    public boolean estSelectionnee() {
        return estSelectionnee;
    }

    public void renommer(String nom) {
        this.nom = nom;
    }

    public void viderPointDeControle() {
        pdc.clear();
    }

    public abstract boolean estUneActivite();

    public abstract boolean estUnGuichet();

    public abstract boolean estUneEntree();

    public abstract boolean estUneSortie();

}