package twiskIG;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import twiskIG.mondeIG.MondeIG;
import twiskIG.outils.FabriqueIdentifiant;
import twiskIG.vues.VueMenu;
import twiskIG.vues.VueMondeIG;
import twiskIG.vues.VueOutils;

public class MainTwisk extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("TwiskIG");
        //stage.setResizable(true);

        FabriqueIdentifiant fi = FabriqueIdentifiant.getInstance();
        BorderPane root = new BorderPane();

        MondeIG monde = new MondeIG();


        VueOutils vueOutils = new VueOutils(monde);
        VueMenu vueMenu = new VueMenu(monde);
        VueMondeIG vueMondeIG = new VueMondeIG(monde);

        root.setBottom(vueOutils);
        root.setCenter(vueMondeIG);
        root.setTop(vueMenu);
        stage.setScene(new Scene(root, 600, 550));
        stage.show();

    }

    public static void main(String [] args){
        launch(args);
    }
}
