#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define ARRAY_MAX 30000 /*Max array size*/

/*This method does insertion sort on the array *a passed to it of length n*/
void insertion_sort(int *a, int n) {
    /*Variables*/
    int i, j, key;
    for (i = 0; i < n; i++){
        key = a[i]; /*The key is the the element we are finding a space for*/
        for (j = i - 1; j >= 0; j--){ 
            if (a[j] > key){ /*a[j] moves along the array one index
                               and the key is put into the gap*/
                a[j+1] = a[j];
                a[j] = key;
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
    insertion_sort(my_array, count);
    end = clock(); /*Ends timer*/
    
    for (i = 0; i < count; i++) {
        printf("%d\n", my_array[i]); /*Prints sorted array*/
    }

    /*Prints the time taken to complete*/
    fprintf(stderr, "%d %f\n", count, (end-start)/(double)CLOCKS_PER_SEC);
    
    return EXIT_SUCCESS;
}
