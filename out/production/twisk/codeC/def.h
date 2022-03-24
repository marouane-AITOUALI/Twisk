#ifndef DEF_H
#define DEF_H

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

// fonctions déclarées dans programmeC, à utiliser dans le code du client *******************************************************

void delai(int temps, int delta) ;

void entrer(int etape) ;
void transfert(int source, int destination) ;

int P(int semid, int numero) ;
int V(int semid, int numero) ;

int* start_simulation(int nbEtapes, int nbServices, int nbClients, int *tabJetonsServices) ;
int* ou_sont_les_clients(int nbEtapes, int nbClients) ;
void nettoyage() ;

// la fonction déclarée dans le code des clients ****************************************************************************

void simulation(int ids) ;

#endif


/*
if(clients[(nbClients+1)*(nbEtapes-1)] == nbClients){
        fin = 1;
        break;
    }
    printf("Etape%d: ", i);
    for (int a = 0; a < nbClients; a++){
        printf("%d ", clients[i*nbClients + i + 1 + a]);
    }
    printf("\n");
    i++;
    printf("%d\n", clients[i*nbClients  + i]);
    if(i == nbEtapes && clients[i*nbClients  + i] != nbClients){
        clients = ou_sont_les_clients(nbEtapes, nbClients);
        i = 0;
    }
    
    delai(3,2);
    //printf("%d\n", clients[i*nbClients  + i]);*/