class Solution {
    // directions for dfs
    int[] dirRow = {0,0,1,-1};
    int[] dirCol = {1,-1,0,0};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        //dfs from top row and bottom row similarly left and right sides for both ocean reachability then take union for ans.
        //dimensions
        int m = heights.length;
        int n = heights[0].length;

        boolean visPacific[][] = new boolean[m][n];
        boolean visAtlantic[][] = new boolean[m][n];

        // dfs left and right
        for(int i = 0; i<m; i++){
            dfs(i,0,visPacific,heights);
            dfs(i,n-1,visAtlantic,heights);
        }

        // dfs top and bottom
        for(int j = 0; j<n; j++){
            dfs(0,j,visPacific,heights);
            dfs(m-1,j,visAtlantic,heights);
        }

        // check both simultaneously and get intersection
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i<m; i++){
            for(int j = 0 ; j<n; j++){
                if(visPacific[i][j]==true&&visAtlantic[i][j]==true) ans.add(Arrays.asList(i,j));
            }
        }
        return ans;
    }

    void dfs(int r, int c, boolean vis[][], int heights[][]){
        //init stack and push source
        //while stack not empty
        //  pop 
        //  if visited continue
        //  else 
        //      mark visited
        //      add neighbors if not visited and mark 
        Stack<int[]> s = new Stack<>();
        s.push(new int[]{r,c});

        while(!s.isEmpty()){
            int[] crt = s.pop();
            int cr = crt[0];int cc = crt[1];

            //continue if visited
            if(vis[cr][cc]==true) continue;

            //mark visited before processing
            vis[cr][cc]=true;
            for(int k = 0; k<4; k++){
                int nr = cr+dirRow[k];
                int nc = cc+dirCol[k];

                if(nr>=0&&nc>=0&&nr<vis.length&&nc<vis[0].length&&heights[nr][nc]>=heights[cr][cc]) s.push(new int[]{nr,nc});
            }
        }
    }
}