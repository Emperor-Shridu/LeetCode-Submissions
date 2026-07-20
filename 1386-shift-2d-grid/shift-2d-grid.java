class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        // while(k-->0){
        //     int prev = grid[m-1][n-1];
        //     for(int i = 0; i<m; i++){
        //         for(int j = 0; j<n; j++){
        //             int temp = grid[i][j];
        //             grid[i][j] = prev;
        //             prev = temp;
        //         }
        //     }
        // }

        // List<List<Integer>> ans = new ArrayList<>();
        // for(int i = 0; i<m; i++){
        //     List<Integer> row = new ArrayList<>();
        //     for(int j = 0; j<n; j++) row.add(grid[i][j]);
        //     ans.add(row);
        // }

        // optimal math soln

        int total = m*n;
        k=k%total; //anything greater than total makes it as it is
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i<m; i++){
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j<n; j++){
                //get old 1d index and rotate shift it then convert back to 2d
                int oldIdx = i*n + j; // value stored at this index in 1d
                int newIdx = (oldIdx-k+total) % total; // value to be stored at the index (shifted source back by k times)
                
                row.add(grid[newIdx/n][newIdx%n]);
            }
            ans.add(row);
        }
        return ans;
    }
}