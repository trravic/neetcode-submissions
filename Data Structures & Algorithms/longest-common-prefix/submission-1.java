class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
}

class Trie {
    TrieNode root = new TrieNode();

    void insert(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()){
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
    }

    int lcp(String word, int prefixLen){
        TrieNode node = root;
        int i = 0;
        int checkLen = Math.min(prefixLen, word.length());

        while(i < checkLen) { 
            if(!node.children.containsKey(word.charAt(i))){
                return i;
            }
            node = node.children.get(word.charAt(i));
            i++;
        }
        return checkLen;
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1)
            return strs[0];
        
        int miniIndex = 0;
        for(int i = 1; i < strs.length; i++){
            if(strs[miniIndex].length() > strs[i].length()){
                miniIndex = i;
            }
        }

        Trie trie = new Trie();
        trie.insert(strs[miniIndex]);

        int prefixLen = strs[miniIndex].length();

        for(int i = 0 ; i < strs.length; i++){
            prefixLen = trie.lcp(strs[i], prefixLen);
        }
        return strs[0].substring(0, prefixLen);
    }
}