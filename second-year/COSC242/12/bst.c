#include <stdio.h>
#include <stdlib.h>
#include "mylib.h"
#include "bst.h"
#include <string.h>

struct bst_node { /* should live in bst.c */
  char *key;
  bst left;
  bst right; 
};

bst bst_new(){
    return NULL;
}

bst bst_insert(bst b, char *str){
    if (b == NULL){
        bst newb = emalloc(sizeof *newb);
        newb->key = emalloc((strlen(str) + 1) * sizeof(str[0]));
        strcpy(newb->key, str);
        return newb;
    }else{
        if (strcmp(str, b->key) < 0){
            b->left = bst_insert(b->left, str);
        }else{
            b->right = bst_insert(b->right, str);
        }
        return b;
    }
}

int bst_search(bst b, char *key){
    if (b == NULL){
        return 0;
    }else if (strcmp(key, b->key) == 0){
        return 1;
    }else if (key < b->key){
        return bst_search(b->left, key);
    }else{
        return bst_search(b->right, key);
    }
}

bst bst_delete(bst b, char *str){
    if (b == NULL){
        return b;
    }else if (strcmp(b->key, str) > 0){
        b->left = bst_delete(b->left, str);
        return b;
    }else if (strcmp(b->key, str) < 0){
        b->right = bst_delete(b->right, str);
        return b;
    }else{
        if (b->left == NULL && b->right == NULL){
            free(b->key);
            free(b);
            b = NULL;
            return b;
        }else if (b->left == NULL && b->right != NULL){
            free(b->key);
            free(b);
            b = b->right;
            return b;
        }else if (b->left != NULL && b->right == NULL){
            free(b->key);
            free(b);
            b = b->left;
            return b;
        }else{
            bst leftSubTree;
            char word[256];
            bst rightSubTree = b->right;
            while (rightSubTree->left != NULL){
                rightSubTree = rightSubTree->left;
            }
            leftSubTree = rightSubTree;
            strcpy(word, leftSubTree->key);
            leftSubTree->key = erealloc(leftSubTree->key, strlen(b->key));
            strcpy(leftSubTree->key, b->key);
            strcpy(b->key, word);

            b->right = bst_delete(b->right, str);
            return b;
        }
    }
}

void print_key(char *s){
    printf("%s\n", s);
}

void bst_inorder(bst b, void f(char *str)){
    if (b == NULL){
        return;
    }
    bst_inorder(b->left, f);
    f(b->key);
    bst_inorder(b->right, f);
}

void bst_preorder(bst b, void f(char *str)){
    if (b == NULL){
        return;
    }
    f(b->key);
    bst_preorder(b->left, f);
    bst_preorder(b->right, f);
}

bst bst_free(bst b){
    free(b->key);
    free(b);
    return b;
}
