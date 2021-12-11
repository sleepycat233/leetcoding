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
    if(memo[m][n] != 0 || memo[n][m] != 0) {
        printf("mem[%d][%d] = %ld\n", m, n, memo[m][n]);
        return memo[m][n];
    }

    if(m == 1 || n == 1) return 1;

    memo[m][n] = gridTraveler_memo(m - 1, n) + gridTraveler_memo(m, n - 1);
    memo[n][m] = memo[m][n];
    return memo[m][n];
}

int main() {
    printf("%d\n",gridTraveler(10, 10));
    printf("%ld\n",gridTraveler_memo(4,3));

    //
    for(int i = 0; i < 30; i++) {
        for (int j = 0; j < 30; j++) {
            if(memo[i][j] != 0) {
                printf("memo[%d][%d] = %ld\n", i, j, memo[i][j]);
            }
        }
    }
    // printf("%ld\n",gridTraveler_memo(10,10));
}