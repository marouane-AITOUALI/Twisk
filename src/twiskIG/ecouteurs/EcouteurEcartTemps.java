package twiskIG.ecouteurs;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import twiskIG.mondeIG.MondeIG;

public class EcouteurEcartTemps implements EventHandler<ActionEvent> {

    private MondeIG mondeIG;
    public EcouteurEcartTemps(MondeIG monde) {
        mondeIG = monde;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

    }
}
