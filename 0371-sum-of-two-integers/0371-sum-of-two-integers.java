class Solution {
    public int getSum(int a, int b) {
        
        while (b != 0) {
            int tmp = (a & b) << 1;
            a = a ^ b;
            b = tmp;
        }
        return a;
    }
    
    // 01         01
    // 10         11 
    // 11 -> 3   100 -> 5
}