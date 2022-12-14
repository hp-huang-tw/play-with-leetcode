class Solution {
        
    List<String> res = new ArrayList<>();
    
    String s;
        
    // "25525511135"
    // ["255.255.11.135","255.255.111.35"]
    // TC: O(2^12)
    public List<String> restoreIpAddresses(String s) {
        this.s = s;
        
        // ddd * 4 = 12
        if (s.length() > 12) {
            return res;
        }
        
        dfs(0, 0, "");
        
        return res;
    }
    
    //      "25525511135"         "25525511135"      "25525511135"           "25525511135"  
    // i.    ^                      ^                   ^                        ^
    // j      ^                      ^                   ^                        ^
    // s     2                      5                   5                     2
    // path. 2.                     2.5                 2.5.5                 2.5.5.2.
    // dots  1                      2                   3                     4
    private void dfs(int i, int dots, String path) {
        if (dots >= 4) {
            if (i == s.length()) {
                res.add(path.substring(0, path.length() - 1));  // remove last .
            }
            return;
        }
        
        for (int j = i + 1; j <= s.length(); j++) {
            String numStr = s.substring(i, j);  // 2
            if (isValid(numStr)) {
                String nextPath = path + numStr + '.';
                dfs(j, dots + 1, nextPath);  
           }
        }
    }
    
    private boolean isValid(String str) {
        if (str.startsWith("0") && !str.equals("0")) {
            return false;
        }
        return str.length() < 4 && 0 <= Integer.valueOf(str) && Integer.valueOf(str) < 256;
    }
}