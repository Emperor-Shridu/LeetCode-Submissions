class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int max = 0;
        int l = 0;
        Map<Integer, Integer> m = new HashMap<>();
        for(int r = 0; r < nums.length ; r++){
            m.put(nums[r],m.getOrDefault(nums[r], 0)+1);
            while(m.get(nums[r])>k){
                m.put(nums[l],m.get(nums[l])-1);
                l++;
            }
            max = Math.max(max, r-l+1);
        }
        return max;
    }
}