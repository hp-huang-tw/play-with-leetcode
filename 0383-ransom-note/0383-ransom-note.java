class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
		// Create an integer array to store character frequencies
        int[] charFreq = new int[26];
        
        // Populate the array with character frequencies from magazine
        for (char ch : magazine.toCharArray()) {
            charFreq[ch - 'a']++;
        }
        
        // Check character frequencies for ransomNote
        for (char ch : ransomNote.toCharArray()) {
            int index = ch - 'a';
            charFreq[index]--;
            
            if (charFreq[index] < 0) return false;
        }
        
        // If all characters are found and frequencies are valid, return true
        return true;
    }
}