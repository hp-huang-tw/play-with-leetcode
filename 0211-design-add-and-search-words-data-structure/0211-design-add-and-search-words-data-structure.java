class TrieNode {
    public TrieNode[] children;
    public boolean isEnd;
    
    public TrieNode() {
        children = new TrieNode[26];
        isEnd = false;
    }
}


class WordDictionary {
    private WordDictionary[] children;
    boolean isEndOfWord;
    // Initialize your data structure here. 
    public WordDictionary() {
        children = new WordDictionary[26];
        isEndOfWord = false;
    }
    
    // Adds a word into the data structure. 
    public void addWord(String word) {
        WordDictionary curr = this;
        for(char c: word.toCharArray()){
            if(curr.children[c - 'a'] == null)
                curr.children[c - 'a'] = new WordDictionary();
            curr = curr.children[c - 'a'];
        }
        curr.isEndOfWord = true;
    }
    
    // Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. 
    public boolean search(String word) {
        WordDictionary curr = this;
        for(int i = 0; i < word.length(); ++i){
            char c = word.charAt(i);
            if(c == '.'){
                for(WordDictionary ch: curr.children)
                    if(ch != null && ch.search(word.substring(i+1))) return true;
                return false;
            }
            if(curr.children[c - 'a'] == null) return false;
            curr = curr.children[c - 'a'];
        }
        return curr != null && curr.isEndOfWord;
    }
}

class WordDictionary1 {
    
    TrieNode root;
    
    public WordDictionary1() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode cur = root;
        
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        
        cur.isEnd = true;
    }
    
    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }
    
    private boolean searchHelper(String word, int j, TrieNode cur) {  
        
        for (int i = j; i < word.length(); i++) {
            char c = word.charAt(i);
            
            if (c == '.') {
                TrieNode[] children = cur.children;
                //if (children.length == 0) return false;
                for (TrieNode child: cur.children) {
                    if (child == null) {
                        continue;
                    }
                    if (searchHelper(word, i + 1, child)) {
                        return true;
                    } else {
                        return false;
                    }
                }
            } else {
                if (cur.children[c - 'a'] == null) {
                    return false;
                }
                cur = cur.children[c - 'a'];
            }
        }
        
        return cur.isEnd;
    }
    
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */