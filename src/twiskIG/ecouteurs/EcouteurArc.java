package twiskIG.ecouteurs;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import twiskIG.mondeIG.ArcIG;
import twiskIG.mondeIG.MondeIG;

public class EcouteurArc implements EventHandler<MouseEvent> {

    private MondeIG mondeIG;
    private ArcIG arcIG;

    public EcouteurArc(ArcIG arc, MondeIG monde) {
        mondeIG = monde;
        arcIG = arc;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        arcIG.setEstSelectionne();
        mondeIG.notifierObservateurs();
    }
}
