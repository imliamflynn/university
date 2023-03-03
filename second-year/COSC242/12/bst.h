#ifndef BST_H_
#define BST_H_

typedef struct bst_node *bst; /* should live in bst.h */

extern bst bst_new();
extern bst bst_insert(bst b, char *str);
extern int bst_search(bst b, char *key);
extern bst bst_delete(bst b, char *str);
extern void print_key(char *s);
extern void bst_inorder(bst b, void f(char *str));
extern void bst_preorder(bst b, void f(char *str));
extern bst bst_free(bst b);

#endif
