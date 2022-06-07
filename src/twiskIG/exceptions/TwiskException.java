package twiskIG.exceptions;

import javafx.animation.PauseTransition;
import javafx.scene.control.Alert;
import javafx.util.Duration;

public class TwiskException extends Exception {

    public TwiskException(String message){
        super(message);
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setContentText(message);
        alert.show();
        PauseTransition p = new PauseTransition(Duration.millis(5000));
        p.setOnFinished(event -> alert.close());
        p.play();
    }
}
