class Solution {
    public String longestPalindrome(String s) {
        // //dp soln make all substrings and check
        // int resInd = 0; int resLen = 0;
        // int n = s.length();

        // boolean dp[][] = new boolean[n][n];

        // for(int i = n-1; i>=0; i--){
        //     for(int j = i; j<n; j++){
        //         if(s.charAt(i)==s.charAt(j) && (j-i<3 || dp[i+1][j-1])){
        //             dp[i][j] = true;
        //             if(j-i+1>resLen){
        //                 resLen = j-i+1;
        //                 resInd = i;
        //             }
        //         }
        //     }
        // }

        // return s.substring(resInd, resInd+resLen);

        //2 pointer approach, select centres of palindrome and expand in both dirns
        int n = s.length();
    int start = 0, end = 0; // Track the best boundaries

        for (int i = 0; i < n; i++) {
            // Odd length
            int l = i, r = i;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if (r - l > end - start) {
                    start = l;
                    end = r;
                }
                l--; r++;
            }
            // Even length
            l = i; r = i + 1;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if (r - l > end - start) {
                    start = l;
                    end = r;
                }
                l--; r++;
            }
        }
        return s.substring(start, end + 1);
    }
}