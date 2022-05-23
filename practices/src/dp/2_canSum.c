#include <stdio.h>

// return ture if t(targeSum) can be formed with sums of elements of a[];
// each element can be used multiple times
int canSum(int t, const int *a, const int n) {

    if(t == 0) { 
        return 1;
    }
    if(t < 0) {
        return 0;
    }

    for(int i = 0; i < n; i++) {
        int r = t - a[i];
        if(canSum(r, a, n) == 1) {
            return 1;
        }
    }

    return 0;
}

int main() {
    int a[] = {3, 6};
    int n = sizeof(a) / sizeof(a[0]);
    printf("%d\n", canSum(8, a, n));
}