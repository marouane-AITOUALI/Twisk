package twisk.simulation;

import twisk.monde.Etape;
import twisk.monde.GestionnaireEtapes;

import java.util.ArrayList;
import java.util.Iterator;

public class GestionnaireClients implements Iterable<Client> {

    private ArrayList<Client> clients;

    public GestionnaireClients(){
        clients = new ArrayList<>();
    }

    public GestionnaireClients(int nbClients){
        clients = new ArrayList<>(nbClients);
    }

    public void setClients(int ... tabClients){
        for(int pid: tabClients){
            clients.add(new Client(pid));
        }
    }

    public Client getClientbyId(int id){
        for (Client client: clients){
            if(client.getNumeroClient() == id){
                return client;
            }
        }
        return null;
    }

    public void allerA(int numeroClient, Etape etape, int rang){
        for(Client client: clients){
            if(client.getNumeroClient() == numeroClient){
                client.allerA(etape, rang);
                break;
            }
        }
    }

    public void nettoyer(){
        clients.clear();
    }

    public Iterator<Client> iterator(){
        return clients.iterator();
    }

}
