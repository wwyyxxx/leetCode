/*
 * @Author: Tungbo
 * @Date: 2023-03-24 23:23:27
 * @LastEditTime: 2023-03-24 23:28:17
 * @LastEditors: Tungbo
 * @Description: leecode: 1032. 字符流
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20230320;

public class StreamChecker {

    private StringBuilder sb = new StringBuilder();
    private Trie trie = new Trie();

    public StreamChecker(String[] words) {
        for (String w : words) {
            trie.insert(w);
        }
    }
    
    public boolean query(char letter) {
        sb.append(letter);
        return trie.query(sb);
    }
}
class Trie {
    Trie[] children = new Trie[26];
    boolean isEnd = false;

    public void insert(String w) {
        Trie node = this;
        for (int i = w.length() - 1; i >= 0; --i) {
            int idx = w.charAt(i) - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new Trie();
            }
            node = node.children[idx];
        }
        node.isEnd = true;
    }

    public boolean query(StringBuilder s) {
        Trie node = this;
        for (int i = s.length() - 1, j = 0; i >= 0 && j < 201; --i, ++j) {
            int idx = s.charAt(i) - 'a';
            if (node.children[idx] == null) {
                return false;
            }
            node = node.children[idx];
            if (node.isEnd) {
                return true;
            }
        }
        return false;
    }
}
