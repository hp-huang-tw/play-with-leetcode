class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        /// abcde bafbd
        //  01234 5678
        //      4
        // "pwwkew"
        //  012
                
        int res=0;
        Map<Character, Integer> map = new HashMap(); // currenct index of char
        
        int left=0;
        for (int right =0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                left=Math.max(map.get(c), left);
            }
            
            res=Math.max(res, right-left+1);
            map.put(c, right+1); // record char index
            
        }
        
        return res;
    }
}