package twisk.simulation;

import twisk.monde.Etape;
import twisk.monde.Monde;
import twisk.monde.SasEntree;

import java.util.Iterator;

public class Simulation {
    public Simulation(){

    }

    public void simuler(Monde monde){
        Iterator<Etape> it = monde.iterator();
        while(it.hasNext()){
            System.out.println(it.next().toString());
        }
    }

}
