class Solution {
    
    // TC: O(log(n)), SC: O(1)
    // [1,2,3,4,5,6,7,8,9,10], days = 5
    public int shipWithinDays(int[] weights, int days) {
        
        int left = 0, right = 0;
        for (int w: weights) {
            left = Math.max(left, w);    // 10
            right +=w;                  // 55
        }
        
        // O(log(n))
        while (left < right) {
            int mid = (left + right) / 2;   // 32
            int neededDays = 1;
            int weightSum = 0;
            // O(n)
            for (int w: weights) {              // D1                           D2
                if (weightSum + w > mid) {      // [1,2,3,4,5,6,7,8] + 9 > 32   [9, 10]
                    neededDays++;               // 2
                    weightSum = w;              // 32 -> 9
                } else {
                    weightSum += w;
                }
            }
            if (neededDays > days) {   
                left = mid + 1;
            } else {
                right = mid;   // 2 < 5, current, mid to large. search left portion, right 32
            }
        }
        return left;
    }
}