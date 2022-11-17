class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) { 
        if(nums1 == null && nums2 == null){
            return 0;
        }
        
        if(nums1 == null){
            int n = nums2.length;
            return nums2[(n - 1) / 2] * 0.5 + nums2[n / 2] * 0.5;
        }
        
        if(nums2 == null){
            int n = nums1.length;
            return nums1[(n - 1) / 2] * 0.5 + nums1[n / 2] * 0.5;
        }
        
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        
        // choose shorter to binary search
        int n = nums1.length;
        int m = nums2.length;
        int left = 0;
        int right = n;
        
        while(left < right){
            int i = (left + right) / 2;
            int j = (n + m) / 2 - i;
            
            if(nums1[i] < nums2[j - 1]){
                left = i + 1;
            }else{
                right = i;
            }
        }
        
        int first = left;
        int second = (n + m) / 2 - left;
        
        int shorterLeft = first == 0 ? Integer.MIN_VALUE : nums1[first - 1];
        int shorterRight = first == n ? Integer.MAX_VALUE : nums1[first];
        
        int longerLeft = second == 0 ? Integer.MIN_VALUE : nums2[second - 1];
        int longerRight = second == m ? Integer.MAX_VALUE : nums2[second];
        
        if((n + m) % 2 == 1) {
            return Math.min(shorterRight, longerRight);
        }else{
            return Math.max(shorterLeft, longerLeft) * 0.5 + Math.min(shorterRight, longerRight) * 0.5;
        }
    }
    
    /*
    public double findMedianSortedArrays(int[] nums1, int[] nums2) { 
        int len1 = nums1.length, len2 = nums2.length;
        
        // suppose nums1 as shorter array. swap them if not.
        if (len1 > len2) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int mergedMid = (len1 + len2)/2; // 1
        int l = 0, r = len1 - 1;
        int mid = 0, j = 0; // 0, 0
        int nums1Left = 0, nums1Right = 0;
        int nums2Left = 0, nums2Right = 0;
        
        // // choose shorter array to binary search
        while (l < r) {
            mid = (l + r)/2;    // 0+5= 2.5 //0
            j = mergedMid - mid;    // index for b
            
            nums1Left = (mid >= 0) ? nums1[mid] : Integer.MIN_VALUE;
            nums1Right = (mid + 1) < len1 ? nums1[mid + 1] : Integer.MAX_VALUE;
            nums2Left = (j >= 0) ? nums2[j] : Integer.MIN_VALUE;
            nums2Right = (j + 1) < len2 ? nums2[j + 1] : Integer.MAX_VALUE;
            
            if (nums2Left > nums1Right) {
                l++;
            } else {
                r--;
            }
        }
        
        if ((len1 + len2) % 2 == 0) {
            return (double) ((Math.max(nums1Left, nums2Left) 
                             + Math.min(nums1Right, nums2Right)) / 2);
        } else {
            return Math.max(nums1Left, nums2Left);
        }
        
    }
    */
}