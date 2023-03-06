#ifndef TREE_H_                                                                                                                                                                                                                            
#define TREE_H_     

/*
 * @author - Liam Flynn
 * @author - James Tucker
 * @author - Ben Stacey
*/

/**
 * struct definitions for struct
 */
typedef enum tree_e { BST, RBT } tree_t;
typedef enum { RED, BLACK } rbt_colour;

typedef struct tree_node *tree;

/**
 * function declarations for tree.c
 */
  extern tree tree_new(tree_t t_type);
  extern tree bst_insert(tree b, const char *str);
  extern int tree_search(tree root, const char *str);
  extern void print_key(char *s);                                                                                                                                                                                                           
  extern void bst_inorder(tree b, void f(const char *str));
  extern void bst_preorder(tree b, void f(const char *str));
  extern tree rbt_insert(tree r, const char *str);
  extern void rbt_inorder(tree r, void f(const char *str));
  extern void rbt_preorder(tree r, void f(const char *str));
  extern void tree_free(tree r);
  extern tree rbt_fix(tree r);
  extern tree left_rotate(tree r);
  extern tree right_rotate(tree r);
  extern void tree_output_dot(tree t, FILE *out);
  extern int tree_depth(tree t);
  extern tree_t tree_type;
  extern void inorder(tree root);
#endif 
