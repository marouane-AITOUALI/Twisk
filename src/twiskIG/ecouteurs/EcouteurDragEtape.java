package twiskIG.ecouteurs;

import javafx.event.EventHandler;
import javafx.scene.image.WritableImage;
import javafx.scene.input.*;
import twiskIG.vues.VueEtapeIG;

public class EcouteurDragEtape implements EventHandler<MouseEvent> {

    private VueEtapeIG vueEtapeIG;
    private String identifiant;

    public EcouteurDragEtape(VueEtapeIG vue, String id) {
        vueEtapeIG = vue;
        identifiant = id;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        Dragboard dragboard = vueEtapeIG.startDragAndDrop(TransferMode.MOVE);
        ClipboardContent content = new ClipboardContent();
        content.putString(identifiant);
        WritableImage capture = vueEtapeIG.snapshot(null, null);
        content.putImage(capture);
        dragboard.setContent(content);
        mouseEvent.consume();

    }
}
