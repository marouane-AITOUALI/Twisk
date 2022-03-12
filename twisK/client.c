#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include "def.h"

#define sasEntre 1
#define activite 2
#define sasSortie 3

void sumiler(int ids){
    entrer(sasEntre);
    delai(6, 3);
    transfert(sasEntre, activite);
    delai(3,1);
    transfert(activite, sasSortie);
}   