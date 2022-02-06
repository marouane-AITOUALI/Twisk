package twisk;

import twisk.monde.Activite;
import twisk.monde.Etape;
import twisk.monde.Guichet;
import twisk.monde.Monde;
import twisk.simulation.Simulation;

public class ClientTwisk {
    public static void main(String []args){
        Monde monde = new Monde();
        Etape etape1 = new Activite("Zoo",2,2);
        Etape etape2 = new Activite("Pool");
        Etape etape3 = new Guichet("Guichet1",2);
        Etape etape4 = new Guichet("Guichet2",2);
        etape4.ajouterSuccesseur(etape1);
        etape1.ajouterSuccesseur(etape3);
        etape3.ajouterSuccesseur(etape2);
        monde.ajouter(etape1,etape2,etape3,etape4);
        monde.aCommeEntree(etape4);monde.aCommeSortie(etape2);
        Simulation simulation = new Simulation();
        simulation.simuler(monde);
    }
}
