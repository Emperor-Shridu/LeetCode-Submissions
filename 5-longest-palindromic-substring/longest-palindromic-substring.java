class Solution {
    public String longestPalindrome(String s) {
        //dp soln make all substrings and check
        int resInd = 0; int resLen = 0;
        int n = s.length();

        boolean dp[][] = new boolean[n][n];

        for(int i = n-1; i>=0; i--){
            for(int j = i; j<n; j++){
                if(s.charAt(i)==s.charAt(j) && (j-i<3 || dp[i+1][j-1])){
                    dp[i][j] = true;
                    if(j-i+1>resLen){
                        resLen = j-i+1;
                        resInd = i;
                    }
                }
            }
        }

        return s.substring(resInd, resInd+resLen);
    }
}