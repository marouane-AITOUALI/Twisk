package twisk.simulation;

import twisk.monde.Etape;
import twisk.monde.Monde;
import twisk.monde.SasEntree;
import twisk.outils.KitC;

import java.util.Iterator;
import java.util.Scanner;

public class Simulation {

    private Monde monde;
    private KitC kit = new KitC();
    private int nbClients = 3;


    /**
     * Constructeur de la classe simulation
     */
    public Simulation(Monde monde){
        this.monde = monde;

    }

    public native int[] start_simulation(int nbEtapes, int nbServices, int nbClients, int [] tabJetonsServices);
    public native void nettoyage();
    public native int[] ou_sont_les_clients(int nbEtapes, int nbClients);

    public void setNbClient(int nbClient){
        this.nbClients = nbClient;
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
            System.out.println(tabJetonsGuichet[i]);
            j++;
            /*System.out.println("Entrer le nombre de jetons du guichet"+ (i+1)+": ");
            jetonsGuichet = s.nextInt();
            tabJetonsGuichet[i] = jetonsGuichet;*/

        }


        int []tabProcessus = start_simulation(nbEtapes,nbGuichet,nbClients,tabJetonsGuichet);


        System.out.print("Les clients: ");
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


        int i = 0;
        boolean fin = false;
        while (!fin){
            int nbClientsExistant = clients[i*nbClients + i];
            System.out.print("Etape "+i+ " ("+monde.getNomparNumero(i)+") " + nbClientsExistant + " clients: ");

            if(nbClientsExistant != 0){
                for(int c = 0; c < nbClientsExistant; c++){
                    System.out.print(clients[i*nbClients + i + 1 + c]+" ");
                }
            }
            System.out.println("\n");
            i++;
            if(i == nbEtapes && clients[(nbClients +1)] != nbClients){

                try {
                    clients=ou_sont_les_clients(nbEtapes,nbClients);
                    Thread.sleep(1000);
                    i = 0;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            else if (i == nbEtapes && clients[(nbClients +1)] == nbClients){
                fin = true;
            }





        // Condition d'arrêt

        //delai(2,1);

        }

        nettoyage();


        //System.out.println(monde.toC());
    }




}
