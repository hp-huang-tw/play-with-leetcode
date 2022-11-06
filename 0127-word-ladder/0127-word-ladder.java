class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        
        HashMap<String, List<String>> comboWordsMap = new HashMap<String, List<String>>();
        wordList.add(beginWord); // hit -> *it, h*t, hi*
        for (String word : wordList) {
            for (int j = 0; j < word.length(); j++) {
                // hot => *ot, h*t, ho*
                String pattern = word.substring(0, j) + '*' + word.substring(j + 1);
                
//                 List<String> transformations = comboWordsMap.getOrDefault(pattern, new ArrayList<String>());
//                 transformations.add(word);
//                 comboWordsMap.put(pattern, transformations);
                comboWordsMap.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);

            }
        }
        
        // bfs
        /*
        Set<String> visited = new HashSet<String>();
        visited.add(beginWord);
        Queue<String> q = new LinkedList<String>();
        q.add(beginWord);
        int res = 1;
        
        // m^2 * n 
        // m: the lenght of each word, n: total number of words
        /*
        while (!q.isEmpty()) {
            
            for (int i = 0; i < q.size(); i++) {
                String currWord = q.poll(); // hit
                
                if (currWord.equals(endWord)) {
                    return res;
                }
                
                for (int j = 0; j < currWord.length(); j++) {
                    // hit -> *it, h*t, hi*
                    String pattern = currWord.substring(0, j) + '*' + currWord.substring(j + 1);
                    
                    for (String comboWord : comboWordsMap.get(pattern)) { // hot
                        if (!visited.contains(comboWord)) {
                            visited.add(comboWord);
                            q.add(comboWord);
                        }
                    }
                }
            }
            res++;
        } */
        
        Set<String> visited = new HashSet<String>();
        Queue<Pair<String, Integer>> q = new LinkedList<Pair<String, Integer>>();
        q.add(new Pair(beginWord, 1));
        int res = 1;
        while (!q.isEmpty()) {
            
            for (int i = 0; i < q.size(); i++) {
                Pair<String, Integer> curr = q.poll(); // hit
                String currWord = curr.getKey();
                int level = curr.getValue();
                
                if (currWord.equals(endWord)) {
                    return level;
                }
                
                if (!visited.contains(currWord)) {
                    visited.add(currWord);
                    
                    for (int j = 0; j < currWord.length(); j++) {
                        // hit -> *it, h*t, hi*
                        String pattern = currWord.substring(0, j) + '*' + currWord.substring(j + 1);
                        for (String comboWord : comboWordsMap.get(pattern)) { // hot   
                                q.add(new Pair(comboWord, level+1));
                        }
                    }
                }
            }
        }
        
        return 0;
    }
}