#ifndef MYLIB_H_
#define MYLIB_H_

#include <stddef.h>
#include <stdbool.h>

/*
 * @author - Liam Flynn
 * @author - James Tucker
 * @author - Ben Stacey
*/

/*
 * Function declarations for mylib.
 * */
extern void *emalloc(size_t);
extern void *erealloc(void *, size_t);
extern int getword(char *s, int limit, FILE *stream);

#endif
