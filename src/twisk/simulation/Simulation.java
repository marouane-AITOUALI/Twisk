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
    /**
     * Constructeur de la classe simulation
     */
    public Simulation(Monde monde){
        this.monde = monde;

    }

    public native int[] start_simulation(int nbEtapes, int nbServices, int nbClients, int []tabJetonsServices);
    public native void nettoyage();
    public native int[] ou_sont_les_clients(int nbEtapes, int nbClients);

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
        System.load("/tmp/twisk/libTwisk.so");
        Scanner s = new Scanner(System.in);

        int nbGuichet = 0;
        int nbClients  = 0;
        int nbEtapes = 6;
        System.out.println("Entrer le nombre de clients : ");
        nbClients = s.nextInt();

        int jetonsGuichet;
        System.out.println("Entrer le nombre de guichet : ");
        nbGuichet = s.nextInt();
        int []tabJetonsGuichet = new int[nbGuichet];



        for(int i = 0; i < nbGuichet; i++){
            System.out.println("Entrer le nombre de jetons du guichet : "+ i+1);
            jetonsGuichet = s.nextInt();
            tabJetonsGuichet[i] = jetonsGuichet;
        }


        int []tabProcessus = start_simulation(nbEtapes,nbGuichet,nbClients,tabJetonsGuichet);


        System.out.println("Les clients: ");
        for (int i =0; i < nbClients; i++){
            if(i != nbClients - 1){
                System.out.println(""+tabProcessus[i]+",");
            }
            else{
                System.out.println("" + tabProcessus[i] +"\n");
            }
        }
        System.out.println("\n");

        int []clients = ou_sont_les_clients(nbEtapes,nbClients);


        int i = 0;
        boolean fin = false;
        while (!fin){
            int nbClientsExistant = clients[i*nbClients + i];
            System.out.println("Etape "+i+ " " + nbClientsExistant + " clients: ");

            if(nbClientsExistant != 0){
                for(int c = 0; c < nbClientsExistant; c++){
                    System.out.println(clients[i*nbClients + i + 1 + c]);
                }
            }
            System.out.println("\n");
            i++;
            if(i == nbEtapes && clients[(nbClients +1)] != nbClients){
                clients=ou_sont_les_clients(nbEtapes,nbClients);
                i = 0;
            }
            else if (i == nbEtapes && clients[(nbClients +1)] == nbClients){
            /*printf("Etape%d: ", i-1);
            for(int c = 0; c < nbEtapes; c++){
                printf("%d ", clients[(i-1)*nbClients + i  + c]);
            }*/
                fin = true;
            }

            delai(2,1);

        }

        nettoyage();


        //System.out.println(monde.toC());
    }




}
