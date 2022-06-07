package twiskIG.vues;

import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import twiskIG.ecouteurs.EcouteurArc;
import twiskIG.mondeIG.ArcIG;
import twiskIG.mondeIG.MondeIG;

public class VueArcIG extends Pane implements Observateur{

    public VueArcIG(MondeIG monde, ArcIG arc){
        Line ligne = dessinerLigne(arc);
        Polygon p = dessinerTriangle(ligne, arc);
        this.getChildren().addAll(ligne,p);
        this.setOnMouseClicked(new EcouteurArc(arc, monde));
        if(arc.getEstSelectionne()){
            ligne.setFill(Color.RED);
            ligne.setStroke(Color.RED);
            p.setFill(Color.RED);
            ligne.setStrokeWidth(5);
            p.setStrokeWidth(5);
        }

    }

    public Line dessinerLigne(ArcIG a){
        Line ligne = new Line();
        ligne.setStartX(a.getDepart().getX());
        ligne.setStartY(a.getDepart().getY());
        ligne.setEndX(a.getArrivee().getX());
        ligne.setEndY(a.getArrivee().getY());
        ligne.setStrokeWidth(3);
        return ligne;
    }

    public Polygon dessinerTriangle(Line l, ArcIG a){
        Polygon triangle = new Polygon();
        Point2D point1 = new Point2D(l.getEndX(), l.getEndY() - 10);
        Point2D point2 = new Point2D(l.getEndX(), l.getEndY() + 10);
        Point2D point3 = new Point2D(l.getEndX() + 10, l.getEndY());
        triangle.getPoints().addAll(point1.getX(),point1.getY(),
                point3.getX(), point3.getY(),
                point2.getX(), point2.getY());


        return triangle;
    }


    @Override
    public void reagir() {

    }
}
