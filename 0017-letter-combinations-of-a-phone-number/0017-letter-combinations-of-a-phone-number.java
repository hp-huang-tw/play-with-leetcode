class Solution {
    
    private List<String> combs = new ArrayList<>();
    
    private Map<Character, String> letterMaps = 
        Map.of('2', "abc", '3', "def", '4', "ghi",
               '5', "jkl", '6', "mno", '7', "pqrs",
               '8', "tuv", '9', "wxyz");
    
    private String digits;
    
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return combs;
        }
        
        this.digits = digits;
        backtrack(0, new StringBuilder());
        return combs;
    }
    
    // 2: abc, 3: def
    // digits = "23"
    // ["ad","ae","af","bd","be","bf","cd","ce","cf"]

    //             ""
    //    a         b          c
    //.ad ae af     ..  ...   .....
    private void backtrack(int index, StringBuilder sb) {
        if (sb.length() == digits.length()) {
            combs.add(sb.toString());
            return;
        }
        
        String possibleLetters = letterMaps.get(digits.charAt(index));
        for (Character c : possibleLetters.toCharArray()) {
            sb.append(c);
            backtrack(index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}