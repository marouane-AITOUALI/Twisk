package twisk.simulation;

import twisk.monde.Etape;
import twisk.monde.GestionnaireEtapes;

import java.util.ArrayList;
import java.util.Iterator;

public class GestionnaireClients implements Iterable<Client> {

    private ArrayList<Client> clients = new ArrayList<>();

    public GestionnaireClients(){

    }

    public GestionnaireClients(int nbClients){

    }

    public void setClients(int ... tabClients){
        for(int pid: tabClients){
            clients.add(new Client(pid));
        }
    }

    public void allerA(int numeroClient, Etape etape, int rang){

    }

    public void nettoyer(){

    }

    public Iterator<Client> iterator(){
        return clients.iterator();
    }

}
