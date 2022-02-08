class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][10];
        boolean[][] cols = new boolean[9][10];

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                boolean[] square = new boolean[10];
                for(int row = 0; row < 3; row++) {
                    for(int col = 0; col < 3; col++) {
                        int acturalrow = i*3+row;
                        int acturalcol = j*3+col;
                        char c = board[acturalrow][acturalcol];
                        int idx = (int)c-48;
                        if(c == '.') continue;
                        if(square[idx] == true) return false;
                        else square[idx] = true;
                        if(rows[acturalrow][idx] == true) return false;
                        else rows[acturalrow][idx] = true;
                        if(cols[acturalcol][idx] == true) return false;
                        else cols[acturalcol][idx] = true;
                    }
                }
            }
        }

        return true;
    }
}