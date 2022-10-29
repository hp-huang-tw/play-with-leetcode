class Solution {
    // TC: O(n)
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> countMap = new HashMap<Character, Integer>();
        
        int l = 0;
        int res = 0, maxfreq = 0;
        
        for (int r = 0; r < s.length(); r++) {
            char rc = s.charAt(r);
            countMap.put(rc, countMap.getOrDefault(rc, 0) + 1);
            maxfreq = Math.max(maxfreq, countMap.get(rc));
            
            while ((r - l + 1) - maxfreq /* maxValue in countMap */ > k) {
                char lc = s.charAt(l);
                countMap.put(lc, countMap.get(lc) - 1);
                l++;
            }
            
            res = Math.max(res, r - l + 1);
                
        }
        
        return res;
        
    }
}