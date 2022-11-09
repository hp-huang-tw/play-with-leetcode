class Solution {
    
    // TC: O(n+q), SC: O(n)
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int strLen = s.length();
        List<Integer> presum = new ArrayList<>();
        int[] closestLeft = new int[strLen], closestRight = new int[strLen];
        
        int sum = 0, index = -1;
        for (int i = 0; i < strLen; i++) {
            if (s.charAt(i) == '*') sum++;
            else {
                presum.add(sum);
                index++;
            }
            closestLeft[i] = index;
        }

        index = presum.size();;
        for (int i = strLen - 1; i >= 0; i--) {
            if (s.charAt(i) == '|') index--;
            closestRight[i] = index;
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0], end = queries[i][1];
            int left = closestRight[start];
            int right = closestLeft[end];
            if (left < right) res[i] = presum.get(right) - presum.get(left);
        }
        return res;
    }
    
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