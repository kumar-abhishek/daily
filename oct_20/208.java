/*
implement Trie (Prefix Tree)

Implement a trie with insert, search, and startsWith methods.

Note:
You may assume that all inputs are consist of lowercase letters a-z.

*/

class TrieNode {
    // Initialize your data structure here.
    Map<Character, TrieNode> children;
    boolean isWord;
    public TrieNode() {
        children = new HashMap<>();
        isWord = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode temp = root;
        for(int i=0;i<word.length();i++) {
            TrieNode t;
            if(!temp.children.containsKey(word.charAt(i))) temp.children.put(word.charAt(i), new TrieNode());
            temp = temp.children.get(word.charAt(i));
        }  
        temp.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode temp = root;
        for(int i=0;i<word.length();i++) {
            TrieNode t;
            if(!temp.children.containsKey(word.charAt(i))) return false;
            temp = temp.children.get(word.charAt(i));
        }
        return temp.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        for(int i=0;i<prefix.length();i++) {
            if(!temp.children.containsKey(prefix.charAt(i))) return false;
            temp = temp.children.get(prefix.charAt(i));    
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
