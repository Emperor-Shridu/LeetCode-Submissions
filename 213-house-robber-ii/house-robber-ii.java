class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        //break in 2 linear problems. rob house 1 or leave house 1. rob->leave last, leave->may rob last using Arrays.copyOfRange()
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0], nums[1]);
        
        int ar1 = linearRob(Arrays.copyOfRange(nums,0, n-1));
        int ar2 = linearRob(Arrays.copyOfRange(nums, 1, n));
        return Math.max(ar1, ar2);
    }
    int linearRob(int[] nums){
        int n = nums.length;
        int dp[] = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i=2; i<n; i++){
            dp[i] = Math.max(dp[i-1], nums[i]+dp[i-2]);
        }
        return dp[n-1];
    }
}