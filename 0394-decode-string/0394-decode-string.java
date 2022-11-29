class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ']') {
                stack.add(c);
            } else {
                StringBuilder sb = new StringBuilder();
                while (stack.peek() != '[') {
                    sb.insert(0, stack.pop());
                }

                stack.pop();

               StringBuilder count = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    Character digit = stack.pop();
                    count.insert(0, digit); // 10[a]
                }

                for (int j = 0; j < Integer.parseInt(count.toString()); j++) {
                    sb.chars().forEach(ch -> stack.push((char) ch));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}