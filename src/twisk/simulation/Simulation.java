package twisk.simulation;

import twisk.monde.Etape;
import twisk.monde.Monde;
import twisk.monde.SasEntree;

import java.util.Iterator;

public class Simulation {
    /**
     * Constructeur de la classe simulation
     */
    public Simulation(){

    }

    /**
     * fonction affiche les étapes du monde
     * @param monde Le monde
     */
    public void simuler(Monde monde){
        Iterator<Etape> it = monde.iterator();
        while(it.hasNext()){
            System.out.println(it.next().toString());
        }
    }

}
