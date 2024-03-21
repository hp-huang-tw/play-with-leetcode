class Solution {
    public boolean isPalindrome(String s) {
        String cleanedString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int l = 0, r = cleanedString.length() - 1;
        while (l < r) {
            if (cleanedString.charAt(l) != cleanedString.charAt(r)) {
                    return false;
            }
            l++;
            r--;
        }

        return true;
    }
}


// a, bcb a
//       l
//       r

// //abcxba
//     lr