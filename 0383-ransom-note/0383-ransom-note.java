class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
		int[] charFreq = new int[26];

        for (char ch : magazine.toCharArray()) {
            charFreq[ch - 'a']++;
        }

        for (char ch : ransomNote.toCharArray()) {
            int index = ch - 'a';
            charFreq[index]--;

            if (charFreq[index] < 0) {
                return false;
            }
        }

        return true;
    }
}