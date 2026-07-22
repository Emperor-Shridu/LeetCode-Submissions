class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> m = new HashMap<>();
        for(String st:strs){
            int count[] = new int[26];
            for(char c:st.toCharArray()){
                count[c-'a']++;
            }
            String key = Arrays.toString(count);
            m.putIfAbsent(key, new ArrayList<>());
            m.get(key).add(st);
        }
        return new ArrayList<>(m.values());
    }
}