package twiskIG.mondeIG;

public class ArcIG {
    private PointDeControleIG point1;
    private PointDeControleIG point2;
    private boolean estAffiche;
    private boolean estSelectionne = false;

    public ArcIG(PointDeControleIG p1, PointDeControleIG p2){
        estAffiche = true;
        point1 = p1;
        point2 = p2;
    }

    public void setEstSelectionne(){
        estSelectionne = !estSelectionne;
    }

    public boolean getEstSelectionne(){
        return estSelectionne;
    }

    public PointDeControleIG getDepart() {
        return point1;
    }

    public boolean getEstAffiche(){
        return estAffiche;
    }

    public EtapeIG getEtapeDepart(){
        return point1.getEtape();
    }



    public EtapeIG getEtapeArrivee(){
        return point2.getEtape();
    }

    public PointDeControleIG getArrivee(){
        return point2;
    }

    public void setAffiche(boolean b) {
        this.estAffiche = b;
    }

    public boolean aCommeDebut(EtapeIG etapeArrivee) {
        String id = etapeArrivee.getIdentifiant();
        return getEtapeDepart().getIdentifiant().equals(id);
    }

    public boolean aCommeArrive(EtapeIG etapeDepart) {
        String id = etapeDepart.getIdentifiant();
        return getEtapeArrivee().getIdentifiant().equals(id);
    }
}
