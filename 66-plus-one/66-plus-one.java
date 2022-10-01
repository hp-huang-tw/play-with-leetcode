class Solution {
    public int[] plusOne(int[] digits) {
        int digitsLength = digits.length;
        int carry = 1;
        for (int i = digitsLength -1; i > -1; i--) {
            digits[i]+=carry; // 9+1 -> 10, 8+1 -> 10
            if (digits[i] < 10) {
                return digits;
            }
            digits[i] = 0;
        }
        
        int[] res = new int[digitsLength+1];
        res[0] = 1;
        return res;
    }
}