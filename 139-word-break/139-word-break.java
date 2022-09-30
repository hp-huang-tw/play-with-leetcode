class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return topDown(s, wordDict);
    }
    
    private boolean topDown(String s, List<String> wordDict) {
        // s = "leetcode", wordDict = ["leet","code"]
        //     TFFFTFFFT  
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    // if () {
                        dp[i] = true;
                        break;
                    // }
                }
            }
        }
        
        return dp[dp.length-1];
    }
}