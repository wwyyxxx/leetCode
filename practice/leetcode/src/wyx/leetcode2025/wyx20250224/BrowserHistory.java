/*
 * @Author: Tungbo
 * @Date: 2025-02-26 21:38:32
 * @LastEditTime: 2025-02-26 22:05:23
 * @LastEditors: Tungbo
 * @Description: leecode: 1472. 设计浏览器历史记录
 */
package practice.leetcode.src.wyx.leetcode2025.wyx20250224;

import java.util.ArrayList;
import java.util.List;

public class BrowserHistory {

    private final List<String> history = new ArrayList<>();
    private int cur = 0; // 当前页面是 history[cur]请注明出处。

    public BrowserHistory(String homepage) {
        history.add(homepage);
    }

    public void visit(String url) {
        cur++;
        history.subList(cur, history.size()).clear(); // 把浏览历史前进的记录全部删除
        history.add(url); // 从当前页跳转访问 url 对应的页面
    }

    public String back(int steps) {
        cur = Math.max(cur - steps, 0); // 后退 steps 步
        return history.get(cur);
    }

    public String forward(int steps) {
        cur = Math.min(cur + steps, history.size() - 1); // 前进 steps 步
        return history.get(cur);
    }

}
