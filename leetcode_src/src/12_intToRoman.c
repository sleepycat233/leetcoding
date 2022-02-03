#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char in[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
char *ro[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

char res[12];

char *intToRoman_best(char n) {
    char j = 0;
    char k = 0;
    res[0] = '\0';
    for(char i = 0; n; ++i) {
        while(n >= in[i]) {
            j = 0;
            while((res[k] = ro[i][j++]) != '\0')
                k++;

            n -= in[i];

        }
    }

    return res;
}

/* ////////////////////////////////////// */
/*
int r2i['X' + 1] = {
    ['I'] = 1,
    ['V'] = 5,
    ['X'] = 10,
    ['L'] = 50,
    ['C'] = 100,
    ['D'] = 500,
    ['M'] = 1000,
};

char r[] = {'M','D','C','L','X','V','I', '\0'};

char *intToRoman(int n)
{
    int k = 0;
    int i = 0;
    int q;      //quotient
    char *res = (char *) malloc(sizeof(char) * 20);
    char c;

    while(n%r2i[r[k]] == n) {
        k++;
    }

    while(n != 0) {
        if(n/r2i[r[k]] == 4) {
            res[i++] = r[k];
            res[i++] = r[k-1];
            n %= r2i[r[k]];
        }
        else if(r2i[r[k+1]] != 0 && n/r2i[r[k+1]] == 9) {
            res[i++] = r[k+1];
            res[i++] = r[k-1];
            n %= r2i[r[k+1]];
        }
        else {
            c = r[k];
            for(int j = 0; j < n/r2i[r[k]]; ++j) {
                res[i++] = c;
            }
            n %= r2i[r[k]];
        }
        k++;
    }
    res[i] = '\0';
    return res;
}
 */
int main() {
    // printf("%s\n", intToRoman(1994));
    printf("%s\n", intToRoman_best(9));
    printf("%s\n", intToRoman_best(58));
    // printf("%s\n", intToRoman_best(3));
}