class Solution {
    public int maxProduct(int[] nums) {
        int l = 0, s = 0;
        for(int n:nums){
            if(n>=l){
                s = l;
                l = n;
            }
            if(n>s&&n<l){
                s = n;
            }
        }
        return (l-1)*(s-1);
    }
}