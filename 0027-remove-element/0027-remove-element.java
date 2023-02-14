class Solution {
    /*
        [3, 2, 1, 3] val = 3
         l        r
         3. 2. 1  3
         l     r
               r
         1  2. 3. 3
            l
            r
            
        [0,1,2,2,3,0,4,2], val = 2
         l             r
             l
             2 2 3 0 4 2
             l       r
             4 2 3 0 2
             l     r
               l
               0 3 2 2
               l.  r
                 l 
                   l
               r.  l.  return l
    */
    public int removeElement(int[] nums, int val) {
        int l = 0, r = nums.length;
        
        while (l < r) {
           if (nums[l] == val) {
               nums[l] = nums[r - 1];
               r--;
           } else {
               l++;
           }
        }
        return r;
    }
}