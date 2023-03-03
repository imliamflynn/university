#include <stdio.h>
#include <stdlib.h>

#define ARRAY_MAX 10 /*Max array size*/

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

void print_array(int *a, int n){
    if (n > 0){
        printf("%d\n", a[0]);
        print_array(a + 1, n - 1);
    }
}

int main(void) {
    /*Variables*/
    int my_array[ARRAY_MAX];
    int count = 0;

    /*Takes input and puts it into the array*/
    while (count < ARRAY_MAX && 1 == scanf("%d", &my_array[count])) {
        count++;
    }

    insertion_sort(my_array, count);
    
    print_array(my_array, count);

    return EXIT_SUCCESS;
}
