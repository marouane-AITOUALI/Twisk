package twiskIG.ecouteurs;

import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import twiskIG.mondeIG.EtapeIG;
import twiskIG.mondeIG.MondeIG;

public class EcouteurDragDrop implements EventHandler<DragEvent> {

    private MondeIG mondeIG;

    public EcouteurDragDrop(MondeIG monde){
        mondeIG = monde;
    }

    @Override
    public void handle(DragEvent dragEvent) {
        Dragboard dragboard = dragEvent.getDragboard();
        EtapeIG etape = mondeIG.getEtapeParId(dragboard.getString());
        etape.setPosX((int) (dragEvent.getSceneX() - etape.getLargeur()/2));
        etape.setPosY((int) (dragEvent.getSceneY() - etape.getHauteur()/2));
        etape.viderPointDeControle();
        etape.ajouterPointDeControle();
        mondeIG.notifierObservateurs();
        dragEvent.consume();
    }
}
