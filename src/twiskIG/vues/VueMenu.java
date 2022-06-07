package twiskIG.vues;

import javafx.application.Platform;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import twiskIG.ecouteurs.EcouteurMenuRenommer;
import twiskIG.mondeIG.MondeIG;

public class VueMenu extends MenuBar implements Observateur{

    private MondeIG mondeIG;

    public VueMenu(MondeIG monde){
        super();
        mondeIG = monde;
        Menu fichier = new Menu("_Fichier");
        MenuItem quitter = new MenuItem("Quitter");
        fichier.getItems().add(quitter);

        quitter.setOnAction(e -> Platform.exit());

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
