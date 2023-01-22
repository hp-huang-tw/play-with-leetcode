class Solution {
    
    /*
    // input: "aabc"
                a            aa     aab(x)     aabc (x)
               / \          /  \       
             a    ab(x)    b   bc(x)     
            / \           /
           b  bc(x)      c
          /
         c 
       output: [["a","a","b","c"], ["aa","b","c"]]
    */
    
    String s;
    
    List<List<String>> res = new ArrayList<>();
    
    
    // TC: O(2^n * n), n = the lenght of s
    // SC: O(n)
    public List<List<String>> partition(String s) {
        this.s = s;
        dfs(0, new ArrayList<>());
        return res;
    }
    
    private void dfs(int i, List<String> validPartitions) {
        int strLen = s.length();
        if (i == strLen) {
            res.add(new ArrayList<>(validPartitions));
            return;
        }
        
        for (int j = i + 1; j <= strLen; j++) {
            String partitions = s.substring(i, j);
            if (isPalindrome(partitions)) {
                validPartitions.add(partitions);
                dfs(j, validPartitions);
                validPartitions.remove(validPartitions.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String str) {
        int l = 0, r = str.length() - 1;
        
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}