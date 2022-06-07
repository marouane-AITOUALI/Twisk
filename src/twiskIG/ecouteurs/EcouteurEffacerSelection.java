package twiskIG.ecouteurs;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import twiskIG.mondeIG.MondeIG;

public class EcouteurEffacerSelection implements EventHandler<ActionEvent> {

    private MondeIG mondeIG;

    public EcouteurEffacerSelection(MondeIG monde) {
        mondeIG = monde;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        mondeIG.effacerSelection();
    }
}
