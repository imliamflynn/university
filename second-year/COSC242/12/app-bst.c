#include <stdio.h>
#include <stdlib.h>
#include "mylib.h"
#include "bst.h"

int main(void){
    bst b = bst_new();

    b = bst_insert(b, "d");
    b = bst_insert(b, "b");
    b = bst_insert(b, "a");
    b = bst_insert(b, "c");
    b = bst_insert(b, "f");
    b = bst_insert(b, "e");
    b = bst_insert(b, "g");

    printf("\ninsert d, b, a, c, f, e, g\n");

    printf("\nbst_inorder\n\n");
    bst_inorder(b, print_key);
    printf("\nbst_preorder\n\n");
    bst_preorder(b, print_key);

    printf("\nbst_delete(f)\n\n");
    b = bst_delete(b, "f");

    bst_inorder(b, print_key);

    b = bst_free(b);

    return EXIT_SUCCESS;
}
