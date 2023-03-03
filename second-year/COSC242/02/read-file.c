#include <stdio.h>

int main(void){
    int reg, regwin = 0;
    double s1, s2, s3, temp, swin = 0.0;   

    while (4 == scanf("%d%lg%lg%lg", &reg, &s1, &s2, &s3)){
        if (s1 < s2 && s1 < s3){
            temp = (s2 + s3) / 2;
        }else if (s2 < s1 && s2 < s3){
            temp = (s1 + s3) / 2;
        }else{
            temp = (s1 + s2) / 2;
        }

        if (swin == 0.0){
            regwin = reg;
            swin = temp;
        }

        if (temp > swin){
            regwin = reg;
            swin = temp;
        }
    }
    
    printf("\nThe winner is %d with an average score of %f\n\n", regwin, swin);
    return 0;
}
