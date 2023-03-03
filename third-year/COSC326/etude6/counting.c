/* This program takes two inputs from the user and figures out how many different
   combinations of the smaller number k could be made from the full population n.
   Each item from the population n is unique from each other. */

#include "counting.h"

/* Main method prompts the user to enter 2 numbers, those two numbers are stored accordingly depending on their size.
   Then main calls n_choose_k on the user inputs. */
int main(int argc, char *argv[]){
  uint64 f, s;
  printf("Enter 2 number: \n");
  while (2 == (scanf("%lu %lu", &f, &s))){
    uint64 n;
    uint64 k;
    if (f > s){
      n = f;
      k = s;
    } else {
      n = s;
      k = f;
    }
    uint64 result = n_choose_k(n, k);
    printf("n choose k of %lu and %lu is %lu\n\n", n, k, result);
    f = 0, s = 0, n = 0, k = 0;
  }
  return EXIT_SUCCESS;
}

/* Calls n_choose_k_helper with original two inputs and total starting at 1. */
uint64 n_choose_k(uint64 n, uint64 k){
  uint64 total = 1;
  return n_choose_k_helper(n, k, total, 1);
}

/* Recursive method that returns the greatest common divisor of the two parameters. */
static uint64 gcd(uint64 i, uint64 j){
    if( j == 0){ return i; }    
    return gcd(j, i % j);
} 

/* Recursive method that performs the calculation to figure out the number of combinations. */
static uint64 n_choose_k_helper(uint64 n, uint64 k, uint64 total, uint64 i){
    if (i > k){ return total; }
    uint64 g = gcd(total, i);
    total /= g;
    uint64 t = n/(i/g);
    total *= t;
    return n_choose_k_helper(--n, k, total, ++i); 
}
