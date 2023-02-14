class Solution {
    public int lengthOfLastWord(String s) {
        String[] strs = s.split(" ");
        return strs.length > 0 ? strs[strs.length -1].length() : 0;
    }
}