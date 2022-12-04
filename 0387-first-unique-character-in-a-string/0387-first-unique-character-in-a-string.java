class Solution {
    
    
     HashMap<Character, Integer> freqMap = new HashMap<>();
    
    // TC: O(n)
    // SC: O(26) -> O(1)
    public int firstUniqChar(String s) {
       
        int strLen =  s.length();
        for (int i = 0; i < strLen; i++) {
            char c = s.charAt(i);
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        
        for (int i = 0; i < strLen; i++) {
            char c = s.charAt(i);
            if (freqMap.get(c) == 1) return i;
        }
        
        return -1;
    }
}