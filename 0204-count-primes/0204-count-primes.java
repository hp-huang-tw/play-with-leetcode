class Solution {
    
    // Sieve of Eratosthenes
    // n = 25
    //    2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 ,13, 14, 15, 16, 17, 18 .....
    
    // filter from 2x nums 
    //    2. 3     5.    7     9.     11.     13      15      17  .......
    
    // filter from 3x nums
    ///.     3.    5                  11      13              17  ......
    // the remaining nums will be our primes
    
    // TC: O(n^(1/2) loglog(n)). SC: O(n)
    public int countPrimes(int n) {
        if (n <= 2) { 
            return 0;
        }
        
        
        boolean[] isNotPrimes = new boolean[n];
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (isNotPrimes[i] == false) {
                for (int j = i * i; j < n; j += i) {      // 4, 4+2 =6, 6 + 2 =8....
                    isNotPrimes[j] = true;
                }
            }
        }
        
        int count = 0;
        
        for (int i = 2; i < n; i++) {
            if (isNotPrimes[i] == false) {
                count++;
            }
        }
        
        return count;
    }
}