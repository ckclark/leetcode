package leetcode.implement_trie_prefix_tree;

import java.util.ArrayList;
import java.util.List;

class TrieNode {
    char c;
    List<TrieNode> children;
    public TrieNode() {
        children = new ArrayList<TrieNode>();
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            TrieNode found = null;
            for(TrieNode next : cur.children){
                if(next.c == c){
                    found = next;
                    break;
                }
            }
            if(found != null){
                cur = found;
            }else{
                found = new TrieNode();
                found.c = c;
                cur.children.add(found);
            }
            cur = found;
        }
        boolean eos = false;
        for(TrieNode next : cur.children){
            if(next.c == '\0'){
                eos = true;
                break;
            }
        }
        if(!eos){
            TrieNode eosNode = new TrieNode();
            eosNode.c = '\0';
            cur.children.add(eosNode);
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            boolean found = false;
            for(TrieNode next : cur.children){
                if(next.c == c){
                    cur = next;
                    found = true;
                    break;
                }
            }
            if(!found){
                return false;
            }
        }
        for(TrieNode eos : cur.children){
            if(eos.c == '\0'){
                return true;
            }
        }
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(char c : prefix.toCharArray()){
            boolean found = false;
            for(TrieNode next : cur.children){
                if(next.c == c){
                    cur = next;
                    found = true;
                    break;
                }
            }
            if(!found){
                return false;
            }
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
