package twiskIG.vues;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import twiskIG.ecouteurs.EcouteurPointDeControle;
import twiskIG.mondeIG.MondeIG;
import twiskIG.mondeIG.PointDeControleIG;


public class VuePointDeControleIG extends Circle implements Observateur{

    private MondeIG mondeIG;
    private PointDeControleIG point;

    public VuePointDeControleIG(MondeIG monde, PointDeControleIG p){
        mondeIG = monde;
        point = p;
        this.setOnMouseClicked(new EcouteurPointDeControle(mondeIG, point));
        //mondeIG.ajouterObservateur(this);
        this.setCenterX((double)point.getX());
        this.setCenterY((double)point.getY());
        this.setRadius(5);
        Circle c = this;
        if(point.isSelected()){
            c.setFill(Color.GREEN);
        }else{
            c.setFill(Color.BROWN);
        }
    }


    @Override
    public void reagir() {


    }
}
