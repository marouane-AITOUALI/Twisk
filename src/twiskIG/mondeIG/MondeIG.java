package twiskIG.mondeIG;

import javafx.concurrent.Task;
import twisk.monde.Monde;
import twisk.outils.FabriqueNumero;
import twisk.outils.ThreadsManager;
import twisk.simulation.Simulation;
import twiskIG.exceptions.ExceptionArcIG;
import twiskIG.exceptions.MondeException;
import twiskIG.outils.FabriqueIdentifiant;

import java.util.*;

public class MondeIG extends SujetObserve implements Iterable<EtapeIG> {


    private HashMap<String, EtapeIG> etapes = new HashMap<>();
    private ArrayList<ArcIG> tabArc = new ArrayList<>();
    private ArrayList<PointDeControleIG> tabPointDeControle = new ArrayList<>();
    int alpha = 1;
    int alphaGuichet = 1;

    /**
     * Constructeur du MondeIG qui contient une activité, à la création
     */
    public  MondeIG(){
        super();
        this.ajouter("Activité");
    }

    /**
     * Ajout une étape dans le monde
     * @param type Type de l'étape à ajouter
     */
    public void ajouter(String type){
        FabriqueIdentifiant ins = FabriqueIdentifiant.getInstance();
        if (type.equals("Activité")){
            //System.out.println("passed by here !!");
            String id = ins.getIdentifiantEtape();
            ActiviteIG activiteIG = new ActiviteIG("Activite"+alpha, id, 130, 90);
            etapes.put(id, activiteIG);
            alpha++;
            this.notifierObservateurs();
        }
        else if(type.equals("Guichet")){
            String id = ins.getIdentifiantEtape();
            GuichetIG guichetIG = new GuichetIG("Guichet"+alphaGuichet, id, 130, 90);
            etapes.put(id, guichetIG);
            alphaGuichet++;
            this.notifierObservateurs();
        }
    }

    /**
     * Retourne l'etape dont l'identifiant est id
     * @param id Identifiant de l'etape
     * @return Retourne l'etape dont l'identifiant est id
     */
    public EtapeIG getEtapeParId(String id){
        for(EtapeIG e: this){
            if(e.getIdentifiant().equals(id)){
                return e;
            }
        }
        return null;
    }

    /**
     * Ajout l'arc p1->p2
     * @param p1 Premier point de controle
     * @param p2 Deuxieme point de controle
     * @throws ExceptionArcIG Exception si on ne peut pas tracer l'arc
     */
    public void ajouter(PointDeControleIG p1, PointDeControleIG p2) throws ExceptionArcIG {
        verifierArc(p1,p2);
        ArcIG arc = new ArcIG(p1, p2);
        tabArc.add(arc);
        notifierObservateurs();
    }

    public void viderPointDeControle(){
        tabPointDeControle.clear();
    }

    /**
     * Vérifie, si on peut dessiner un arc, à partir de deux points de controle
     * @param p1 Premier point de controle
     * @param p2 Deuxième point de controle
     * @throws ExceptionArcIG Exception si l'arc ne peut pas etre dessiné
     */
    private void verifierArc(PointDeControleIG p1, PointDeControleIG p2) throws ExceptionArcIG {
        ArcIG arc = new ArcIG(p1, p2);
        if(p1.memeEtapeQue(p2)){
            p1.setEstSelectionne();
            p2.setEstSelectionne();
            throw new ExceptionArcIG("Impossible de creer un arc sur la meme etape");
        }

        for (ArcIG arcIG : tabArc) {
            if (arcIG.aCommeDebut(arc.getEtapeDepart()) && arcIG.aCommeArrive(arc.getEtapeArrivee())) {
                p1.setEstSelectionne();
                p2.setEstSelectionne();
                throw new ExceptionArcIG("Impossible de créer cet arc, il existe déjà un arc qui relie ces deux étapes");
            }
            if (arcIG.aCommeDebut(arc.getEtapeArrivee()) && arcIG.aCommeArrive(arc.getEtapeDepart())) {
                p1.setEstSelectionne();
                p2.setEstSelectionne();
                throw new ExceptionArcIG("Impossible de créer cet arc, deux arcs sont symétriques");
            }

        }
    }

    /**
     * Retourne Iterateur des ArcIG
     * @return Iterateur ArcIG
     */
    public Iterator<ArcIG> iteratorArcIG(){
        return tabArc.iterator();
    }

    /**
     * Retourne l'itérateur des EtapeIG's
     * @return Iterateur EtapeIG
     */
    @Override
    public Iterator<EtapeIG> iterator() {
        return etapes.values().iterator();
    }

    /**
     * Ajoute un point de controle dans le tableau lorsqu'il est sélectionné,
     * Si on a deux points de controle sélectionnés, on ajoute l'arc associé
     * @param point Point de controle sélectionné
     * @throws ExceptionArcIG
     */
    public void pointDeControleSelectionne(PointDeControleIG point) throws ExceptionArcIG {
        tabPointDeControle.add(point);
        if(tabPointDeControle.size() == 2){
            PointDeControleIG p1 = tabPointDeControle.get(0);
            PointDeControleIG p2 = tabPointDeControle.get(1);
            ajouter(p1,p2);
            tabPointDeControle.clear();
        }
        notifierObservateurs();
    }

    /**
     * Supprimer L'étape selectionnée ainsi que ses arcs associés
     * Déselectionne les points de controle sélectionné
     */
    public void supprimerLaSelectionne() {
        for(EtapeIG e: this){
            if(e.estSelectionnee()){
                e.setEstAffiche(false);
                Iterator<ArcIG> iterateur = this.iteratorArcIG();
                for(PointDeControleIG p: e){
                    while(iterateur.hasNext()){
                        ArcIG arc = iterateur.next();
                        String id = p.getIdentifiant();
                        if(arc.getDepart().getIdentifiant().equals(id)
                                || arc.getArrivee().getIdentifiant().equals(id)){
                            arc.setAffiche(false);
                            arc.setEstSelectionne();
                            arc.getDepart().setEstSelectionne();
                            arc.getArrivee().setEstSelectionne();
                            iterateur.remove();
                        }
                    }
                }

                etapes.remove(e);
            }
        }
        Iterator<ArcIG> it = this.iteratorArcIG();
        while(it.hasNext()) {
            ArcIG arc = it.next();
            if (arc.getEstSelectionne()) {
                arc.setAffiche(false);
                arc.setEstSelectionne();
                it.remove();
                for (PointDeControleIG p : arc.getEtapeDepart()) {
                    if (p.isSelected()) {
                        p.setEstSelectionne();
                    }
                }
                for (PointDeControleIG p : arc.getEtapeArrivee()) {
                    if (p.isSelected()) {
                        p.setEstSelectionne();
                    }
                }
            }
        /*for(ArcIG arc: tabArc){
            if(arc.getEstSelectionne()){
                arc.setAffiche(false);
                arc.setEstSelectionne();
                .remove(arc);
                for(PointDeControleIG p: arc.getEtapeDepart()){
                    if(p.isSelected()){
                        p.setEstSelectionne();
                    }
                }
                for(PointDeControleIG p: arc.getEtapeArrivee()){
                    if(p.isSelected()){
                        p.setEstSelectionne();
                    }
                }

            }
        }*/
        }
        this.notifierObservateurs();


    }

    /**
     * Redéfinit le nom de l'étape sélectionnée
     * @param nom Nouveau nom de l'étape
     */
    public void renommerEtape(String nom) {
        for(EtapeIG e: this){
            if(e.estSelectionnee()){
                e.renommer(nom);
                e.setEstSelectionnee();
            }
        }
        notifierObservateurs();
    }

    public void setNbJetons(int nbJetons){
        for(EtapeIG e: this){
            if(e.estUnGuichet() && e.estSelectionnee() ){
                ((GuichetIG)e).setNbJetons(nbJetons);
                e.setEstSelectionnee();
            }
        }
        notifierObservateurs();
    }


    /**
     * Désélectionne les élements sélectionnés dans le monde
     */
    public void effacerSelection() {
        for (EtapeIG etape : this) {
            if (etape.estSelectionnee()) {
                etape.setEstSelectionnee();
            }
        }
        for (ArcIG arc : tabArc) {
            if (arc.getEstSelectionne()) {
                arc.setEstSelectionne();
                for(PointDeControleIG p: arc.getEtapeDepart()){
                    if(p.isSelected()){
                        p.setEstSelectionne();
                    }
                }
                for(PointDeControleIG p: arc.getEtapeArrivee()){
                    if(p.isSelected()){
                        p.setEstSelectionne();
                    }
                }
            }
        }
        for (PointDeControleIG pdc : tabPointDeControle) {
            pdc.setEstSelectionne();
        }
        viderPointDeControle();
        notifierObservateurs();
    }


    public void simuler() throws MondeException {
        verifierMondeIG();
        FabriqueNumero.getInstance().reset();
        CorrespondanceEtapes cpr = new CorrespondanceEtapes();
        Monde monde = creerMonde();
        Simulation s = new Simulation();
        s.setNbClients(5);
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try{
                    s.simuler(monde);
                    Thread.sleep(10);
                }
                catch(InterruptedException e){

                }
                return null;
            }
        };
        ThreadsManager.getInstance().lancer(task);
    }

    private void verifierMondeIG() throws MondeException{

    }

    private Monde creerMonde(){
        return null;
    }

    public void setSasEntree() {
        for(EtapeIG e: this){
            if(!e.estUnGuichet() && e.estSelectionnee()){
                e.setEntree();
                e.setEstSelectionnee();
            }
        }
        notifierObservateurs();
    }

    public void setSasSortie(){
        for(EtapeIG e: this){
            if(!e.estUnGuichet() && e.estSelectionnee()){
                e.setSortie();
                e.setEstSelectionnee();
            }
        }
        notifierObservateurs();

    }
}