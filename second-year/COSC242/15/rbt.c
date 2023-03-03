#include <stdio.h>
#include <stdlib.h>
#include "mylib.h"
#include "rbt.h"
#include <string.h>

#define IS_BLACK(x) ((NULL == (x)) || (BLACK == (x)->colour))
#define IS_RED(x) ((NULL != (x)) && (RED == (x)->colour))

typedef enum { RED, BLACK } rbt_colour;

struct rbt_node { /* should live in rbt.c */
  char *key;
  rbt_colour colour;
  rbt left;
  rbt right; 
};

rbt rbt_new(){
    return NULL;
}

static rbt left_rotate(rbt r){
    rbt temp = r;
    r = r->right;
    temp->right = r->left;
    r->left = temp;
    return r;
}

static rbt right_rotate(rbt r){
    rbt temp = r;
    r = r->left;
    temp->left = r->right;
    r->right = temp;
    return r;
}

static rbt rbt_fix(rbt r){
    if (IS_RED(r->left) && IS_RED(r->left->left)){
        if (IS_RED(r->right)){
            r->colour = RED;
            r->left->colour = BLACK;
            r->right->colour = BLACK;
        }else if (IS_BLACK(r->right)){
            r = right_rotate(r);
            r->colour = BLACK;
            r->right->colour = RED;
        }
    }else if (IS_RED(r->left) && IS_RED(r->left->right)){
        if (IS_RED(r->right)){
            r->colour = RED;
            r->left->colour = BLACK;
            r->right->colour = BLACK;
        }else if (IS_BLACK(r->right)){
            r->left = left_rotate(r->left);
            r = right_rotate(r);
            r->colour = BLACK;
            r->right->colour = RED;
        }
    }else if (IS_RED(r->right) && IS_RED(r->right->left)){
        if (IS_RED(r->left)){
            r->colour = RED;
            r->left->colour = BLACK;
            r->right->colour = BLACK;
        }else if (IS_BLACK(r->left)){
            r->right = right_rotate(r->right);
            r = left_rotate(r);
            r->colour = BLACK;
            r->right->colour = RED;
        }
    }else if (IS_RED(r->right) && IS_RED(r->right->right)){
        if (IS_RED(r->left)){
            r->colour = RED;
            r->left->colour = BLACK;
            r->right->colour = BLACK;
        }else if (IS_BLACK(r->left)){
            r = left_rotate(r);
            r->colour = BLACK;
            r->left->colour = RED;
        }
    }
    return r;
}

rbt rbt_insert(rbt r, char *str){
    if (r == NULL){
        rbt newb = emalloc(sizeof *newb);
        newb->key = emalloc((strlen(str) + 1) * sizeof(str[0]));
        strcpy(newb->key, str);
        newb->colour = RED;
        return newb;
    }else{
        if (strcmp(str, r->key) < 0){
            r->left = rbt_insert(r->left, str);
        }else{
            r->right = rbt_insert(r->right, str);
        }
        r = rbt_fix(r);
        return r;
    }
}

int rbt_search(rbt r, char *key){
    if (r == NULL){
        return 0;
    }else if (strcmp(key, r->key) == 0){
        return 1;
    }else if (key < r->key){
        return rbt_search(r->left, key);
    }else{
        return rbt_search(r->right, key);
    }
}

rbt rbt_delete(rbt r, char *str){
    if (r == NULL){
        return r;
    }else if (strcmp(r->key, str) > 0){
        r->left = rbt_delete(r->left, str);
        return r;
    }else if (strcmp(r->key, str) < 0){
        r->right = rbt_delete(r->right, str);
        return r;
    }else{
        if (r->left == NULL && r->right == NULL){
            free(r->key);
            free(r);
            r = NULL;
            return r;
        }else if (r->left == NULL && r->right != NULL){
            free(r->key);
            free(r);
            r = r->right;
            return r;
        }else if (r->left != NULL && r->right == NULL){
            free(r->key);
            free(r);
            r = r->left;
            return r;
        }else{
            rbt leftSubTree;
            char word[256];
            rbt rightSubTree = r->right;
            while (rightSubTree->left != NULL){
                rightSubTree = rightSubTree->left;
            }
            leftSubTree = rightSubTree;
            strcpy(word, leftSubTree->key);
            leftSubTree->key = erealloc(leftSubTree->key, strlen(r->key));
            strcpy(leftSubTree->key, r->key);
            strcpy(r->key, word);

            r->right = rbt_delete(r->right, str);
            return r;
        }
    }
}

void print_key(char *s){
    printf("%s", s);
}

void rbt_inorder(rbt r, void f(char *str)){
    if (r == NULL){
        return;
    }
    rbt_inorder(r->left, f);
    f(r->key);
    if (r->colour == RED){
        printf(": RED\n");
    }else{
        printf(": BLACK\n");
    }
    rbt_inorder(r->right, f);
}

void rbt_preorder(rbt r, void f(char *str)){
    if (r == NULL){
        return;
    }
    f(r->key);
    if (r->colour == 0){
        printf(": RED\n");
    }else{
        printf(": BLACK\n");
    }
    rbt_preorder(r->left, f);
    rbt_preorder(r->right, f);
}

rbt rbt_free(rbt r){
    free(r->key);
    free(r);
    return r;
}
