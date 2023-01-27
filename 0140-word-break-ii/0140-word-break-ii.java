class Solution {
    
    /*
    ["cat","cats","and","sand","dog"] maxLen = 4, minLen = 3
    "catsanddog"                "catsanddog"    
     i  j           cat v        i.  j           cats v
        i  j        san x            i  j        and v
        i   j       sand v              i   j    dog v <- repeated
            i   j   dog v   <- repeated
     cat sand dog   i = 0, j = 3 - 4 (minLen - maxLen). and j < len + 1
                    if (wordDict.contains(s.substring(i, j)) move i to j
     cats and dog
     catsa x
     
     dfs
     map(i,substr) Map<Integer, List<String>> map =  7: ["dog"]
     
     ["apple","pen","applepen","pine","pineapple"] maxLen = 9, minLen = 3
    "pineapplepenapple"
    
    pine apple pen apple
    pine applepen apple
    pineapple pen apple
    
     map(i,substr) Map<Integer, List<String>> map =  15: ["apple"], 10: ["pen","apple"]
    
    ["cats","dog","sand","and","cat"]   maxLen = 4, minLen = 3
    "catsandog"
    
    cat sand og x
    cats and og x
    
    -> []
    */
    
    String s;
    
    List<String> wordDict;
    
    List<String> res = new ArrayList<>();
    
    Integer maxLen = Integer.MIN_VALUE;

    Integer minLen = Integer.MAX_VALUE;
        
    public List<String> wordBreak(String s, List<String> wordDict) {
        this.s = s;
        this.wordDict = wordDict;
        
        for (String word : wordDict) {
            maxLen = Math.max(maxLen, word.length());
            minLen = Math.min(minLen, word.length());
        }
        
        helper(0, new ArrayList<>());
        return res;
    }
    
    private void helper(int i, List<String> strs) {
        if (i == s.length()) {
            String permute = String.join(" ", strs);
            res.add(permute);
            return;
        }
        
        for (int j = i + minLen; j < s.length() + 1; j++) {
            String subStr = s.substring(i, j);
            if (wordDict.contains(subStr)) {
                strs.add(subStr);
                helper(j ,strs);    // -> repeated work.
                strs.remove(strs.size() -1);
            }
        }
    }
}