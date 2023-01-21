class Solution {
    /*
    "25525511135"
    
    2.      5.      5.      2.      5511135
    2.      5.      5.      25.     511135
    2.      5.      5.      255     11135
    -----
    2.      5.      52.     5.      511135
    2.      5.      52.     55      11135
    2.      5.      52.     551     1135
    -----
    2.      5.      525.    5       11135
    -----
    2.      55.     2.      5       11135
    2.      55.     2.      51      1135
    -----
    2.      55.     2.      511     135
    
    -----
    2.      55.     25.     1       1135
    ------
    2.      55.     25.     11      1135
    .....
    
    25.     5.      2.      5.      511135
    255.    2.      5.      5.      11135
    ....
    255.    255.    11.     135.
    255.    255.    111     35.
    */
    
    String s;
    
    List<String> res = new ArrayList<>();
    
    public List<String> restoreIpAddresses(String s) {
        this.s = s;
        if (s.length() > 12) {
            return res;
        }
        dfs(0, 0, "");
        return res;
    }
    
    private void dfs(int i, int dots, String address) {
        if (dots == 4 && i == s.length()) { //"2<-i    5525511135", "25<-i    525511135"
            res.add(address.substring(0, address.length() -1)); // remove last dot
            return;
        }
        
        for (int j = i + 1; j <= s.length(); j++) { //"2<-i 5<-j   525511135", //"25<-i 5<-j25511135"
            String number = s.substring(i, j);      // 2                           5   
            if (isValidNumber(number)) {
                dfs(j, dots + 1, address + number + '.');
            }
        }
    }
    
    private boolean isValidNumber(String s) {
        if (s.length() > 1 && s.startsWith("0") || s.length() > 3) {   // 01, 1234
            return false;
        }
        return Integer.valueOf(s) >= 0 && Integer.valueOf(s) <= 255;
    }
}