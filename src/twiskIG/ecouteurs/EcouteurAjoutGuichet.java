package twiskIG.ecouteurs;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import twiskIG.mondeIG.MondeIG;

public class EcouteurAjoutGuichet implements EventHandler<ActionEvent> {

    private MondeIG mondeIG;
    public EcouteurAjoutGuichet(MondeIG mondeIG) {
        this.mondeIG = mondeIG;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        mondeIG.ajouter("Guichet");
    }
}
