#include <stdio.h>

int p(int n) {
    if(n == 0) {
        return 3;
    }
    else if(n == 1) {
        return 3*3;
    }
    else {
        return 3*3*p(n-1);
    }
}

int main() {

    printf("%d\n", p(0));
    printf("%d\n", p(1));
    printf("%d\n", p(4));

    return 1;
}