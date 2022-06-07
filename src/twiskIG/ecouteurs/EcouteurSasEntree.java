package twiskIG.ecouteurs;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import twiskIG.mondeIG.MondeIG;

public class EcouteurSasEntree implements EventHandler<ActionEvent> {

    private MondeIG mondeIG;

    public EcouteurSasEntree(MondeIG monde) {
        mondeIG = monde;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        mondeIG.setSasEntree();
    }
}
