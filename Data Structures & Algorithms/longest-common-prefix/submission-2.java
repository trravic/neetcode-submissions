class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
}

class Trie { 
    TrieNode root = new TrieNode();
    void insert(String word){
        TrieNode node = root;
        for(char c : word.toCharArray()){
            node.children.putIfAbsent(c, new TrieNode()); 
            node = node.children.get(c);
        }
    }

    int lcp(String word, int prefLen){
        TrieNode node = root;
        int i = 0; 
        int chckLen = Math.min(prefLen , word.length());

        while(i < chckLen){
            if(!node.children.containsKey(word.charAt(i))){
                return i;
            }
            node = node.children.get(word.charAt(i));
            i++;
        }
        return chckLen;
    }
}


class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1)
            return strs[0]; // edge-case

        int miniIndex = 0;
        for(int i = 1 ; i < strs.length ; i++){
            if(strs[miniIndex].length() > strs[i].length())
                miniIndex = i;
        }

        Trie trie = new Trie();
        trie.insert(strs[miniIndex]);

        int prefLen = strs[miniIndex].length();

        for(int i = 0 ; i < strs.length; i++){
            prefLen = trie.lcp(strs[i], prefLen);
        }
        return strs[0].substring(0, prefLen);
    }
}

/**

Input: strs = ["dance","dag","danger","damage"]

Output: "da"

Observation : 
Just get the minimum string and insert it in Trie.
Run your list of string against trie and get the maximum matched

TrieNode -> <Character, TrieNode>

rootNode -> new TrieNode - created

dag 

rootNode
d, new TrieNode (created) -> point your rootNode
a - not exists -> a, new TrieNode (created) -> point your rootNode
g - not exists -> g, new TrieNode (created) -> point your rootNode 



Now scan your Initial rootNode, and capture the length and return it

have the min number of length matches and store it and return it. 

return the strs[0].substring(0, matchPrefixLen);

*/