#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main(void){
    /*variable decs*/
    int i, f = 0, g = 1, temp = 0;

    /*a for loop*/
    for (i = 0; i < 40; i++){
        printf("%d, ", g);
        temp = g;
        g = g + f;
        f = temp;
        if (f%5 == 0){
            printf("\n");
        }
    }

    return 0;
}
