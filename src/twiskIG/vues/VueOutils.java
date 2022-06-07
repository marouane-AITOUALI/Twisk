package twiskIG.vues;

import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import twiskIG.ecouteurs.EcouteurAjoutActivite;
import twiskIG.ecouteurs.EcouteurAjoutGuichet;
import twiskIG.mondeIG.MondeIG;

public class VueOutils extends TilePane implements Observateur{

    private Button ajoutActivite = new Button("Activite");
    private Button ajoutGuichet = new Button("Guichet");
    private MondeIG mondeIG;

    public VueOutils(MondeIG monde){
        super();
        mondeIG = monde;
        mondeIG.ajouterObservateur(this);

        Image image = new Image(getClass().getResourceAsStream
                ("/images/ajoutActivite.png"),50,20,true,true);
        ImageView icon = new ImageView(image);
        ajoutActivite.setGraphic(icon);

        Image image1 = new Image(getClass().getResourceAsStream
                ("/images/ajouter.png"),50,20,true,true);
        ImageView icon1 = new ImageView(image1);
        ajoutGuichet.setGraphic(icon1);

        Tooltip ajoutActiviteTooltip = new Tooltip("Cliquer pour ajouter une activité");
        Tooltip ajoutGuichetTooltip = new Tooltip("Cliquer pour ajouter un guichet");
        ajoutGuichet.setTooltip(ajoutGuichetTooltip);
        ajoutActivite.setTooltip(ajoutActiviteTooltip);
        this.getChildren().addAll(ajoutActivite, ajoutGuichet);
        ajoutActivite.setOnAction(new EcouteurAjoutActivite(mondeIG));
        ajoutGuichet.setOnAction(new EcouteurAjoutGuichet(mondeIG));
        /* mondeIG.ajouter("Activité");
        mondeIG.notifierObservateurs();*/
    }

    @Override
    public void reagir() {
    }
}
