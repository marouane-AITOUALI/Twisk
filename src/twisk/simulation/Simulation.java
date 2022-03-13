package twisk.simulation;

import twisk.monde.Etape;
import twisk.monde.Monde;
import twisk.monde.SasEntree;
import twisk.outils.KitC;

import java.util.Iterator;

public class Simulation {

    private Monde monde;
    private KitC kit = new KitC();
    /**
     * Constructeur de la classe simulation
     */
    public Simulation(Monde monde){
        this.monde = monde;

    }

    /**
     * fonction affiche les étapes du monde
     */
    public void simuler(){
        Iterator<Etape> it = monde.iterator();
        while(it.hasNext()){
            System.out.println(it.next().toString());
        }
        kit.creerEnvironnement();
        kit.creerFichier(monde.toC());
        kit.compiler();
        kit.construireLibrairie();
        //System.out.println(monde.toC());
    }

}
