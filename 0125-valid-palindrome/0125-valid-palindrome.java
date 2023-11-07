class Solution {
    
    // O(n), O(n)
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        StringBuilder sb = new StringBuilder(s);
        String reversed = sb.reverse().toString();
        
        return s.equals(reversed);
    }
}