package twiskIG.vues;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import twiskIG.mondeIG.EtapeIG;
import twiskIG.mondeIG.GuichetIG;
import twiskIG.mondeIG.MondeIG;

public class VueGuichetIG extends VueEtapeIG implements Observateur {

    private EtapeIG etapeIG;
    private HBox clients = new HBox();
    private MondeIG mondeIG;

    public VueGuichetIG(MondeIG monde, EtapeIG e) {
        super(monde, e);
        mondeIG = monde;
        etapeIG = e;
        this.getChildren().add(clients);
        this.label.setText(e.getNom()+": "+((GuichetIG)e).getNbJetons()+" jetons");
        this.clients.setStyle("-fx-border-color: #967FA4;" +
                "-fx-background-insets: 0 0 -1 0, 0, 1,2;" +
                "-fx-background-radius: 3px, 3px, 2px, 1px;" +
                "-fx-border-width: 4px;" +
                "-fx-background-color: white;");
        clients.setPrefSize(etapeIG.getHauteur(), etapeIG.getLargeur());

    }

    @Override
    public void reagir() {

    }
}
