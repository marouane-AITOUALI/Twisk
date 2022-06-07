package twiskIG.ecouteurs;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import twiskIG.mondeIG.MondeIG;

public class EcouteurAjoutActivite implements EventHandler<ActionEvent> {

    private MondeIG mondeIG;

    public EcouteurAjoutActivite(MondeIG monde){
        this.mondeIG = monde;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        mondeIG.ajouter("Activité");
    }
}
