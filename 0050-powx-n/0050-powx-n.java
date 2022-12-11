class Solution {
    public double myPow(double x, int n) {
        long N = n;
        
        if (n < 0) {
            x = 1/x;
            n = -n;
        }
        
       return fastPow(x, n);
    }
    
    // x^n -> (x^2)^(n/2)
    // n = even. x^5 = (x^2) * (x^2) * x
    // n = odd. x^4 =(x^2) * (x^2)
    // TC: O(log(n)), SC: O(1)
    public double fastPow(double x, int n) {
        if (n == 0) return 1;
        
        double half = fastPow(x, n/2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
    
    // TC: O(n), SC: O(1)
    public double bruteForce(double x, int n) {
        double res = 1;  
        for (int i = 0; i < n; i++) {       // n = 0, skip loop return 1
            res = res * x;
        }
        return res;
    }
}