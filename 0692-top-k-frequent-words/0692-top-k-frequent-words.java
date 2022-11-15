class Solution {
    Comparator<String> comparator;
    public List<String> topKFrequent(String[] words, int k) {
        return minHeap(words, k);
    }
    
    
    // minHeap
    // TC: O(nlog(k)). O(n) + O(nlog(k)) + O(klog(k))
    // SC: O(n). O(n) + O(k)
    private List<String> minHeap(String[] words, int k) {
        // TC: O(n)
        HashMap<String, Integer> wordCountMap = buidWordCountMap(words, k);
        
        // k elmenets.
        // TC: O(nlog(k)). O(log(k)) for add/remove n times
        PriorityQueue<String> q = new PriorityQueue<>(
            (w1, w2) -> wordCountMap.get(w1).equals(wordCountMap.get(w2)) ?
                         w2.compareTo(w1) : wordCountMap.get(w1) - wordCountMap.get(w2));
        
        for (String word: wordCountMap.keySet()) {
            q.offer(word);
            if (q.size() > k) {
                q.poll();
            }
        }
        
        // TC: O(klog(k))
        List<String> res = new ArrayList<>();
        while (!q.isEmpty()) {
            res.add(q.poll());
        }
        
        Collections.reverse(res);
        return res;
    }
    
    
    // TC: O(nlog(n)). 
    // count the frequncy of each word O(n). sort: O(nlog(n))
    // SC: O(n).
    private List<String> bruteForce(String[] words, int k) {
        HashMap<String, Integer> wordCountMap = buidWordCountMap(words, k);
        
        List<String> candicates = new ArrayList<>(wordCountMap.keySet());
        Collections.sort(candicates,
                         (w1, w2) -> wordCountMap.get(w1).equals(wordCountMap.get(w2)) ?
                         w1.compareTo(w2) : wordCountMap.get(w2) - wordCountMap.get(w1));
        
        return candicates.subList(0, k);
    }
    
    private HashMap<String, Integer> buidWordCountMap(String[] words, int k) {
        HashMap<String, Integer> wordCountMap = new HashMap<>();
        
        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }
        
        return wordCountMap;
    }
}