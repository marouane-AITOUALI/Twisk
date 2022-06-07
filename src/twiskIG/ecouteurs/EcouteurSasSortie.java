package twiskIG.ecouteurs;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import twiskIG.mondeIG.MondeIG;

public class EcouteurSasSortie implements EventHandler<ActionEvent> {

    private MondeIG mondeIG;
    public EcouteurSasSortie(MondeIG monde){
        mondeIG = monde;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        mondeIG.setSasSortie();
    }
}
