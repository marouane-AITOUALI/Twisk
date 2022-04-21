package twisk.simulation;

import twisk.monde.Etape;
import twisk.monde.Monde;
import twisk.monde.SasEntree;
import twisk.outils.KitC;

import java.util.Iterator;
import java.util.Scanner;

public class Simulation implements Iterable<Client> {


    private KitC kit;
    private GestionnaireClients gestionnaireClients;
    private int nbClients = 3;


    /**
     * Constructeur de la classe simulation
     */
    public Simulation(){
        this.kit = new KitC();
        gestionnaireClients = new GestionnaireClients(nbClients);
    }

    public native int[] start_simulation(int nbEtapes, int nbServices, int nbClients, int [] tabJetonsServices);
    public native void nettoyage();
    public native int[] ou_sont_les_clients(int nbEtapes, int nbClients);

    public void setNbClients(int nbClient){
        this.nbClients = nbClient;
    }

    /**
     * fonction qui simule les processus dans le monde
     */
    public void simuler(Monde monde){
        Iterator<Etape> it = monde.iterator();
        while(it.hasNext()){
            System.out.println(it.next().toString());
        }
        kit.creerEnvironnement();
        kit.creerFichier(monde.toC());
        kit.compiler();
        kit.construireLibrairie();

        String library = "/tmp/twisk/libTwisk.so";
        System.load(library);



        int nbGuichet = monde.nbGuichets();

        int nbEtapes = monde.nbEtapes();


        /*int jetonsGuichet;
        System.out.println("Entrer le nombre de guichet : ");
        nbGuichet = s.nextInt();
        System.out.println(nbGuichet);
        System.out.println(nbClients);
        System.out.println(nbEtapes);*/
        int []tabJetonsGuichet = new int[nbGuichet];

        int j = 1;

        for(int i = 0; i < nbGuichet; i++){
            tabJetonsGuichet[i] = monde.getGestionEtape().getJetonsParSemaphore(j);
            j++;
        }


        int []tabProcessus = start_simulation(nbEtapes,nbGuichet,nbClients,tabJetonsGuichet);


        System.out.print("\nLes clients: ");
        for (int i =0; i < nbClients; i++){
            if(i != nbClients - 1){
                System.out.print(""+tabProcessus[i]+", ");
            }
            else{
                System.out.println(tabProcessus[i]);
            }
        }
        System.out.println("\n");

        int []clients = ou_sont_les_clients(nbEtapes,nbClients);
        gestionnaireClients.setClients(clients);

        int i = 0;
        boolean fin = false;
        while (!fin){
            int nbClientsExistant = clients[i*nbClients + i];
            System.out.print("Etape "+i+ " ("+monde.getNomparNumero(i)+") " + nbClientsExistant + " clients: ");
            //Etape etape = monde.getEtapeParNumero(i);
            if(nbClientsExistant != 0){
                for(int c = 0; c < nbClientsExistant; c++){
                    int pid = clients[i*nbClients + i + 1 + c];
                    System.out.print(pid+" ");
                }
            }
            System.out.println("\n");
            i++;
            if(i == nbEtapes && clients[(nbClients +1)] != nbClients){

                try {
                    clients=ou_sont_les_clients(nbEtapes,nbClients);
                    gestionnaireClients.setClients(clients);
                    Thread.sleep(1000);
                    i = 0;
                } catch (InterruptedException e) {
                    gestionnaireClients.nettoyer();
                    nettoyage();
                    e.printStackTrace();
                }

            }
            else if (i == nbEtapes && clients[(nbClients +1)] == nbClients){
                fin = true;
                gestionnaireClients.nettoyer();
            }

        }

        nettoyage();


        //System.out.println(monde.toC());
    }

    /**
     * Retourne l'iterateur sur les clients
     * @return Iterateur de Client
     */
    @Override
    public Iterator<Client> iterator() {
        return gestionnaireClients.iterator();
    }
}
