class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = numbers.length;
        for(int i = 0; i<numbers.length; i++){
            map.put(numbers[i], i);
        }

        for(int i = 0; i<n; i++){
            int ind = map.getOrDefault(target-numbers[i], -1);
            if(ind!=-1) return new int[]{i+1,ind+1};
        }    
        return new int[]{0,0};
    }
}