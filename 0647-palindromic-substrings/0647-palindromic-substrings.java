class Solution {
    // Brute fore
    // TC: O(n^3). O(n^2) for finding substrings * O(n) for checking is palindromic
    // Expand by mid
    // TC: O(n^2)
    public int countSubstrings(String s) {
        //  aaabc
        // -^-
        // -^^-
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += countSubstrings(s, i, i);
            count += countSubstrings(s, i, i + 1); 
        }
        
        return count;
    }
    
    private int countSubstrings(String s, int l, int r) {
        int count = 0;
        while (l > -1 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            count++;
            l--;
            r++;
        }
        return count;
    }
}