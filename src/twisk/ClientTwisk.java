package twisk;

import twisk.monde.*;
import twisk.simulation.Simulation;

import java.util.Iterator;

public class ClientTwisk {
    public static void main(String []args){
        Monde monde = new Monde() ;

        Guichet guichet = new Guichet("ticket", 2) ;
        Activite act1 = new ActiviteRestreinte("toboggan", 2, 1) ;

        Etape etape1 = new Activite("musee") ;
        Etape etape2 = new Activite("boutique") ;

        etape1.ajouterSuccesseur(etape2) ;
        etape2.ajouterSuccesseur(guichet) ;
        guichet.ajouterSuccesseur(act1);

        monde.ajouter(etape1, etape2) ;
        monde.ajouter(act1) ;
        monde.ajouter(guichet) ;

        monde.aCommeEntree(etape1);
        monde.aCommeSortie(act1) ;
        Simulation simulation = new Simulation();

        /* Changer le nombre de clients
        simulation.setNbClient(5);
        */

        simulation.simuler(monde);

    }
    }

