#include <stdio.h>
#include <math.h>

int is_prime(int candidate){
    int i;
    for (i = 2; i < candidate; candidate++){
        if (candidate%i == 0){
            return 0;
        }
    }
    return 1;
}

int main(void){
    int candidate = 2, num_printed = 0;

    while (num_printed < 1000){
        if (is_prime(candidate)){
            printf("%d\n", candidate);
            num_printed++;
        }
        candidate++;
    }
    return 0;
}
