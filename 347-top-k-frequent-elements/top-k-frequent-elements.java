class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> m = new HashMap<>();
        int n = nums.length;
        for(int i = 0; i<n; i++){
            m.put(nums[i], m.getOrDefault(nums[i], 0)+1);
        }
        List<int[]> ans = new ArrayList<>();//store in value key pair to sort according to frequencies

        for(Map.Entry<Integer,Integer> entry:m.entrySet()){
            ans.add(new int[]{entry.getValue(), entry.getKey()});
        }

        ans.sort((a,b)->b[0]-a[0]);
        int[] answer = new int[k];
        for(int i = 0; i<k; i++){
            answer[i] = ans.get(i)[1];
        }

        return answer;
    }
}