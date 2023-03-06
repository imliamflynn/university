#include <stdio.h>
#include <stdlib.h>
#include <getopt.h>
#include <string.h>
#include <time.h>
#include "mylib.h"
#include "tree.h"

/*
 * @author - Liam Flynn
 * @author - James Tucker
 * @author - Ben Stacey
*/

/**
 * Program entrypoint, the user enters commands into the command line 
 * and then the switch routes the program in the correct direction 
 * depending on the input.
 * 
 * Case c: Check the spelling of words in filename using words read 
 * from stdin as the dictionary. Print all unknown words to stdout. 
 * Print timing information and unknown word count to stderr. 
 * When this option is given then the -d and -o options should 
 * be ignored.
 * 
 * Case d: Print the depth of the tree to stdout and don’t do anything 
 * else
 * 
 * Case f: Write the "dot" output to filename instead of the default 
 * file name if -o is also given
 * 
 * Case o: Output a representation of the tree in "dot" form to the file
    ‘tree-view.dot’ using the functions given in output-dot.txt.
 * 
 * Case r: Make the tree an rbt instead of the default bst.
 * 
 * Case h: Print a help message describing how to use the program
 * 
 * @param argc
 * @param argv
 * @return EXIT_SUCCESS
 */
int main(int argc, char *argv[]){
    tree t = NULL;
    FILE * fp;
    clock_t start_fill, end_fill, start_search, end_search;
    int cChoice = 0, dChoice = 0, fChoice = 0, oChoice = 0, words = 0;
    char word[256];
    tree_t t_type = BST;
    const char *optstring = "c:df:orh";
    char option;
    while ((option = getopt(argc, argv, optstring)) != EOF) {
        switch (option) {
            case 'c':
                cChoice = 1;
                break;
            case 'd':
                dChoice = 1;
                break;
            case 'f':
                fChoice = 1;
                break;
            case 'o':
                oChoice = 1;
                break;
            case 'r':
            /** Make the tree an rbt instead of the default bst.*/
                t_type = RBT;
                break;
            case 'h':
            /** if the user enters -h then this shows them how to use the 
             * program*/
                printf("Usage: ./asgn2 [OPTION]... <STDIN>\n\n");
                printf("-c FILENAME  UCheck the spelling of words in \n "
                "filename using words read from stdin\n"
                "as the dictionary. Print all unknown words to stdout.\n "
                "Print timing information and unknown word count to stderr.\n"
                "When this option is given then the -d and -o options\n"
                "should be ignored.\n\n");
                printf("-d  Print the depth of the tree to stdout and\n "
                "don’t do anything else\n\n");
                printf("-f FILENAME  Write the 'dot' output to filename\n "
                "instead of the default file name if -o is also given.\n\n");
                printf("-o  Output a representation of the tree in 'dot'\n "
                "form to the file‘tree-view.dot’ using the functions given\n"
                "in output-dot.txt.\n\n");
                printf("-r  Make the tree an rbt instead of the default\n"
                "bst.\n\n");
                printf("-h  Print a help message describing how to use\n"
                "the program\n\n");
                break;
            default:
            /** if the user enters the wrong input then this shows them how 
             * to use the program*/
                printf("Usage: ./asgn2 [OPTION]... <STDIN>\n\n");
                printf("-c FILENAME  UCheck the spelling of words in \n "
                "filename using words read from stdin\n"
                "as the dictionary. Print all unknown words to stdout.\n "
                "Print timing information and unknown word count to stderr.\n"
                "When this option is given then the -d and -o options\n"
                "should be ignored.\n\n");
                printf("-d  Print the depth of the tree to stdout and\n "
                "don’t do anything else\n\n");
                printf("-f FILENAME  Write the 'dot' output to filename\n "
                "instead of the default file name if -o is also given.\n\n");
                printf("-o  Output a representation of the tree in 'dot'\n "
                "form to the file‘tree-view.dot’ using the functions given\n"
                "in output-dot.txt.\n\n");
                printf("-r  Make the tree an rbt instead of the default\n"
                "bst.\n\n");
                printf("-h  Print a help message describing how to use\n"
                "the program\n\n");
                break;
        }
    }
    /**
     * This creates a new tree and then fills it 
     * depending if it is a rbt or bst depends on
     * which if statement is chosen
     */
    t = tree_new(t_type);
    start_fill = clock();
    if  (t_type == BST){
        while (getword(word, sizeof word, stdin) != EOF){
            bst_insert(t, word);
        }
    }   else if(t_type == RBT) {
        while (getword(word, sizeof word, stdin) != EOF){
            rbt_insert(t, word);
        }
    }
    /** finds the fill time*/
    end_fill = clock();

    /* everytime a duplicate word is inserted into the tree
    ++ on frequency which is in the struct */

    if (cChoice == 1) {
        fp = fopen(argv[2], "r");
        words = 0;
        start_search = clock();
        while (getword(word, sizeof word, fp) != EOF){
            if (tree_search(t, word)) {
                words++;
            }
        }
        end_search = clock();

        fprintf(stderr, "Fill time: %f seconds\n",  
        ((end_fill - start_fill) / (double)CLOCKS_PER_SEC));
        fprintf(stderr, "Search time: %f seconds\n",  
        ((end_search - start_search) / (double)CLOCKS_PER_SEC));
        printf("Unknown words = %d\n", words);
        fclose(fp);
    }

    if(dChoice == 1 && cChoice == 0){
        /* Print the depth of the tree to stdout and 
        don’t do anything else */
        tree_depth((tree) t_type);
        printf("The length of the longest path between root node and\n"
        "furthest leaf node: %d\n", tree_depth(t));
    }

    if(fChoice == 1){
        if (oChoice == 1 && cChoice == 0){
            /* -f filename */

            /* Write the "dot" output to filename instead of the 
            default file name
            * if -o is also given. */
            fp = fopen(argv[2], "w+");
            tree_output_dot(t, fp);
        }
    }

    if(oChoice == 1 && cChoice == 0){
        /*Output a representation of the tree in "dot" form to the file
         *‘tree-view.dot’ using the functions given in output-dot.txt.
         */
        fp = fopen("tree-view.dot", "w+");
        tree_output_dot(t, fp);
    }

    /** frees the tree*/
    tree_free(t);
    
    return EXIT_SUCCESS;
}
