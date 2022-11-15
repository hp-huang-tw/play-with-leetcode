class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        return bruteForce(words, k);
    }
    
    private List<String> bruteForce(String[] words, int k) {
        HashMap<String, Integer> wordCountMap = new HashMap<>();
        
        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }
        
        List<String> candicates = new ArrayList<>(wordCountMap.keySet());
        Collections.sort(candicates, 
                         (w1, w2) -> wordCountMap.get(w1).equals(wordCountMap.get(w2)) ?
                         w1.compareTo(w2) : wordCountMap.get(w2) - wordCountMap.get(w1)
                        );
        
        return candicates.subList(0, k);
    }
}