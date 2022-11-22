class Solution {
    
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || p == null) {
            throw new IllegalArgumentException("Input string is null");
        }

        List<Integer> result = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();
        if (sLen * pLen == 0 || sLen < pLen) {
            return result;
        }
        
        // res = [0, 
        // toBeMatched = 3, | a: 1, b: 1, c: 1 |
        //               2,                  0
        //               1             0
        //               0       0
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }

        int toBeMatched = map.size();
        int start = 0;
        int end = 0;

        while (end < sLen) {
            char endChar = s.charAt(end);
            if (map.containsKey(endChar)) {
                int count = map.get(endChar);
                if (count == 1) {
                    toBeMatched--;
                }
                map.put(endChar, count - 1);
            }
            end++;

            if (end - start > pLen) {
                char startChar = s.charAt(start);
                if (map.containsKey(startChar)) {
                    int count = map.get(startChar);
                    if (count == 0) {
                        toBeMatched++;
                    }
                    map.put(startChar, count + 1);
                }
                start++;
            }

            if (toBeMatched == 0) {
                result.add(start);
            }
        }

        return result;
    }
}