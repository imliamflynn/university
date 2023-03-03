#include <stdio.h>
#include <stdlib.h>

int main(void) {
    int array_size = 0;
    int *my_dynamic_array;
    int *repeats_array;
    int i = 0;
    
    printf("Enter the size of the array: ");
    scanf("%d", &array_size);
    
    /* initialise the arrays to the appropriate size */
    my_dynamic_array = malloc(array_size * sizeof my_dynamic_array[0]);
    repeats_array = malloc(array_size * sizeof repeats_array[0]);
    
    if (NULL == my_dynamic_array) {
        fprintf(stderr, "memory allocation failed!\n");
        return EXIT_FAILURE;
    }
    if (NULL == repeats_array) {
        fprintf(stderr, "memory allocation failed!\n");
        return EXIT_FAILURE;
    }
    
    for (i = 0; i < array_size; i++) {
        my_dynamic_array[i] = rand() % array_size;
    }
    
    printf("What’s in the array:\n");
    for (i = 0; i < array_size; i++) {
        repeats_array[my_dynamic_array[i]] += 1;
        printf("%d ", my_dynamic_array[i]);
    }
    printf("\n");

    for (i = 0; i < array_size; i++){
        if (repeats_array[i] > 1){
            printf("%d repeats %d times.\n", i, repeats_array[i]);
        }
    }
    
    /* release the memory associated with the array */
    free(my_dynamic_array);
    free(repeats_array);
    
    return 0;
}
