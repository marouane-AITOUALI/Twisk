package twiskIG.vues;

import javafx.scene.layout.Pane;
import twiskIG.ecouteurs.EcouteurDragDrop;
import twiskIG.ecouteurs.EcouteurDragOver;
import twiskIG.mondeIG.*;

import java.util.Iterator;

public class VueMondeIG extends Pane implements Observateur{

    private MondeIG mondeIG;

    public VueMondeIG(MondeIG monde){
        mondeIG = monde;
        mondeIG.ajouterObservateur(this);
        for(EtapeIG e: mondeIG){
            VueActiviteIG ee = new VueActiviteIG(mondeIG, e);
            this.getChildren().add(ee);
        }
        this.setOnDragOver(new EcouteurDragOver());
        this.setOnDragDropped(new EcouteurDragDrop(monde));
    }


    @Override
    public void reagir() {
        this.getChildren().clear();

        Iterator<ArcIG> iteratorArc = mondeIG.iteratorArcIG();
        while (iteratorArc.hasNext()){
            ArcIG arcIG = iteratorArc.next();
            if(arcIG.getEstAffiche()){
                VueArcIG vueArcIG = new VueArcIG(mondeIG, arcIG);
                this.getChildren().add(vueArcIG);
            }
        }

        for(EtapeIG e: mondeIG){
            if(e.getEstAffiche()){
                if(e.estUneActivite()){
                    VueActiviteIG vueActiviteIG = new VueActiviteIG(mondeIG, e);
                    this.getChildren().add(vueActiviteIG);
                    for(PointDeControleIG p: e){
                        VuePointDeControleIG vuePointDeControleIG = new VuePointDeControleIG(mondeIG,p);
                        this.getChildren().add(vuePointDeControleIG);
                    }

                }
                else{
                    VueGuichetIG vueGuichetIG = new VueGuichetIG(mondeIG, e);
                    this.getChildren().add(vueGuichetIG);
                    for(PointDeControleIG p: e){
                        VuePointDeControleIG vuePointDeControleIG = new VuePointDeControleIG(mondeIG,p);
                        this.getChildren().add(vuePointDeControleIG);
                    }
                }

            }
        }

    }

}

