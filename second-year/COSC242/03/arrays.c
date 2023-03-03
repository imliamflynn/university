#include <stdio.h>

void min_max(int *a, int l, int *min, int *max){
    int i;
    *min = a[0];
    *max = a[0];
    for (i = 1; i < l; i++){
        if (a[i] < *min){
            *min = a[i];
        }
        if (a[i] > *max){
            *max = a[i];
        }
    }
}

int main(void){
    int my_array[] = {5, 2, 7, 3, 4};
    int smallest, biggest;
    min_max(my_array, 5, &biggest, &smallest);
    printf("min value is %d, max value is %d\n", biggest, smallest);
    return 0;
}
