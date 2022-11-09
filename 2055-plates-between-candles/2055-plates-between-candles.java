class Solution {
    
    // TC: O(n+q), SC: O(n)
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int strLen = s.length();
        List<Integer> presum = new ArrayList<>(); // ecah portion [2, 4, 7]
        int[] closestLeft = new int[strLen], closestRight = new int[strLen];
        
        //  *  *  |  *  * |  * * * |
        //  1  2     3  4    5 6 7     // count
        //.       2       4        7  // presum
        // -1 -1  0  0. 0 1  1 1 1 2  // closetLeft
        int count = 0, index = -1;
        for (int i = 0; i < strLen; i++) {
            if (s.charAt(i) == '*') {
                count++;
            } else {
                presum.add(count);
                index++;
            }
            closestLeft[i] = index;
        }

        index = presum.size(); // 3
        //  *  *  |  *  * |  * * * |
        //  0  0  1. 1 1  2 2 2 2         // closetRight
        for (int i = strLen - 1; i > -1; i--) {
            if (s.charAt(i) == '|') index--;
            closestRight[i] = index;
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            
            int left = closestRight[start];
            int right = closestLeft[end];
            if (left < right) res[i] = presum.get(right) - presum.get(left);
        }
        return res;
    }
    
    // timeout
    private int[] preSum(String s, int[][] queries) {
        int strLen = s.length();
        
        // **|**|***|
        // 1223445677
        int count = 0;
        int[] dp = new int[strLen];
        for (int i = 0; i < strLen; i++) {
            if (s.charAt(i) == '|') {
                dp[i] = count;
            } else {
                count++;
            }
        }
        
        int queryLen = queries.length;
        int[] res = new int[queryLen];
        // **|**|***|
        // 1223445677
        //  s.  e
        for (int i = 0; i < queryLen; i++) {
            int start = queries[i][0]; 
            int end = queries[i][1];
            
            while (s.charAt(start) != '|') start++;
            while (s.charAt(end) != '|') end--;
            
            if (start < end) {
                res[i] = dp[end] - dp[start];
            }
        }
        
        return res;
    }
}