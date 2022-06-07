package twiskIG.mondeIG;

import twiskIG.exceptions.ExceptionArcIG;
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
            ActiviteIG activiteIG = new ActiviteIG("Activite"+alpha, id, 120, 90);
            etapes.put(id, activiteIG);
            alpha++;
            this.notifierObservateurs();
        }
        else if(type.equals("Guichet")){
            String id = ins.getIdentifiantEtape();
            GuichetIG guichetIG = new GuichetIG("Guichet"+alphaGuichet, id, 120, 100);
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
                            arc.getDepart().setEstSelectionne();
                            arc.getArrivee().setEstSelectionne();
                            iterateur.remove();
                        }
                    }
                }
                this.notifierObservateurs();
                etapes.remove(e);
            }
        }
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
}
