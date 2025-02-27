package practice.leetcode.src.wyx.leetcode2025.wyx20250224;

/*
 * @Author: Tungbo
 * @Date: 2025-02-27 21:38:32
 * @LastEditTime: 2025-02-27 22:05:23
 * @LastEditors: Tungbo
 * @Description: leecode: 2296. 设计一个文本编辑器
 */
public class TextEditor {

    private final StringBuilder left = new StringBuilder(); // 光标左侧字符
    private final StringBuilder right = new StringBuilder(); // 光标右侧字符

    public TextEditor() {
        
    }
    
    public void addText(String text) {
        left.append(text);
    }
    
    public int deleteText(int k) {
        k = Math.min(k, left.length());
        left.setLength(left.length() - k);
        return k;
    }
    
    public String cursorLeft(int k) {
        while (k > 0 && left.length() > 0 ) {
            right.append(left.charAt(left.length() - 1));
            left.setLength(left.length() - 1);
            k--;
        }
        return text();
    }
    
    public String cursorRight(int k) {
        while (k > 0 && right.length() > 0 ) {
            left.append(right.charAt(right.length() - 1));
            right.setLength(right.length() - 1);
            k--;
        }
        return text();
    }

    private String text() {
        return left.substring(Math.max(left.length() - 10, 0));
    }

}
