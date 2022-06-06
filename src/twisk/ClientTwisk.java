package twisk;

import twisk.monde.*;
import twisk.outils.ClassLoaderPerso;
import twisk.simulation.Simulation;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;

public class ClientTwisk {
    public static void main(String []args){

        Monde monde = new Monde();

        ClassLoaderPerso classLoaderPerso = new ClassLoaderPerso(monde.getClass().getClassLoader());

        try {
            Class<?> simulation = classLoaderPerso.loadClass("twisk.simulation.Simulation");

            Constructor<?> constructor = simulation.getConstructor();
            Object instance = constructor.newInstance();

            Method setNbClients = simulation.getMethod("setNbClients", int.class);

        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }




        /*Activite zoo = new Activite("balade au zoo", 3, 1);
        Guichet guichet = new Guichet("accès au toboggan", 2);
        Activite tob = new ActiviteRestreinte("toboggan", 2, 1);

        zoo.ajouterSuccesseur(guichet);
        guichet.ajouterSuccesseur(tob);

        monde.ajouter(zoo, tob, guichet);

        monde.aCommeEntree(zoo);
        monde.aCommeSortie(tob);


        //s.setNbClients(5);



        /*Monde monde2 = new Monde();

        Activite billiard = new Activite("billiard",2,1);
        Activite shop = new Activite("Acheter",3,1);
        Guichet ticket = new Guichet("Ticket", 2);
        Activite cinema = new ActiviteRestreinte("Cinema", 2, 1);

        billiard.ajouterSuccesseur(shop);
        shop.ajouterSuccesseur(ticket);
        ticket.ajouterSuccesseur(cinema);

        monde2.ajouter(billiard, shop, ticket, cinema);
        monde2.aCommeEntree(billiard);
        monde2.aCommeSortie(cinema);*/

        //Simulation s = new Simulation();
        //s.setNbClients(5);
        //s.simuler(monde);
        //s.simuler(monde);
    }
    }

