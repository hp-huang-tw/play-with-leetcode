class Solution {
    
    public int reverse(int x) {
        if (x == 0) return 0;
        
        char[] chars = String.valueOf(x).toCharArray();
        int charsLen = chars.length;
        
        StringBuilder sb = new StringBuilder();        
        boolean isNegative = false;
        
        for (int i = charsLen - 1; i > -1; i--) {
            if (i == charsLen - 1 && chars[i] == '0') {
                continue;
            }
            if (i == 0 && chars[i] == '-') {
                isNegative = true;
                continue;
            }
            sb.append(chars[i]);
        }
        
        long num = Long.valueOf(sb.toString());
        if (num > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) (isNegative ? -1 * num : num);
    }
}