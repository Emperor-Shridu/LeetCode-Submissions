class Solution {
    public boolean isValidSudoku(char[][] board) {
        //9 items with 9 numbers to be there
        boolean rows[][] = new boolean[9][9];
        boolean cols[][] = new boolean[9][9];
        boolean blocks[][][] = new boolean[3][3][9];

        for(int i = 0; i<9; i++){
            for(int j = 0; j<9; j++){
                if(board[i][j]!='.'){
                    int crt = board[i][j]-'0';
                    crt--;
                    // if row is false(does not have this no rn) update to true;
                    if(rows[i][crt]) return false;
                    // if col is false update to true;
                    if(cols[j][crt]) return false;
                    // if block is false update to true;
                    if(blocks[i/3][j/3][crt]) return false;
                    // else return false;
                    // atlast return true;
                    rows[i][crt] = true;
                    cols[j][crt] = true;
                    blocks[i/3][j/3][crt] = true;
                }
            }
        }
        return true;
    }
}