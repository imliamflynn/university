#include <stdio.h>
#include <stdlib.h>
#include "mylib.h"
#include "htable.h"
#include <string.h>

struct htablerec{
    int cap;
    int num_keys;
    char **keys;
    int *freqs;
};

htable htable_new(int c){
    int i, j;
    htable h = emalloc(sizeof *h);
    h->cap = c;
    h->num_keys = 0;
    h->keys = emalloc(h->cap * sizeof h->keys[0]);
    h->freqs = emalloc(h->cap * sizeof h->freqs[0]);
    for (i = 0; i < c; i++) h->keys[i] = NULL;
    for (j = 0; j < c; j++) h->freqs[j] = 0;
    return h;
}

void htable_free(htable h){
    int i;
    for (i = 0; i < h->cap; i++){
        if (h->keys[i] == NULL){
            continue;
        }
        free(h->keys[i]);
    }
    free(h->keys);
    free(h->freqs);
    free(h);
}

static unsigned int htable_step(htable h, unsigned int i_key){
    return 1 + (i_key % (h->cap - 1));
}

static unsigned int word_to_int(char *word) {
    unsigned int result = 0;
    while (*word != '\0') {
        result = (*word++ + 31 * result);
    }
    return result;
}

int htable_insert(htable h, char *key){
    unsigned int x, index, step;
    int i = 0;
    x = word_to_int(key);
    index = x % h->cap;
    step = htable_step(h, x);
    while (i < h->cap){
    if (h->keys[index] == NULL){
        h->keys[index] = emalloc((strlen(key) + 1) * sizeof(key[0]));
        strcpy(h->keys[index], key);
        h->freqs[index]++;
        h->num_keys++;
        return 1;
    }else if (strcmp(h->keys[index], key) == 0){
        h->freqs[index]++;
        return h->freqs[index];
    }
    index = (index + step) % h->cap;
    i++;
    }
    
    return 0;
}

int htable_search(htable h, char *key){
    unsigned int x, index, step;
    int cols = 0;
    x = word_to_int(key);
    index = x % h->cap;
    step = htable_step(h, x);
    while (h->keys[index] != NULL && strcmp(h->keys[index], key) != 0){
        if (cols == h->cap){
            return 0;
        }
        index = (index + step) % h->cap;
        cols++;
    }
     return h->freqs[index];
}

void htable_print(htable h, FILE *stream){
    int i;
    for (i = 0; i < h->cap; i++){
        if (h->keys[i] != NULL){
            fprintf(stream, "%d : %s\n", h->freqs[i], h->keys[i]);
        }
    }
}
