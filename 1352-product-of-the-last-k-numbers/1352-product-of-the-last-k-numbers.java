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
    
    // add
    // input                prefixs     handle zero input issue
    // [3]                  1,3         
    // [3,0]                1,3,0       -> 1
    // [3,0,2]              1,3,0,0     -> 1,2
    // [3,0,2,5]                           1,2,10
    // [3,0,2,5,4]                         1,2,10,40
    // [3,0,2,5,4,8]                       1,2,10,40,320
    public void add(int num) {
        if (num > 0)
            prefixs.add(prefixs.get(prefixs.size() - 1) * num);
        else {
            initNums();
        }
    }

    // [3,0,2,5,4],                         1,2,10,40           (n=4)
    //                                      k=2 , 40/2 = 20
    //                                      k=3 , 40/1 = 40
    //    ^                                 k=4 , 40/1 = 40
    
    // [3,0,2,5,4,8]                        1,2,10,40,320
    //                                      k=2 , 320/10 = 32
    
    // [3,0,2,5,4,8]                        1,2,10,40,320 (n=5)
    //    ^                                 k=5 , 320/1 = 32
    public int getProduct(int k) {
        int n = prefixs.size();
        return (k >= n) ? 0 : prefixs.get(n - 1) / prefixs.get(n - k - 1);
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