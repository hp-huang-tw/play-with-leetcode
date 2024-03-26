class Solution {
    public boolean backspaceCompare(String s, String t) {
        String s1 = handleString(s);
        String t1 = handleString(t);
        
        return s1.equals(t1);
    }
    
    private String handleString(String s) {
        Deque<Character> deque = new LinkedList<>();
        
        for (char ch : s.toCharArray()) {
            if (ch == '#') {
                deque.pollLast();
            } else {
                deque.offer(ch);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.poll());
        }
        
        return sb.toString();
    }
}