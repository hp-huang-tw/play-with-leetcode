class Solution {
    // Brute Force Solution: 
    // TC: O(n^3). check isPalindrome O(n) * find each substring O(n^2)
    
    // Expand Range Solution:
    // check isPalindrone from the mid. TC: O(n^2)
    //  babad
    // -^-
    //  babad
    //  -^-
    private int maxLen = 0;
    
    private String res = "";
    
    public String longestPalindrome(String s) {        
        // i is the index of curent mid of substring.
        for (int i = 0; i < s.length(); i++) {
            res = longestPalindrome(s, i, i); // odd string
            res = longestPalindrome(s, i, i + 1); // even string, e.g. cbbd
        }
        
        return res;
    }
    
    private String longestPalindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            int strlen = r - l + 1;
            if (maxLen < strlen) {
                res = s.substring(l, r + 1);
                maxLen = strlen;
            }
            l--;
            r++;
        }
        return res;
    }
}