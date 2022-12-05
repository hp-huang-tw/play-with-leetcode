class Solution {
    
    // from solution.
    // Time Complexity: O(N)O(N), where NN is the length of A.
    // Space Complexity: O(N)O(N).
    public int subarraysWithKDistinct(int[] nums, int k) {
        Window window1 = new Window();
        Window window2 = new Window();
        
        int res = 0, left1 = 0, left2 = 0;

        for (int right = 0; right < nums.length; ++right) {
            int x = nums[right];
            window1.add(x);
            window2.add(x);

            while (window1.different() > k)
                window1.remove(nums[left1++]);
            while (window2.different() >= k)
                window2.remove(nums[left2++]);

            res += left2 - left1;
        }

        return res;
    }
}

class Window {
    
    Map<Integer, Integer> count;
    
    int nonZero;

    public Window() {
        count = new HashMap();
        nonZero = 0;
    }

    void add(int x) {
        count.put(x, count.getOrDefault(x, 0) + 1);
        if (count.get(x) == 1)
            nonZero++;
    }

    void remove(int x) {
        count.put(x, count.get(x) - 1);
        if (count.get(x) == 0)
            nonZero--;
    }

    int different() {
        return nonZero;
    }
}