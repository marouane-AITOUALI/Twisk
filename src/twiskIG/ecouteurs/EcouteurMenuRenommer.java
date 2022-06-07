package twiskIG.ecouteurs;

import javafx.scene.control.TextInputDialog;
import twiskIG.mondeIG.MondeIG;

import java.text.Normalizer;

public class EcouteurMenuRenommer {

    private MondeIG mondeIG;
    private final TextInputDialog textDialog;

    public EcouteurMenuRenommer(MondeIG monde){
        mondeIG = monde;
        textDialog = new TextInputDialog();
        textDialog.setHeaderText("Renommer");
        textDialog.showAndWait();
        String nom = sansAccents(textDialog.getEditor().getText());
        mondeIG.renommerEtape(nom);
    }

    private String sansAccents(String source) {
        return Normalizer.normalize(source, Normalizer.Form.NFD).replaceAll("[\u0300-\u036F -+.^:,@#{|}&'(_)=]", "");
    }
}
