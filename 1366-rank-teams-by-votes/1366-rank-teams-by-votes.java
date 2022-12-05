class Solution {
               
    // order  0  1  2  3 (mark as team)
    // A(0):  5, 0, 0  0
    // B(1):  0, 2, 3  1
    // C(2):  0, 3, 2  2
    // Obviously, ACB is the result we want.
    
    // we define an array, every row denote a candidate, every column denotes a position.
    //  1. we add an extra column to identify which candidate the row is.
    //  2. we record the number of votes in every position for each candidate by using for-loop
    //  3. sort the array. we define a method to compare candidates.
    //  4. after sorting, build string.
    
    // The time complexity: O(n)
    // O(26 + n * c + 26 * log 26 * c + c) = O(n).
    // c is a constant number, and c <= 26.
    public String rankTeams(String[] votes) {
        int teamLen = votes[0].length();            // ABC -> 3
        
        int[][] rank = new int[26][teamLen + 1];
        
        // label team name at last col.         // 0: A, 1: B ... 25: Z
        // vt order  0  1  2  | 3 (mark as team since we're going to sort it.)
        // A(0):     0, 0, 0  | 0
        // B(1):     0, 0, 0  | 1
        // C(2):     0, 0, 0  | 2
        // TC: O(26)
        for (int i = 0; i < 26; i++) {
            rank[i][teamLen] = i;
        }
        
        // ABC          
        // ^              A(0):  1, 0, 0  0
        //. ^             B(1):  0, 1, 0  1
        //.  ^            C(2):  0, 0, 1  2
        // TC: O(n*c)
        for (String vote : votes) {
            for (int i = 0; i < teamLen; i++) {
                rank[vote.charAt(i) - 'A'][i]++;
            }
        }
        
        // sort TC: O(26*log(26))
        Arrays.sort(rank, (a, b) -> {
            for (int i = 0; i < teamLen; i++) {     // ["WXYZ","XYZW"]             order by DESC
                if (a[i] < b[i]) return 1;          // W: 1 0           w[0] < x[0] return 1
                if (a[i] > b[i]) return -1;         // X: 1 1           w[1] > x[1] return -1
            }
            // return a[len] - b[len];  // order by char
            return 0; // already sort by char
        });
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < teamLen; i++) {
            sb.append((char)('A' + rank[i][teamLen]));
        }
        
        return sb.toString();
    }
}