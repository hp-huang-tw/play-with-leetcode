class Solution {
    
    String s;
    
    int strLen;
    
    List<List<String>> res = new ArrayList<>();
    
    // backtracking -> dfs -> recursive
    /*
                    aab
                 /   |    \
                a.   aa     abb x
              /      |          
            a        b
           /       
         b
    */
   
    public List<List<String>> partition(String s) {    
        dfs(s, 0, new ArrayList<>());  
        return res;
    }
    
     // TC: O(2^n) * O(n). SC: o(n)
    private void dfs(String s, int start, List<String> vaildPartitions) {
        int strLen = s.length();
        if (start >= strLen) {
            res.add(new ArrayList<>(vaildPartitions));   // deep copy
            return;
        }
        
        for (int j = start; j < strLen; j++) {                          //      a -> aa -> aab
            String partition = s.substring(start, j + 1);               //     /      |
            if (isPalindrone(partition)) {                              //.   |       |
                vaildPartitions.add(partition);                         //    |       |
                dfs(s, j + 1, vaildPartitions);                         //    a       b           
                vaildPartitions.remove(vaildPartitions.size() - 1);     //.   b
            }
        }
    }
    
    private boolean isPalindrone(String p) {
        int l = 0, r = p.length() - 1;
        
        while (l < r) {
            if (p.charAt(l) != p.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        
        return true;
    }
}