package twiskIG.ecouteurs;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import twiskIG.exceptions.TwiskException;
import twiskIG.mondeIG.MondeIG;
import twiskIG.mondeIG.PointDeControleIG;

public class EcouteurPointDeControle implements EventHandler<MouseEvent> {
    private MondeIG monde;
    private PointDeControleIG point;

    public EcouteurPointDeControle(MondeIG mondeIG, PointDeControleIG p) {
        monde = mondeIG;
        point = p;
    }



    @Override
    public void handle(MouseEvent mouseEvent) {
        try {
            monde.pointDeControleSelectionne(point);

            point.setEstSelectionne();
            monde.notifierObservateurs();
        } catch (TwiskException e) {
            point.setEstSelectionne();
            monde.viderPointDeControle();
            monde.notifierObservateurs();
        }

    }
}
