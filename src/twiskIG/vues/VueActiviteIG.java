package twiskIG.vues;

import javafx.scene.layout.HBox;
import twiskIG.mondeIG.EtapeIG;
import twiskIG.mondeIG.MondeIG;

public class VueActiviteIG extends VueEtapeIG implements Observateur{

    private HBox clients = new HBox();
    private MondeIG mondeIG;

    public VueActiviteIG(MondeIG monde, EtapeIG etapeIG) {
        super(monde, etapeIG);
        mondeIG = monde;
        this.getChildren().add(clients);
        this.clients.setStyle("-fx-border-color: #0059FF;" +
                "-fx-background-insets: 0 0 -1 0, 0, 1,2;" +
                "-fx-background-radius: 3px, 3px, 2px, 1px;" +
                "-fx-border-width: 2px;" +
                "-fx-background-color: grey;");
        clients.setPrefSize(etapeIG.getHauteur(), etapeIG.getLargeur());

    }

    public HBox getBox(){
        return this.clients;
    }

    @Override
    public void reagir() {

    }
}
