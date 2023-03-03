#include <stdio.h>
#include <stdlib.h>

#define ARRAY_MAX 100000

void merge_sort(int *a, int *w, int n) {
    int i;
    
    if (n < 2){
        return;
    }
    merge_sort(a, w, n/2);
    merge_sort(a +(n/2), w, n - (n/2));

    merge(a, w, n);
    for(i = 0; i < n; i++){
        a[i] = w[i];
    }
}

void merge(int *array, int *workspace, int len){
    int i = 0;
    int j = len/2;
    int x = 0;
    while (i < len/2 && j < len){
        if (array[i] < array[j]){
            workspace[x] = array[i];
            i++;
        }else{
            workspace[x] = array[j];
            j++;
        }
        x++;
    }
    if (i == (len/2)){
        for (; j < len; j++){
            workspace[x] = array[j];
            x++;
        }
    }else if (j == (len)){
        for (; i < len/2; i++){
            workspace[x] = array[i];
            x++;
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
    int my_array[ARRAY_MAX];
    int my_array2[ARRAY_MAX];
    int count = 0;

    while (count < ARRAY_MAX && 1 == scanf("%d", &my_array[count])) {
        count++;
    }

    merge_sort(my_array, my_array2, count);
    
    print_array(my_array, count);

    return EXIT_SUCCESS;
}
