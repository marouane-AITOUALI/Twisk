package twiskIG.exceptions;

import javafx.animation.PauseTransition;
import javafx.scene.control.Alert;
import javafx.util.Duration;

public class MondeException extends Exception {

    public MondeException(String m){
        super(m);
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Monde");
        alert.setContentText(m);
        alert.show();
        PauseTransition p = new PauseTransition(Duration.millis(5000));
        p.setOnFinished(event -> alert.close());
        p.play();
    }
}
