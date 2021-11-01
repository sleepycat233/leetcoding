#include <stdio.h>

int gridTraveler(int m, int n) {
    if(m == 0 || n == 0) {
        return 0;
    }
    else if(m == 1 && n == 1) {
        return 1;
    }
    else {
        return gridTraveler(m-1, n) + gridTraveler(m,n-1);
    }
}

long memo[30][30] = {0};

long gridTraveler_memo(int m, int n) {
    if(memo[m][n] != 0) return memo[m][n];
    if(m == 1 || n == 1) return 1;

    return gridTraveler_memo(m-1,n) + gridTraveler_memo(m,n-1);
}

int main() {
    printf("%d\n",gridTraveler(10, 10));
    printf("%ld\n",gridTraveler_memo(3,3));
    printf("%ld\n",gridTraveler_memo(10,10));
}