#include <stdio.h>
#include <stdlib.h>

#define OCEAN_MAX 41981

/*program reads in a pile of struct ocean_datums, sorts them
  by oxygen content, then prints out the sorted data*/
struct ocean_datum {
    int x;       /*grid-reference east-west*/
    int y;       /*grid-reference north-south*/
    double conc; /*concentration of O_2 in mL/L found at grid-ref (x,y)*/
};

void insertion_sort(struct ocean_datum *a, int n) {
    int i, j;
    double key;
    for (i = 0; i < n; i++){
        key = a[i].conc;
        for (j = i - 1; j >= 0; j--){ 
            if (a[j].conc > key){ /* (a[j] > key) */
                a[j+1].conc = a[j].conc;
                a[j].conc = key;
            }
        }
    }
}

void print_ocean_datum(struct ocean_datum *o) {
    printf("%d %d %.4f\n", o->x, o->y, o->conc);
}

int read_ocean_datum(struct ocean_datum *o) {
    return 3 == scanf("%d %d %lg", &o->x, &o->y, &o->conc);
}

int main(void) {
    struct ocean_datum ocean_data[OCEAN_MAX];
    int num_items;
    int i;
    
    num_items = 0;
    while (num_items < OCEAN_MAX &&
           read_ocean_datum(&ocean_data[num_items])) {
        num_items++;
    }
    
    /* sort the data here */
    insertion_sort(ocean_data, num_items);
    
    /* print out the array of structs */
    for (i = 0; i < num_items; i++) {
        print_ocean_datum(&ocean_data[i]);
    }
    
    return EXIT_SUCCESS;
}
