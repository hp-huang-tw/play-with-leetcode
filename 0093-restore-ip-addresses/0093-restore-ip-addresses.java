class Solution {
        
    List<String> res = new ArrayList<>();
    
    String s;
        
    // "25525511135"
    // ["255.255.11.135","255.255.111.35"]
    public List<String> restoreIpAddresses(String s) {
        this.s = s;
        
        // ddd * 4 = 12
        if (s.length() > 12) {
            return res;
        }
        
        dfs(0, 0, "");
        
        return res;
    }
    

    private void dfs(int i, int dots, String path) {
        if (dots >= 4) {
            if (i == s.length()) {
                res.add(path.substring(0, path.length() - 1));  // remove last .
            }
            return;
        }
        
        for (int j = i + 1; j <= s.length(); j++) {
            String numStr = s.substring(i, j);
            if (isValid(numStr)) {
                dfs(j, dots + 1, path + numStr + '.');
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