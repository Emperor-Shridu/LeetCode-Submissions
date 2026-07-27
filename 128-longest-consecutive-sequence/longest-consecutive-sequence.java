class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> s = new HashSet<>();
        for(int num:nums) s.add(num);

        int crt = 0;
        int len = 0;
        int maxLen = 0;

        for(int num:s){
            if(s.contains(num-1)) continue;
            crt = num;
            len = 0;

            while(s.contains(crt)){
                crt++;
                len++;
            }                
            maxLen = Math.max(len, maxLen);

        }
        return maxLen;
    }
}