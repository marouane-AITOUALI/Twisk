package twiskIG.ecouteurs;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;

public class EcouteurDragOver implements EventHandler<DragEvent> {

    public EcouteurDragOver(){

    }

    @Override
    public void handle(DragEvent dragEvent) {
        dragEvent.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        dragEvent.consume();
    }
}
