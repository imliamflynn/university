#ifndef RBT_H_
#define RBT_H_

typedef struct rbt_node *rbt; /* should live in rbt.h */

extern rbt rbt_new();
extern rbt rbt_insert(rbt r, char *str);
extern int rbt_search(rbt r, char *key);
extern rbt rbt_delete(rbt r, char *str);
extern void print_key(char *s);
extern void rbt_inorder(rbt r, void f(char *str));
extern void rbt_preorder(rbt r, void f(char *str));
extern rbt rbt_free(rbt r);

#endif
