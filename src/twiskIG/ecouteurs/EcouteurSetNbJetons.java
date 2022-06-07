package twiskIG.ecouteurs;

import javafx.scene.control.TextInputDialog;
import twiskIG.mondeIG.MondeIG;

public class EcouteurSetNbJetons {

    private MondeIG mondeIG;
    private final TextInputDialog textDialog;
    public EcouteurSetNbJetons(MondeIG monde) {
        this.mondeIG = monde;
        textDialog = new TextInputDialog();
        textDialog.setHeaderText("Modifier Nombre de Jetons");
        textDialog.showAndWait();
        int nbJetons = Integer.parseInt(textDialog.getEditor().getText());
        mondeIG.setNbJetons(nbJetons);
    }

}
