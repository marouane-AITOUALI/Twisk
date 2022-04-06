package twisk.simulation;

import twisk.monde.Etape;

public class Client {

    private int numeroClient;
    private int rang;
    private Etape etape;

    public Client(int numero){
        numeroClient = numero;
    }

    public void allerA(Etape etape, int rang){
        this.etape = etape;
        this.rang = rang;
    }

    public int getNumeroClient(){
        return numeroClient;
    }

}
