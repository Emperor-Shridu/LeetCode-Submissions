class Solution {
    int[] dirRow = {0, 0, 1, -1};
    int[] dirCol = {1, -1, 0, 0};

    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length;
        int n = board[0].length;

        // Scan every single cell on the board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If we find an 'O', run a full check to see if it can escape to any border
                if (board[i][j] == 'O') {
                    // If this 'O' component cannot escape, flip the whole component to 'X'
                    if (!canEscape(i, j, board)) {
                        flipToX(i, j, board);
                    }
                }
            }
        }
    }

    // Unoptimal DFS 1: Explores the entire component to see if ANY cell hits a boundary
    private boolean canEscape(int startX, int startY, char[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        boolean[][] visited = new boolean[m][n];
        Stack<int[]> s = new Stack<>();
        
        s.push(new int[]{startX, startY});
        visited[startX][startY] = true;
        
        boolean hasEscaped = false;

        while (!s.isEmpty()) {
            int[] crt = s.pop();
            int r = crt[0];
            int c = crt[1];

            // If any cell in this connected component touches a boundary, it can escape!
            if (r == 0 || r == m - 1 || c == 0 || c == n - 1) {
                hasEscaped = true; // Set to true, but continue exploring to track the whole component
            }

            for (int k = 0; k < 4; k++) {
                int nr = r + dirRow[k];
                int nc = c + dirCol[k];

                if (nr >= 0 && nc >= 0 && nr < m && nc < n) {
                    if (board[nr][nc] == 'O' && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        s.push(new int[]{nr, nc});
                    }
                }
            }
        }
        return hasEscaped;
    }

    // Unoptimal DFS 2: Only called if canEscape returned false. Flips the trapped component to 'X'
    private void flipToX(int startX, int startY, char[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        Stack<int[]> s = new Stack<>();
        s.push(new int[]{startX, startY});
        board[startX][startY] = 'X';

        while (!s.isEmpty()) {
            int[] crt = s.pop();
            int r = crt[0];
            int c = crt[1];

            for (int k = 0; k < 4; k++) {
                int nr = r + dirRow[k];
                int nc = c + dirCol[k];

                if (nr >= 0 && nc >= 0 && nr < m && nc < n && board[nr][nc] == 'O') {
                    board[nr][nc] = 'X';
                    s.push(new int[]{nr, nc});
                }
            }
        }
    }
}

/* =========================================================================
   OPTIMAL METHOD: BOUNDARY MULTI-SOURCE DFS (Keep in comments for reference)
   =========================================================================
   Time Complexity: O(M * N)
   Space Complexity: O(M * N)
   
   Instead of searching from every cell inward, reverse the logic: find cells 
   that CANNOT be captured by walking inward ONLY from the boundaries.

class SolutionOptimal {
    int[] dirRow = {0,0,1,-1};
    int[] dirCol = {1,-1, 0, 0};
    
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length; 
        int n = board[0].length;
        
        // 1. Left and Right boundaries
        for(int i = 0; i < m; i++){
            if(board[i][0] == 'O') optimalDfs(i, 0, board);
            if(board[i][n-1] == 'O') optimalDfs(i, n-1, board);
        }
        
        // 2. Top and Bottom boundaries
        for(int j = 0; j < n; j++){
            if(board[0][j] == 'O') optimalDfs(0, j, board);
            if(board[m-1][j] == 'O') optimalDfs(m-1, j, board);
        }

        // 3. Final Sweep
        for(int a = 0; a < m; a++){
            for(int b = 0; b < n; b++){
                if(board[a][b] == 'O') board[a][b] = 'X';
                if(board[a][b] == 'T') board[a][b] = 'O';
            }
        }
    }

    void optimalDfs(int i, int j, char[][] board){
        int m = board.length; int n = board[0].length;
        Stack<int[]> s = new Stack<>();
        s.push(new int[]{i, j});
        
        while(!s.isEmpty()){
            int[] crt = s.pop();
            int r = crt[0]; int c = crt[1];
            if(board[r][c] == 'T') continue;

            board[r][c] = 'T';
            for(int k = 0; k < 4; k++){
                int nr = r + dirRow[k];
                int nc = c + dirCol[k];
                if(nr >= 0 && nc >= 0 && nr < m && nc < n && board[nr][nc] == 'O') {
                    s.push(new int[]{nr, nc});
                }
            }
        }
    }
}
========================================================================= */