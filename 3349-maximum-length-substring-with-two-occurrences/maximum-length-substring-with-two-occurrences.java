class Solution {
    public int maximumLengthSubstring(String s) {
        int maxCount = 0;
        int l = 0;
        int freq[] = new int[26];
        for(int r = 0; r<s.length(); r++){
            char x = s.charAt(r);
            freq[x-'a']++;
            while(freq[x-'a']>2){
                freq[s.charAt(l)-'a']--;
                l++;
            }
            maxCount = Math.max(maxCount, r-l+1);
        }
        return maxCount;
    }
}