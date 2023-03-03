#include <stdio.h>

int main(void){
    double s1, s2, s3, temp;
    int return_code;

    fflush(stdout);
    return_code = scanf("%lg %lg %lg", &s1, &s2, &s3);
    if (return_code != 3){
        printf("scanf returned code %d\n", return_code);
        return 1;
    }
    if (s1 < s2 && s1 < s3){
        temp = (s2 + s3) / 2;
        printf ("%f", temp);
    }else if (s2 < s1 && s2 < s3){
        temp = (s1 + s3) / 2;
        printf ("%f", temp);
    }else{
        temp = (s1 + s2) / 2;
        printf ("%f", temp);
    }
    return 0;
}
