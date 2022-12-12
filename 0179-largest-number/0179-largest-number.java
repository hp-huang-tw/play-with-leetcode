class Solution {
    // nums = [3,30,34,5,9]
    // 9 5 
    
    // 3 30 -> 330 / 303 ? -> 330. a + b > b + a  
    // 34 -> 34
    
    // we can sorted it by condition a + b > b + a  
    // 9, 5, 34, 3, 30, 0
    // output -> join string array
    
    // TC: O(nlog(n)). SC: O(n)
    public String largestNumber(int[] nums) {
        String[] numsStr = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);
        
        Arrays.sort(numsStr, new LargerNumberComparator());
        
        // [0, 0, 0] -> 000 -> 0
        // [0, 0, 1] -> 100 -> 0
        
        if (numsStr[0].equals("0")) {
            return "0";
        }
        
        // String res = "";
        // for (String s : numsStr) {
        //     res += s;
        // }
        return String.join("", numsStr);
    }
    
    // https://www.baeldung.com/java-comparator-comparable
    private class LargerNumberComparator implements Comparator<String> {
        
        @Override
        public int compare(String a, String b) {
            String opt1 = a + b;
            String opt2 = b + a;
            return opt2.compareTo(opt1);
        }
    }
}