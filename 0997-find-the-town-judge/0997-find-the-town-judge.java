class Solution {
    
    // TC: O(n)
    // SC: O(n)
    public int findJudge(int n, int[][] trust) {
        /*
        trust = [[1,2]], n = 2. i is judge if there's the value of couter = n-1 at index i
        1    2
        -1   1
        
        trust = [[1,3],[2,3]], n = 3.
        1    2      3
        -1   -1     2
        
        trust = [[1,3],[2,3],[3,1]], n = 3. otherwise, no judge.
        1    2      3
        -1   -1     1
        */
        int[] counter = new int[n + 1];
        for (int i = 0; i < trust.length; i++) {
            counter[trust[i][0]]--; // decrement 1 on a if a trusts b
            counter[trust[i][1]]++; // increment 1 on b if a trusts b
        }
        
       for (int i = 1; i < counter.length; i++) {
           if (counter[i] == n - 1) return i;
       }
        
        return -1;
    }
}