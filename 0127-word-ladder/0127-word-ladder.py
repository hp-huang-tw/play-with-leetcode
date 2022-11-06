class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if (endWord not in wordList):
            return 0
    
        adj = collections.defaultdict(list)
        for word in wordList:
            for i in range(len(word)):
                adj[word[:i] + "*" + word[i+1:]].append(word)
                
        visited = set()
        q = collections.deque([(beginWord, 1)])
        while q:
            word, k = q.popleft()
            if word == endWord:
                return k
            if word not in visited:
                visited.add(word)
                for i in range(len(word)):
                    neighbors = word[:i] + "*" + word[i+1:]
                    for neighbor in adj[neighbors]:
                        q.append((neighbor, k+1))
        return 0