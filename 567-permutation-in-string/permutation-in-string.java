class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char os[] = s1.toCharArray();
        Arrays.sort(os);
        int l = s1.length();
        for(int i = 0; i<=s2.length()-l; i++){
            char ns[] = s2.substring(i, i+l).toCharArray();
            Arrays.sort(ns);
            if(Arrays.equals(os, ns)) return true;
        }
        return false;
    }
}