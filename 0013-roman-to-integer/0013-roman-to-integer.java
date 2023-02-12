class Solution {
    
    // XVI -> 16
    //.  ^    1 + 5 + 10      
    // XIV -> 14
    //   ^    5 - 1 + 10
    public int romanToInt(String s) {
        Map<Character, Integer> map = 
            Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);
        
        int sLen = s.length();
        int sum = map.get(s.charAt(sLen - 1));   // 1
        
        for (int i = sLen - 2; i > -1; i--) {
            int curr = map.get(s.charAt(i)); // 5
            if (curr < map.get(s.charAt(i + 1))) {
                sum -= curr;
            } else {
                sum += curr;
            }
        }
        
        return sum;
    }
}