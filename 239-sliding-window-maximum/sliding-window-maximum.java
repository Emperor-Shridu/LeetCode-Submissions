class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dp = new ArrayDeque<>();
        int n = nums.length;
        int res[] = new int[n-k+1];
        int ri = 0;

        for(int i = 0; i<n; i++){
            // remove numbers outside the boundary
            if(!dp.isEmpty() && dp.peekFirst()<i-k+1) dp.pollFirst();
            // remove all numbers smaller than last
            while(!dp.isEmpty() && nums[i]>=nums[dp.peekLast()]) dp.pollLast();
            // add the new last
            dp.offerLast(i);
            // take the first as the max
            // add in res if i>=k-1 at i-k+1
            if(i>=k-1) res[i-k+1] = nums[dp.peekFirst()];
        }
        return res;
    }
}