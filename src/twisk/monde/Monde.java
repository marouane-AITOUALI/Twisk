package twisk.monde;

import java.util.ArrayList;
import java.util.Iterator;
import java.lang.StringBuilder;

public class Monde implements Iterable<Etape> {

    private SasSortie SasSortie;
    private SasEntree SasEntree;
    private GestionnaireEtapes gestionEtape;


    /**
     * Constructeur de la classe Monde
     */
    public Monde(){
        SasSortie = new SasSortie();
        SasEntree = new SasEntree();
        gestionEtape = new GestionnaireEtapes();
        this.ajouter(this.SasEntree, this.SasSortie);
    }

    /**
     * fonction qui ajoute les entrées du monde
     * @param etapes Etapes à rajouter dans l'entrée
     */
    public void aCommeEntree(Etape... etapes){
        this.SasEntree.ajouterSuccesseur(etapes);
    }

    /**
     * fonction qui ajoute les sorties du monde
     * @param etapes Etapes à rajouter dans la sortie
     */
    public void aCommeSortie(Etape... etapes){
        this.SasSortie.ajouterSuccesseur(etapes);
    }

    /**
     * fonction qui ajoute les étapes
     * @param etapes Etapes à ajouter dans le monde
     */
    public void ajouter(Etape... etapes){
        gestionEtape.ajouter(etapes);
    }



    /**
     * fonction qui retourne le nombre des etapes
     * @return Nombre des Etapes
     */
    public int nbEtapes(){
        return gestionEtape.nbEtapes();
    }

    /**
     * fonction qui retourne le nombre de guichet
     * @return Nombre des guichets guichet
     */
    public int nbGuichets(){
        int nombre = 0;
        Iterator<Etape> iterator = gestionEtape.iterator();
        while(iterator.hasNext()){
            Etape etape = iterator.next();
            if(etape.estUnGuichet()){
                nombre++;
            }
        }
        return nombre;
    }

    /**
     * fonction qui retourne une chaine de caractére contenant le code C
     * @return chaine de caracteres
     */
    public String toC(){
        StringBuilder s = new StringBuilder();
        //affichage des lib
        s.append("\n#include<stdio.h>\n#include<stdlib.h>\n#include<unistd.h>\n#include\"def.h\"\n");
        //affichage des constantes

        Iterator<Etape> iterator = gestionEtape.iterator();
        while (iterator.hasNext()){
            Etape etape = iterator.next();
            s.append("#define ").append(etape.getNom()).append(" ").append(etape.getNumEtape()).append("\n");
            if(etape.estUnGuichet()){
                s.append("#define num_sem_"+etape.getNom()+" "+((Guichet)etape).getSemaphore()+"\n");
            }
        }
        // Affichage de la fonction simuler
        s.append("\npublic void simuler(int ids){\n\n").append(SasEntree.toC());
        s.append("\n}\n");

        return s.toString();
    }


    public Iterator<Etape> iterator(){
        return gestionEtape.iterator();
    }
}
