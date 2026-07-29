class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        char[] cs = s.substring(0,n/2).toCharArray();
        Arrays.sort(cs);

        StringBuilder fh = new StringBuilder(new String(cs));
        StringBuilder ans = new StringBuilder(fh);

        //substring method leaves last char so add if odd
        if(n%2==1) ans.append(s.charAt(n/2));
        ans.append(fh.reverse());
        return ans.toString();
    }
}