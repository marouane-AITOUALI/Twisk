package twiskIG.vues;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import twiskIG.ecouteurs.EcouteurDragEtape;
import twiskIG.ecouteurs.EcouteurEtapes;
import twiskIG.mondeIG.EtapeIG;
import twiskIG.mondeIG.MondeIG;

public abstract class VueEtapeIG extends VBox implements Observateur{

    private EtapeIG etapeIG;
    private MondeIG mondeIG;
    protected Label label;

    public VueEtapeIG(MondeIG monde, EtapeIG e){
        this.mondeIG = monde;
        this.etapeIG = e;
        this.setOnMouseClicked(new EcouteurEtapes(mondeIG, etapeIG));
        this.setOnDragDetected(new EcouteurDragEtape(this, e.getIdentifiant()));
        this.setPrefHeight(etapeIG.getHauteur());
        this.setPrefWidth(etapeIG.getLargeur());
        label = new Label(this.etapeIG.getNom());
        if (e.estSelectionnee()){
            this.setStyle("-fx-border-color: Blue;" +
                    "-fx-background-insets: 0 0 -1 0, 0, 1,2;" +
                    "-fx-border-radius: 3px;" +
                    "-fx-border-width: 3px;");
        }
        else{
            this.setStyle("-fx-border-color: black;" +
                    "-fx-background-insets: 0 0 -1 0, 0, 1,2;" +
                    "-fx-border-radius: 3px;" +
                    "-fx-border-width: 2px;");
        }
        this.getChildren().add(label);
        this.relocate(etapeIG.getPosX(), etapeIG.getPosY());


    }

}
