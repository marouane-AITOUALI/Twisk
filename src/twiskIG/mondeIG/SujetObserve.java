package twiskIG.mondeIG;

import twiskIG.vues.Observateur;

import java.util.ArrayList;

public class SujetObserve {

    private ArrayList<Observateur> obs = new ArrayList<>();

    public SujetObserve(){

    }

    public void ajouterObservateur(Observateur v){
        this.obs.add(v);
    }

    public void notifierObservateurs(){
        for (Observateur o: this.obs){
            if (o != null){
                o.reagir();
            }
        }
    }
}
