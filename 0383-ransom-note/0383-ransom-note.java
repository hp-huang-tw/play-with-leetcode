class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] rCount = new int[26];
        int[] mCount = new int[26];
        
        
        for (char c : magazine.toCharArray()) {
            mCount[c - 'a']++;
        }
        
        for (char c : ransomNote.toCharArray()) {
            int pos = c - 'a';
            mCount[pos]--;
            
            if (mCount[pos] < 0) return false;
        }
        
        
        return true;
    }
}