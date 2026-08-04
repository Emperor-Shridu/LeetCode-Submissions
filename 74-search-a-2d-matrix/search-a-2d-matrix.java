class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;

        int l = 0, h = m*n-1;
        while(l<=h){
            int mid = l+(h-l)/2;
            int r = mid/n;
            int c = mid%n;
            if(target>matrix[r][c]) l = mid+1;
            else if(target<matrix[r][c]) h = mid-1;
            else return true;
        }
        return false;
    }
}