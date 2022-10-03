class Solution {
    public boolean isPalindrome(String s) {
        return buildin(s);
    }
    
    private boolean buildin(String s) {
        String newStr = "";
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (Character.isLetterOrDigit(c)){
                newStr+=Character.toLowerCase(c);
            };
        }
        
        String reversed = new StringBuilder(newStr).reverse().toString();
        return reversed.equals(newStr);
    }
}