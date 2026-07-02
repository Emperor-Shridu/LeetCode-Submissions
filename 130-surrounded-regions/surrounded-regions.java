class Solution {
    int[] dirRow = {0,0,1,-1};
    int[] dirCol = {1,-1, 0, 0};
    
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length; 
        int n = board[0].length;
        
        // 1. Left and Right boundaries (Row moving, Col fixed)
        for(int i = 0; i < m; i++){
            if(board[i][0] == 'O') dfs(i, 0, board);
            if(board[i][n-1] == 'O') dfs(i, n-1, board);
        }
        
        // 2. Top and Bottom boundaries (Col moving, Row fixed)
        // FIXED: Loop boundary changed from m to n
        for(int j = 0; j < n; j++){
            if(board[0][j] == 'O') dfs(0, j, board);
            if(board[m-1][j] == 'O') dfs(m-1, j, board);
        }

        // 4. Final Cleanup Pass (Moved here from the DFS method)
        for(int a = 0; a < m; a++){
            for(int b = 0; b < n; b++){
                if(board[a][b] == 'O') board[a][b] = 'X';
                if(board[a][b] == 'T') board[a][b] = 'O';
            }
        }
    }

    void dfs(int i, int j, char[][] board){
        int m = board.length;
        int n = board[0].length;

        Stack<int[]> s = new Stack<>();
        s.push(new int[]{i, j});
        
        while(!s.isEmpty()){
            int[] crt = s.pop();
            int r = crt[0]; 
            int c = crt[1];
            
            if(board[r][c] == 'T') continue;

            board[r][c] = 'T';
            for(int k = 0; k < 4; k++){
                int nr = r + dirRow[k];
                int nc = c + dirCol[k];
                // FIXED: Bound check should be < m and < n (not m-1 / n-1)
                if(nr >= 0 && nc >= 0 && nr < m && nc < n && board[nr][nc] == 'O') {
                    s.push(new int[]{nr, nc});
                }
            }
        }
    }
}

/* =========================================================================
   ALTERNATIVE REGULAR RECURSIVE DFS (Cleanest Optimal Approach)
   =========================================================================
   Using system call-stack recursion instead of an explicit java.util.Stack 
   makes the code shorter and eliminates object instantiation overhead.

class SolutionOptimal {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length, n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') recursiveDfs(board, i, 0);
            if (board[i][n - 1] == 'O') recursiveDfs(board, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') recursiveDfs(board, 0, j);
            if (board[m - 1][j] == 'O') recursiveDfs(board, m - 1, j);
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == 'T') board[i][j] = 'O';
            }
        }
    }
    
    private void recursiveDfs(char[][] board, int r, int c) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != 'O') {
            return;
        }
        board[r][c] = 'T';
        recursiveDfs(board, r + 1, c);
        recursiveDfs(board, r - 1, c);
        recursiveDfs(board, r, c + 1);
        recursiveDfs(board, r, c - 1);
    }
}
========================================================================= */