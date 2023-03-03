/* This is the .h file for counting.c. */

#ifndef COUNTING_H_
#define COUNTING_H_

/* Libraries to import. */
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <getopt.h>
#include <limits.h>


/* Method headers. */
int main(int argc, char* argv[]);
typedef unsigned long int uint64;
static uint64 gcd(uint64 i, uint64 j);
uint64 n_choose_k(uint64 n, uint64 k);
static uint64 n_choose_k_helper(uint64 n, uint64 k, uint64 total, uint64 i);
#endif
