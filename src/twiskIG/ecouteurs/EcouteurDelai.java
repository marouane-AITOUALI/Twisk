package twiskIG.ecouteurs;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import twiskIG.mondeIG.MondeIG;

public class EcouteurDelai implements EventHandler<ActionEvent> {

    private MondeIG mondeIG;
    public EcouteurDelai(MondeIG monde) {
        mondeIG = monde;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

    }
}
