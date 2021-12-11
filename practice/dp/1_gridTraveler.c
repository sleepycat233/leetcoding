#include <stdio.h>

// given a m*n grid
// while you can only move upward or rightward, count the total number of path between (0,0) and (m,n)
// solutions: brute-force, memo, or tabulation strategy.

// brute-force:
// time complexity: O(2^(m+n))
// space complexity: O(m+n)
int gridTraveler(int m, int n) {
    if(m == 0 || n == 0) {
        return 1;
    }
    else {
        return gridTraveler(m-1, n) + gridTraveler(m,n-1);
    }
}

#define ROW 17
#define COL 17

long memo[COL+1][ROW+1] = {0};

// memo:
// time complexity: O(m*n)
long gridTraveler_memo(int m, int n) {
    if(memo[m][n] != 0 || memo[n][m] != 0) {
        printf("mem[%d][%d] = %ld\n", m, n, memo[m][n]);
        return memo[m][n];
    }

    if(m == 0 || n == 0)
    {
        memo[m][n] = memo[n][m] = 1;
        return 1;
    }

    memo[m][n] = gridTraveler_memo(m - 1, n) + gridTraveler_memo(m, n - 1);
    memo[n][m] = memo[m][n];
    return memo[m][n];
}

// tabulation:
// construct table based on the pattern:
// tab[m][n] = tab[m-1][n] + tab[m][n-1];
// time complexity: O(m*n)
// space complexity: O(m*n)

// 0       1       1       1       1       1       1       1       1       1
// 1       2       3       4       5       6       7       8       9       10
// 1       3       6       10      15      21      28      36      45      55
// 1       4       10      20      35      56      84      120     165     220
// 1       5       15      35      70      126     210     330     495     715
// 1       6       21      56      126     252     462     792     1287    2002
// 1       7       28      84      210     462     924     1716    3003    5005
// 1       8       36      120     330     792     1716    3432    6435    11440
// 1       9       45      165     495     1287    3003    6435    12870   24310
// 1       10      55      220     715     2002    5005    11440   24310   48620


int main() {
    // printf("%d\n", gridTraveler(ROW, COL));

    printf("%ld\n",gridTraveler_memo(ROW,COL));

    for (int i = 0; i < COL + 1; i++) {
        for (int j = 0; j < ROW + 1; j++) {
            printf("%ld\t", memo[i][j]);
        }
        printf("\n");
    }
}