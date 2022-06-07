package twiskIG.mondeIG;


public class PointDeControleIG {
    private int x;
    private int y;
    private String identifiant;
    private EtapeIG etape;
    private boolean estSelectionne = false;

    public PointDeControleIG(int x, int y, String id, EtapeIG e){
        this.x = x;
        this.y= y;
        identifiant = id;
        etape = e;
    }

    public void setEstSelectionne(){
        estSelectionne = !estSelectionne;
    }

    public int getX() {
        return x;
    }

    public int getY(){
        return y;
    }

    public boolean isSelected() {
        return estSelectionne;
    }

    public String getIdentifiant(){
        return identifiant;
    }

    public EtapeIG getEtape(){
        return etape;
    }

    public boolean memeEtapeQue(PointDeControleIG pdc){
        return this.etape.getIdentifiant().equals(pdc.getEtape().getIdentifiant());
    }

}
