class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prefix = 1;
        int suffix = 1;
        int n = nums.length;
        int[] ans = new int[n];

        //first pass multiplies the prefix in plac
        for(int i = 0 ; i<n; i++){
            ans[i] = prefix;
            prefix*=nums[i];
        }
        //second pass multiplies the suffix in place
        for(int i = n-1; i>=0; i--){
            ans[i] = ans[i]*suffix;
            suffix*=nums[i];
        }

        return ans;
    }
}