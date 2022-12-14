class Solution {
                        //   len1,      len2
    public int strStr(String haystack, String needle) {
        // i: 0-len2-1. if (not macthed@1[curr]) move start = 1(curr) + 1;
        // j: 0-len2-1
        // empty needle appears everywhere, first appears at 0 index
        int len1 = haystack.length(), len2 = needle.length();
        
        if (len2 == 0) { 
            return 0;
        }
        
        if (len1 == 0) {
            return -1;
        }
        
        // sadbutsad    // sadbutsad    // sadbutsad
        // i               i               i
        // sad          // sad             sad
        // j                j                j <---- exactly matched
        int count = 0;
        for (int start = 0; start < len1; start++) { 
            for (int j = 0; j < len2; j++) {   
                if (start + j > len1 - 1) break;
                
                if (needle.charAt(j) != haystack.charAt(start + j)) break;                
                if (j == (len2 -1)) {
                    return start;
                }
                

            }
        }
        
        return -1;
        
        
    }
}