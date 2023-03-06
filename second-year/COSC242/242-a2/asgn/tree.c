#include <stdio.h>
#include <stdlib.h>
#include "mylib.h"
#include "tree.h"
#include <string.h>

#define IS_BLACK(x) ((NULL == (x)) || (BLACK == (x)->colour))
#define IS_RED(x) ((NULL != (x)) && (RED == (x)->colour))

/*
 * @author - Liam Flynn
 * @author - James Tucker
 * @author - Ben Stacey
*/

/**
 * Set the default value for tree_type to be BST
 */
tree_t tree_type;

/**
 * Struct for the tree data structure
 */
struct tree_node{
    char *key;
    tree left;
    tree right;
    rbt_colour colour;
    int frequency;
};

/**
 * Creates a new tree
 * 
 * @param tree_type - the type of tree
 * @return b - returns the created tree
 */
tree tree_new(tree_t t_type){
    tree t = emalloc(sizeof(struct tree_node));
    t->right = t->left = NULL;
    t->key = emalloc(sizeof(char*));
    t->frequency = 0;
    tree_type = t_type;
    return t;
}

/**
 * Refactored function to create a new node
 * for either the RBT or BST
 *
 * @param t - the input tree
 * @param item - the key to set to the node
 * @return - the tree node
 */
tree new_node(tree t, const char* item) {
    t = emalloc(sizeof(struct tree_node));
    t->key = emalloc(sizeof(char) * (strlen(item) + 1));
    t->left = t->right = NULL;
    strcpy(t->key, item);
    t->frequency = 0;
    return t;
}

/**
 * insert the the values given into the BST
 * 
 * @param b - is the given BST
 * @param str - is the value given to input
 * @return - returns the BST
 */

tree bst_insert(tree b, const char *str){
    if (b == NULL) {
        b = new_node(b, str);
    }   else if (strcmp(b->key, str) == 0){
        b->frequency++;
    }   else if (strcmp(b->key, str) < 0){
        b->left = bst_insert(b->left, str);
    }   else {
        b->right = bst_insert(b->right, str);
    }
    return b;
}

/**
 * Insert the the values given into the RBT
 * the RBT differs from the BST
 * in that we add colour to the
 * root node, and also perform fix-ups after insertion.
 *
 * @param b - The input BST
 * @param str - The value to insert
 * @return - returns the RBT
 */
tree rbt_insert(tree b, const char *str)  {
    if  (b == NULL){
        b = new_node(b, str);
        b->colour = BLACK;
    }   else if (strcmp(b->key, str) == 0) {
        b->frequency++;
    }   else if (strcmp(b->key, str) < 0) {
        b->left = rbt_insert(b->left, str);
        b = rbt_fix(b);
    }   else {
        b->right = rbt_insert(b->right, str);
        b = rbt_fix(b);
    }
    return b;
}

/**
 * inorder orders the rbt in alphabethical order
 * 
 * @param b - the rbt
 * @param f - the 
 * @return - method returns if there is no rbt
 */
void rbt_inorder(tree b, void f(const char *str)){
    if(b == NULL){
        return;
    }
    rbt_inorder(b->left, f);
    f(b->key);
    if(b->colour == RED){
        printf(": RED\n");
    }else{
        printf(": BLACK\n");
    }
    rbt_inorder(b->right, f);
}

/**
 * preorder orders the back through the rbt
 * 
 * @param b - the rbt
 * @param f - the 
 * @return - method returns if there is no rbt
 */
void rbt_preorder(tree b, void f(const char *str)){
    if(b == NULL){
        return;
    }
    f(b->key);
    if(b->colour == RED){
        printf(": RED\n");
    }else{
        printf(": BLACK\n");
    }
    rbt_preorder(b->left, f);
    rbt_preorder(b->right, f);
}

/**
 * this rotates the left hand side of the rbt
 * 
 * @param r - the rbt
 * @return r - the new rbt
 */
tree left_rotate(tree r){
    tree temp = r;
    r = r->right;
    temp->right = r->left;
    r->left = temp;
    return r;
}

/**
 * this rotates the right hand side of the rbt
 * 
 * @param r - the rbt
 * @return r - the new rbt
 */
tree right_rotate(tree r){
    tree temp = r;
    r = r->left;
    temp->left = r->right;
    r->right = temp;
    return r;    
}

/**
 * Sorts the colours in the RBT
 * 
 * @param b - the rbt
 * @return b - the new rbt
 */
tree rbt_fix(tree r){
    if (IS_RED(r->left) && IS_RED(r->left->left)) {
        if (IS_RED(r->right)) {
            r->colour = RED;
            r->left->colour = BLACK;
            r->right->colour = BLACK;
        } else if (IS_BLACK(r->right)) {
            r = right_rotate(r);
            r->colour = BLACK;
            r->right->colour = RED;
        }
    } else if (IS_RED(r->left) && IS_RED(r->left->right)) {
        if (IS_RED(r->right)){
            r->colour = RED;
            r->left->colour = BLACK;
            r->right->colour = BLACK;
        } else if (IS_BLACK(r->right)){
            r->left = left_rotate(r->left);
            r = right_rotate(r);
            r->colour = BLACK;
            r->right->colour = RED;
        }
    } else if (IS_RED(r->right) && IS_RED(r->right->left)) {
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
    } else if (IS_RED(r->right) && IS_RED(r->right->right)) {
        if (IS_RED(r->left)){
            r->colour = RED;
            r->left->colour = BLACK;
            r->right->colour = BLACK;
        } else if (IS_BLACK(r->left)) {
            r = left_rotate(r);
            r->colour = BLACK;
            r->left->colour = RED;
        }
    }
    return r;
}

/**
 * This method takes a string given and searches the tree for
 * that string
 * 
 * @param b - the tree given
 * @param str - the value its searching for
 * @return 0 - if no match
 * @return 1 - if there is an empty bst
 * @return bst(b->left, str) - search left of bst
 * @return bst(b->right, str) - search right of bst
 */

int tree_search(tree root, const char *str) {
    int res = 0;
    if (root != NULL) {
        res = strcmp(root->key, str);
        if (res < 0) {
            return tree_search(root->left, str);
        }   else if (res > 0) {
            return tree_search(root->right, str);
        }   else if (res == 0) {
            /* Found in tree */
            return 0;
        }
    }   else {
        /*printf("Could not find '%s' in the tree\n", str);*/
        return 1;
    }
    return 0;
}

/**
 * this method prints out the values 
 * 
 * @param s - the value to print
 */
void print_key(char *s){
    printf("%s\n", s);
}

/**
 * inorder orders the bst in alphabetical order
 * 
 * @param b - the bst
 * @param f - the 
 * @return - method returns if there is no bst
 */
void bst_inorder(tree b, void f(const char *str)){
    if(b == NULL){
        return;
    }
    bst_inorder(b->left, f);
    f(b->key);
    bst_inorder(b->right, f);
}

/**
 * preorder orders the 
 * 
 * @param b - the bst
 * @param f - the 
 * @return - method returns if there is no bst
 */
void bst_preorder(tree b, void f(const char *str)){
    if(b == NULL){
        return;
    }
    
    f(b->key);
    bst_preorder(b->left, f);
    bst_preorder(b->right, f);
}

/**
 * this frees the memory of the bst
 * once it has been used
 * 
 * @param - the bst
 * @return b - the new bst
 */
void tree_free(tree b) {
    if (b == NULL) {
        return;
    }
    tree_free(b->left);
    tree_free(b->right);
    free(b->key);
    free(b);
}                                                                                                                                                                                                                                       
                                                                                                                                                                                                                                            
  /**                                                                                                                                                                                                                                       
   * Traverses the tree writing a DOT description about connections, and                                                                                                                                                                    
   * possibly colours, to the given output stream.                                                                                                                                                                                          
   *                                                                                                                                                                                                                                        
   * @param t the tree to output a DOT description of.                                                                                                                                                                                      
   * @param out the stream to write the DOT output to.                                                                                                                                                                                      
   */                                                                                                                                                                                                                                       
  static void tree_output_dot_aux(tree t, FILE *out) {
     if (t == NULL) {                                                                                                                                                                                                                      
          return;                                                                                                                                                                                                                           
      }                                                                                                                                                                                                                                     
      if(t->key != NULL) {                                                                                                                                                                                                                  
          fprintf(out, "\"%s\"[label=\"{<f0>%s:%d|{<f1>|<f2>}}\"color=%s];\n",                                                                                                                                                              
                  t->key, t->key, t->frequency,                                                                                                                                                                                             
                  (RBT == tree_type && RED == t->colour) ? "red": "black");
      }                                                                                                                                                                                                                                     
      if(t->left != NULL) {                                                                                                                                                                                                                 
          tree_output_dot_aux(t->left, out);                                                                                                                                                                                                
          fprintf(out, "\"%s\":f1 -> \"%s\":f0;\n", t->key, t->left->key);                                                                                                                                                                  
      }                                                                                                                                                                                                                                     
      if(t->right != NULL) {                                                                                                                                                                                                                
          tree_output_dot_aux(t->right, out);                                                                                                                                                                                               
          fprintf(out, "\"%s\":f2 -> \"%s\":f0;\n", t->key, t->right->key);                                                                                                                                                                 
      }            
  }

    /**                                                                                                                                                                                                                                       
    * Output a DOT description of this tree to the given output stream.                                                                                                                                                                      
    * DOT is a plain text graph description language (see www.graphviz.org).                                                                                                                                                                 
    * You can create a viewable graph with the command                                                                                                                                                                                       
    *                                                                                                                                                                                                                                        
   *    dot -Tpdf < dotfile > dotfile.pdf                                                                                                                                                                                                   
   *                                                                                                                                                                                                                                        
   * where 'dotfile' is a file that has been written by tree_output_dot()                                                                                                                                                                   
   *                                                                                                                                                                                                                                        
   * You can also use png, ps, jpg, svg... instead of pdf                                                                                                                                                                                   
   *                                                                                                                                                                                                                                        
   * @param t the tree to output the DOT description of.                                                                                                                                                                                    
   * @param out the stream to write the DOT description to.                                                                                                                                                                                 
   */                                                                                                                                                                                                                                       
  void tree_output_dot(tree t, FILE *out) {                                                                                                                                                                                                 
      fprintf(out, "digraph tree {\nnode [shape = Mrecord, penwidth = 2];\n");                                                                                                                                                              
      tree_output_dot_aux(t, out);                                                                                                                                                                                                          
      fprintf(out, "}\n");                                                                                                                                                                                                                  
  }  

/**
 * Prints the depth of the tree
 * 
 * @param t - the tree
 */
int tree_depth(tree t){
    int lDepth, rDepth = 0;
    if (t == NULL) {
        return 0;
    }   else {
        lDepth = tree_depth(t->left);
        rDepth = tree_depth(t->right);
        if (lDepth > rDepth) {
            return (lDepth + 1);
        }   else {
            return (rDepth + 1);
        }
    }
}
