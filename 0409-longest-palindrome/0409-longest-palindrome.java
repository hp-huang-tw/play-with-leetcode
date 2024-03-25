class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> charFreq = new HashMap<>();

        for (char ch : s.toCharArray()) {
            charFreq.put(ch, 1 + charFreq.getOrDefault(ch, 0));
        }

        int len = 0;
        boolean foundOdd = false;

        for (int freq : charFreq.values()) {
            if (freq % 2 == 0) {
                len += freq;
            } else {
                len += freq - 1;
                foundOdd = true;
            }
        }

        if (foundOdd) {
            len++;
        }

        return len;
    }
}


// multiple odds
// a b [cccc] [dd]  -> [a|b]
// 0+0+ 4    + 2  + 1  = 7 

// [aa]a [bb]b [cccc]c d -> [a|b|c|d]
// 2 + 2 + 4 + 1 = 9 
