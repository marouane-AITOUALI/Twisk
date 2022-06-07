package twiskIG.vues;

import javafx.application.Platform;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import twiskIG.ecouteurs.EcouteurMenuRenommer;
import twiskIG.ecouteurs.EcouteurSetNbJetons;
import twiskIG.mondeIG.MondeIG;

public class VueMenu extends MenuBar implements Observateur{

    private MondeIG mondeIG;

    public VueMenu(MondeIG monde){
        super();
        mondeIG = monde;
        Menu fichier = new Menu("_Paramètres");
        MenuItem quitter = new MenuItem("Quitter");
        MenuItem modifierNbJetons = new MenuItem("setNbJetons");
        fichier.getItems().addAll(quitter, modifierNbJetons);

        quitter.setOnAction(e -> Platform.exit());
        modifierNbJetons.setOnAction(e-> new EcouteurSetNbJetons(mondeIG));

        Menu edition = new Menu("_Edition");
        MenuItem supprimerSelection = new MenuItem("Supprimer la sélection");
        MenuItem renommer = new MenuItem("Renommer");

        supprimerSelection.setOnAction(e -> mondeIG.supprimerLaSelectionne());
        renommer.setOnAction(e -> new EcouteurMenuRenommer(mondeIG));
        edition.getItems().addAll(supprimerSelection,renommer);

        this.getMenus().addAll(fichier, edition);

        monde.ajouterObservateur(this);

    }

    @Override
    public void reagir() {

    }
}
