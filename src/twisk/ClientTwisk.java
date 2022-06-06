package twisk;

import twisk.monde.*;
import twisk.outils.ClassLoaderPerso;
import twisk.outils.FabriqueNumero;
import twisk.simulation.Client;
import twisk.simulation.Simulation;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;

public class ClientTwisk {

    public ClientTwisk(){

    }
    public static void main(String []args){
        Monde monde = new Monde();
        Activite billiard = new Activite("billiard",2,1);
        Activite shop = new Activite("Acheter",3,1);
        Guichet ticket = new Guichet("G_Ticket", 2);
        Activite cinema = new ActiviteRestreinte("Cinema", 2, 1);

        billiard.ajouterSuccesseur(shop);
        shop.ajouterSuccesseur(ticket);
        ticket.ajouterSuccesseur(cinema);

        monde.ajouter(billiard, shop, ticket, cinema);
        monde.aCommeEntree(billiard);
        monde.aCommeSortie(cinema);



        try {
            FabriqueNumero.getInstance().reset();
            ClassLoaderPerso classLoaderPerso = new ClassLoaderPerso(ClientTwisk.class.getClassLoader());
            Class<?> simulation = classLoaderPerso.loadClass("twisk.simulation.Simulation");

            //Constructor<?> constructor = simulation.getConstructor();
            Object instance = simulation.getDeclaredConstructor().newInstance();

            Method setNbClients = simulation.getDeclaredMethod("setNbClients", int.class);
            Method simuler = simulation.getDeclaredMethod("simuler", twisk.monde.Monde.class);

            setNbClients.invoke(instance, 4);
            simuler.invoke(instance, monde);

        }
        catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
               InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        Monde monde2 = new Monde();
        Activite billiard1 = new Activite("piscine",2,1);
        Activite shop1 = new Activite("toboggan",3,1);
        Guichet ticket1 = new Guichet("acces_tob", 2);
        Activite cinema1 = new ActiviteRestreinte("toupie", 2, 1);

        billiard1.ajouterSuccesseur(shop1);
        shop1.ajouterSuccesseur(ticket1);
        ticket1.ajouterSuccesseur(cinema1);

        monde2.ajouter(billiard1, shop1, ticket1, cinema1);
        monde2.aCommeEntree(billiard1);
        monde2.aCommeSortie(cinema1);

        try {
            FabriqueNumero.getInstance().reset();
            ClassLoaderPerso classLoaderPerso = new ClassLoaderPerso(ClientTwisk.class.getClassLoader());
            Class<?> simulation = classLoaderPerso.loadClass("twisk.simulation.Simulation");

            //Constructor<?> constructor = simulation.getConstructor();
            Object instance = simulation.getDeclaredConstructor().newInstance();

            Method setNbClients = simulation.getDeclaredMethod("setNbClients", int.class);
            Method simuler = simulation.getDeclaredMethod("simuler", twisk.monde.Monde.class);

            setNbClients.invoke(instance, 4);
            simuler.invoke(instance, monde2);

        }
        catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
               InvocationTargetException e) {
            throw new RuntimeException(e);
        }




        //Simulation s = new Simulation();
        //s.setNbClients(5);
        //s.simuler(monde);
        //s.simuler(monde);
        FabriqueNumero.getInstance().reset();
    }
    }

