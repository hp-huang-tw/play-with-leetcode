class Solution {
    public boolean isPalindrome(String s) {
        return twoPointer(s);
    }
    
    private boolean twoPointer(String s) {
        int left=0, right=s.length()-1;
        
        while (left < right) {            
            while (left < right && !isAlphanumeric(s.charAt(left))) {
                left++;
            }
            
            while (left < right && !isAlphanumeric(s.charAt(right))) {
                right--;
            }
            
            if (Character.toLowerCase(s.charAt(left)) != 
                Character.toLowerCase(s.charAt(right))) 
                return false;
            
            left++;
            right--;
            
        }
        
        return true;
    }
    
    private boolean isAlphanumeric(Character c) {
        return 'A' <= c && c <= 'Z' 
            || 'a' <= c && c <= 'z'
            || '0' <= c && c <= '9';
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