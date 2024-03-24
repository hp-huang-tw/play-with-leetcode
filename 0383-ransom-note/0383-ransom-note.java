class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] magazineWordCount = new int[26];
        
        for (char c : magazine.toCharArray()) {
            magazineWordCount[c - 'a']++;
        }
        
        for (char c : ransomNote.toCharArray()) {
            int pos = c - 'a';
            magazineWordCount[pos]--;
            
            if (magazineWordCount[pos] < 0) return false;
        }
        
        
        return true;
    }
}