class Solution {
    
    // greedy
    public int maximumSwap(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        
        // last postiion of digit (0-9)
        int[] lastPosition = new int[10];
        
        for (int i = 0; i < chars.length; i++) {
            lastPosition[chars[i] - '0'] = i;
        }
        
        for (int i = 0; i < chars.length; i++) {
            for (int digit = 9; digit > chars[i] - '0'; digit--) {
                if (lastPosition[digit] > i) {
                    swap(chars, i, lastPosition[digit]);
                    return Integer.parseInt(String.valueOf(chars));
                }
            }
        }
        
        return num;
    }
    
    private void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}