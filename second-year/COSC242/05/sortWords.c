#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define STRING_LEN 80
#define ARRAY_LEN 10000

void *emalloc(size_t s) {
    void *result = malloc(s);
    if (NULL == result) {
        fprintf(stderr, "Memory allocation failed!\n");
        exit(EXIT_FAILURE);
    }
    return result;
}

void insertion_sort(char **a, int n) {
    int i, j;
    char *key;
    for (i = 0; i < n; i++){
        key = a[i];
        for (j = i - 1; j >= 0; j--){ 
            if (strcmp(a[j], key) > 0){ /* (a[j] > key) */
                a[j+1] = a[j];
                a[j] = key;
            }
        }
    }
}

int main(void) {
    char word[STRING_LEN];
    char *wordlist[ARRAY_LEN];
    int i, num_words;
    
    num_words = 0;
    while (num_words < ARRAY_LEN && 1 == scanf("%79s", word)) {
        wordlist[num_words] = emalloc((strlen(word) + 1)
                                      * sizeof wordlist[0][0]);
        strcpy(wordlist[num_words], word);
        num_words++;
    }

    insertion_sort(wordlist, num_words);
    for (i = 0; i < num_words; i++) {
        printf("%79s\n", wordlist[i]); /*Prints sorted array*/
    }
    
    for (i = 0; i < num_words; i++) {
        free(wordlist[i]);
    }
    
    return EXIT_SUCCESS;
}
