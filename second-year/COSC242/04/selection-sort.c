#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define ARRAY_MAX 30000 /*Max array size*/

/*This method does selection sort on the array *a passed to it of length n*/
void selection_sort(int *a, int n) {
    /*Variables*/
    int i, j, temp;
    for (i = 0; i < n; i++){
        for (j = i; j < n; j++){
            if (a[i] > a[j]){ /*This swaps a[i] and a[j] if
                                a[i] is bigger than a[j]*/
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
    }
}

int main(void) {
    /*Variables*/
    int my_array[ARRAY_MAX];
    clock_t start, end;
    int i, count = 0;

    /*Takes input and puts it into the array*/
    while (count < ARRAY_MAX && 1 == scanf("%d", &my_array[count])) {
        count++;
    }

    start = clock(); /*Starts timer*/
    selection_sort(my_array, count);
    end = clock(); /*Ends timer*/
    
    for (i = 0; i < count; i++) {
        printf("%d\n", my_array[i]); /*Prints sorted array*/
    }

    /*Prints the time taken to complete*/
    fprintf(stderr, "%d %f\n", count, (end-start)/(double)CLOCKS_PER_SEC);
    
    return EXIT_SUCCESS;
}
