class Solution {
    
    // strs = ["flower","flow","flight"]
    // res = "fl"
    
    // sort strs by alphabetically
    // -> flight, flow, flower
    //    ^^^^^^        ^^^^
    //    ^^^^^
    //    ^^^^
    //    ^^^
    //    ^^
    
    // O(nLog(n) + O(maxLen))
    public String longestCommonPrefix(String[] strs) {        
        Arrays.sort(strs);

        String last = strs[strs.length - 1];
        
        String prefix = strs[0];
        int maxLen = prefix.length();
        for (int i = maxLen; i > -1 ; i--) {
            if (last.indexOf(prefix) == 0) {
                return prefix;
            }
            prefix = prefix.substring(0, prefix.length() - 1);
        }
        return "";
    }
}