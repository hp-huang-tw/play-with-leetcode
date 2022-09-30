class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = 
            Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);
                   
        int num = map.get(s.charAt(s.length() - 1));
        for (int i = s.length() - 2; i > -1; i--) {
            if (map.get(s.charAt(i)) < map.get(s.charAt(i+1)))  {
                num -= map.get(s.charAt(i));    
            } else {
                num += map.get(s.charAt(i));    
            }
        }
        
        return num;
    }
}