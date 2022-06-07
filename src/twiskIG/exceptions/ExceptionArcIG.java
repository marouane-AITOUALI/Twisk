package twiskIG.exceptions;

import javafx.animation.PauseTransition;
import javafx.scene.control.Alert;
import javafx.util.Duration;

public class ExceptionArcIG extends Exception {
    public ExceptionArcIG(String e) {
        super(e);
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Arc");
        alert.setContentText(e);
        alert.show();
        PauseTransition p = new PauseTransition(Duration.millis(5000));
        p.setOnFinished(event -> alert.close());
        p.play();
    }
}
