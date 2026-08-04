class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer>  ans = new ArrayList<>();
        HashSet<Integer> store = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int n:nums){
            min = Math.min(min,n);
            max = Math.max(max,n);
            store.add(n);
        }

        for(int i = min+1; i<max; i++){
            if(!store.contains(i)) ans.add(i);
        }
        return ans;
    }
}