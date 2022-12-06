class ProductOfNumbers {
    
    List<Integer> prefixs;
    
    // TC: O(1) for add & get
    // SC: O(n)
    public ProductOfNumbers() {
        initNums();
    }
    
    private void initNums() {
        prefixs = new ArrayList(){{
            add(1);
        }};
    }

    public void add(int num) {
        if (num > 0)
            prefixs.add(prefixs.get(prefixs.size() - 1) * num);
        else {
            initNums();
        }
    }

    public int getProduct(int k) {
        int n = prefixs.size();
        return k < n ? prefixs.get(n - 1) / prefixs.get(n - k - 1)  : 0;
    }
    
    
    // basic solution
    
    // List<Integer> nums;
    // add: O(1)
    // get: O(n) worst case.
    /*
    public ProductOfNumbers() {
        nums = new ArrayList<>();
    }
    
    public void add(int num) {
        nums.add(num);
    }
    
    public int getProduct(int k) {
        int len = nums.size();
        int res = 1;
        while (k > 0) {
            res = res * nums.get(len - k);
            k--;
        }
        
        return res;
    }
    */

}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */