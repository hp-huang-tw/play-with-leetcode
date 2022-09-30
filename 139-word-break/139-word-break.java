class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return bottomUp(s, wordDict);
    }
    
    private boolean topDown(String s, List<String> wordDict) {
        // s = "leetcode", wordDict = ["leet","code"]
        // dp  TFFFTFFFT  
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j]) {
                    if (wordDict.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        
        return dp[dp.length-1];
    }
    
    private boolean bottomUp(String s, List<String> wordDict) {
        // s = "leetcode", wordDict = ["leet","code"]
        // dp          T
        // i =        7
        
        int strLength = s.length();
        boolean[] dp = new boolean[strLength + 1];
        dp[strLength] = true;
        
        for (int i = strLength-1; i > -1;  i--) {
            for (String word : wordDict) {
                int wordLength = word.length();
                if (i+wordLength <= strLength && s.substring(i, i+wordLength).equals(word)) {
                    dp[i] = dp[i+wordLength];
                }
                if (dp[i]) break;
            }
        }
        
        return dp[0];
    }
}