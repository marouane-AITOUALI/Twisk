package twiskIG.vues;

import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import twiskIG.ecouteurs.EcouteurAjoutActivite;
import twiskIG.ecouteurs.EcouteurAjoutGuichet;
import twiskIG.exceptions.MondeException;
import twiskIG.mondeIG.MondeIG;

public class VueOutils extends TilePane implements Observateur{

    private Button ajoutActivite = new Button("Activite");
    private Button ajoutGuichet = new Button("Guichet");

    private Button simuler = new Button("");
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

        Image image2 = new Image(getClass().getResourceAsStream
                ("/images/start.png"),50,20,true,true);
        ImageView icon2 = new ImageView(image2);
        simuler.setGraphic(icon2);

        Tooltip ajoutActiviteTooltip = new Tooltip("Cliquer pour ajouter une activité");
        Tooltip ajoutGuichetTooltip = new Tooltip("Cliquer pour ajouter un guichet");
        Tooltip simulation = new Tooltip("Simuler le Monde");
        simuler.setTooltip(simulation);
        ajoutGuichet.setTooltip(ajoutGuichetTooltip);
        ajoutActivite.setTooltip(ajoutActiviteTooltip);

        this.getChildren().addAll(ajoutActivite, ajoutGuichet, simuler);
        ajoutActivite.setOnAction(new EcouteurAjoutActivite(mondeIG));
        ajoutGuichet.setOnAction(new EcouteurAjoutGuichet(mondeIG));
        simuler.setOnAction(e->{
            try{
                mondeIG.simuler();
            } catch (MondeException ex) {

            }
        });
        /* mondeIG.ajouter("Activité");
        mondeIG.notifierObservateurs();*/
    }

    @Override
    public void reagir() {
    }
}
