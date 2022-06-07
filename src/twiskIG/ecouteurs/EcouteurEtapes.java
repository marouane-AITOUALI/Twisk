package twiskIG.ecouteurs;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import twiskIG.mondeIG.EtapeIG;
import twiskIG.mondeIG.MondeIG;

public class EcouteurEtapes implements EventHandler<MouseEvent> {

    private MondeIG mondeIG;
    private EtapeIG etapeIG;

    public EcouteurEtapes(MondeIG monde, EtapeIG etape) {
        mondeIG = monde;
        etapeIG = etape;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        etapeIG.setEstSelectionnee();
        mondeIG.notifierObservateurs();

    }
}
