class Solution {
    
    // TC: O(len(strs)*avg(str)*26) -> O(m*n)
    // SC: O(len(strs)) -> O(m)
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        
        for (String s: strs) {
            int[] freq = new int[26];
            
            for (int i=0; i < s.length(); i++) {
                freq[s.charAt(i) - 'a']++;
            }
            
            String key = Arrays.toString(freq);
            List<String> stringList = map.getOrDefault(key, new ArrayList<String>());
            stringList.add(s);
            map.put(key, stringList);
        }
        
        return new ArrayList<List<String>>(map.values());
    }
}