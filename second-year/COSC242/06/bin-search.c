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

int bin_search(int *a, int n, int x){
    int m;
    
    if (n <= 0){
        if(a[n] == x){
            return 1;
        }
        return 0;
    }else{
        m = n/2;
        if (a[m] == x){
            return 1;
        }else if(a[m] > x){
            return bin_search(a, m-1, x);
        }else{
            return bin_search(a+m+1, n-(m+1), x);
        }
    }
}

int main(int argc, char **argv) {
    /*Variables*/
    FILE *infile;
    int array1[ARRAY_MAX];
    int array2[ARRAY_MAX];
    int count1 = 0;
    int count2 = 0;

    if (NULL == (infile = fopen(argv[1], "r"))){
        fprintf(stderr, "%s: can't find file %s\n", argv[0], argv[1]);
        return EXIT_FAILURE;
    }

    /*Takes input and puts it into the array*/
    while (count1 < ARRAY_MAX && 1 == fscanf(infile, "%d", &array1[count1])) {
        count1++;
    }
    
    insertion_sort(array1, count1);

    while (count2 < ARRAY_MAX && 1 == scanf("%d", &array2[count2])) {
        if (bin_search(array1, count1, array2[count2]) == 1){
            printf("+\n");
        }else{
            printf("-\n");
        }
        count2++;
    }

    fclose(infile);
    
    return EXIT_SUCCESS;
}
