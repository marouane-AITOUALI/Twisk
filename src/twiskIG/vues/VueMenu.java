package twiskIG.vues;

import javafx.application.Platform;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import twiskIG.ecouteurs.*;
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
        MenuItem effacerSelection = new MenuItem("Effacer la sélection");

        edition.getItems().addAll(supprimerSelection,renommer, effacerSelection);
        supprimerSelection.setOnAction(e -> mondeIG.supprimerLaSelectionne());
        renommer.setOnAction(e -> new EcouteurMenuRenommer(mondeIG));
        effacerSelection.setOnAction(new EcouteurEffacerSelection(mondeIG));

        Menu Monde = new Menu("_Monde");
        MenuItem entree = new MenuItem("Entrée");
        MenuItem sortie = new MenuItem("Sortie");
        Monde.getItems().addAll(entree, sortie);

        entree.setOnAction(new EcouteurSasEntree(mondeIG));
        sortie.setOnAction(new EcouteurSasSortie(mondeIG));

        Menu parametres = new Menu("_Paramètres");
        MenuItem delai = new MenuItem("délai");
        MenuItem ecartTemps = new MenuItem("écartTemps");
        parametres.getItems().addAll(delai, ecartTemps);

        delai.setOnAction(new EcouteurDelai(mondeIG));
        ecartTemps.setOnAction(new EcouteurEcartTemps(mondeIG));

        Menu style = new Menu("_Style");


        this.getMenus().addAll(fichier, edition, Monde, style);

        monde.ajouterObservateur(this);

    }

    @Override
    public void reagir() {

    }
}
