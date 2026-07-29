class Solution {
    public String smallestPalindrome(String s) {
        // int n = s.length();
        // char[] cs = s.substring(0,n/2).toCharArray();
        // Arrays.sort(cs);

        // StringBuilder fh = new StringBuilder(new String(cs));
        // StringBuilder ans = new StringBuilder(fh);

        // //substring method leaves last char so add if odd
        // if(n%2==1) ans.append(s.charAt(n/2));
        // ans.append(fh.reverse());
        // return ans.toString();

        //better soln is counting sort with only N time complexity
        int n = s.length();
        int freq[] = new int[26];
        for(char c:s.toCharArray()) freq[c-'a']++;

        char mid=0;
        StringBuilder ans = new StringBuilder();
        
        for(int i = 0 ; i<26; i++){
            if(freq[i]%2!=0) mid = (char)('a'+i);
            for(int j = 0; j<freq[i]/2; j++) ans.append((char)('a'+i));
            // ans.append((char)('a'+i)*freq[i]/2);
        }
        
        StringBuilder res = new StringBuilder(ans);
        if (mid!=0) res.append(mid);
        res.append(ans.reverse());
        return res.toString();
    }
}