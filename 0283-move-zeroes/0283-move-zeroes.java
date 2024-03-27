class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0, j = 1;
        
        while (j < nums.length) {
            if (nums[i] == 0) {
                if (nums[j] != 0) {
                    nums[i] = nums[j];
                    nums[j] = 0;
                    i++;
                    j++;
                } else {
                    j++;
                }
            } else {
                i++;
                j++;
            }
        }
    }
}


/* 
[0,1,0,3,12]

 ^ ^
 1 0 0 3 12
   ^ ^
   
  1 0 0 3 12
    ^   ^
  1 3 0 0 12
      ^    ^
  1 3 12 0 0
         ^   ^
*/