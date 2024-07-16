/*
 * @Author: Tungbo
 * @Date: 2024-07-16 14:51:54
 * @LastEditTime: 2024-07-16 15:38:33
 * @LastEditors: Tungbo
 * @Description: leecode: 208. 实现 Trie (前缀树)
 */
package wyx.leetcode2024.wyx20240715;

public class Trie {

    Trie[] children;
    boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }
    
    public void insert(String word) {
        Trie node = this;
        for(char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new Trie();
            }
            node = node.children[idx];
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        Trie node = searchNode(word);
        return node != null && node.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        Trie node = searchNode(prefix);
        return node != null;
    }

    private Trie searchNode(String str){
        Trie node = this;
        for(char c : str.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                return null;
            }
            node = node.children[idx];
        }
        return node;
    }
}
