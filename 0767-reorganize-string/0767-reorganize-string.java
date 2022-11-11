class Solution {
    public String reorganizeString(String s) {
        // step 1:
        // build a hashmap to store characters and its frequencies:
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // step 2:
        // put the char of freqMap into the maxheap with sorting the frequencies by large->small
        PriorityQueue<Character> priorityQueue =
                new PriorityQueue<>((a, b) -> freqMap.get(b) - freqMap.get(a));
        // addAll() is adding more then one element to heap
        // maxheap has the most frequent character on the top
        priorityQueue.addAll(freqMap.keySet());

        // step 3:
        // obtain the character 2 by 2 from the maxheap to put in the result sb
        // until there is only one element(character) left in the maxheap
        // create a stringbuilder to build the result result
        StringBuilder stringBuilder = new StringBuilder();
        while (priorityQueue.size() > 1) {
            Character first = priorityQueue.poll();
            Character second = priorityQueue.poll();

            stringBuilder.append(first);
            stringBuilder.append(second);

            freqMap.put(first, freqMap.get(first) - 1);
            freqMap.put(second, freqMap.get(second) - 1);

            if (freqMap.get(first) > 0) {
                priorityQueue.offer(first);
            }

            if (freqMap.get(second) > 0) {
                priorityQueue.offer(second);
            }
        }

        if (!priorityQueue.isEmpty()) {
            // when there is only 1 element left in the maxheap
            // check the count, it should not be greater than 1
            // otherwise it would be impossible and should return ""
            if (freqMap.get(priorityQueue.peek()) > 1) { // e.g. abaa
                return "";
            } else {
                stringBuilder.append(priorityQueue.poll());
            }
        }

        return stringBuilder.toString();
    }
}