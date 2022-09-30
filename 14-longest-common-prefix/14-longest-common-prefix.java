class Solution {
    public String longestCommonPrefix(String[] strs) {
        String shortest = "", longest = "";
        
        Arrays.sort(strs);
        
        shortest = strs[0];
        longest = strs[strs.length-1];
        
        String prefix = shortest;
        for (int i = shortest.length(); i > -1; i--) {
            if (longest.indexOf(prefix) == 0) {
                return prefix;
            }
            prefix = prefix.substring(0, prefix.length()-1);
        }
        
        return "";
    }
}