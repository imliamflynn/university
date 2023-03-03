#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main(void){
    /*variable decs*/
    int i = 0;
    double j = 1.0;

    /*a for loop*/
    for (i = 0; i < 10; i++){
        printf("%d %7.2f %6.2f\n", i, j, sqrt(j)); /* sqrt defined in math.h */
        j *= 2;
    }

    return 0;
}
