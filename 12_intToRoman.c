#include <stdio.h>
#include <stdlib.h>

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

int main() {
    printf("%s\n", intToRoman(1994));
}