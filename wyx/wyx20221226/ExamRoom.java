/*
 * @Author: Tungbo
 * @Date: 2022-12-30 18:59:51
 * @LastEditTime: 2022-12-30 19:02:40
 * @LastEditors: Tungbo
 * @Description: leecode: 855. 考场就座
 */
package wyx.wyx20221226;

import java.util.TreeSet;

public class ExamRoom {

    TreeSet<Integer> set;
    int n;

    public ExamRoom(int n) {
        this.n = n;
        set = new TreeSet<>(); 
    }
    
    public int seat() {
        if (set.size() == 0) {set.add(0); return 0;} //没有人时，一定返回0
        int pre = set.first(), ans = set.first(), idx = 0; //初始话为选择最左的长度
        for (int x : set) {
            if (ans < (x - pre) / 2) {
                ans = (x - pre) / 2;
                idx = (x + pre) / 2;
            }
            pre = x;
        }
        //最右进行判断
        int d = n - 1 - set.last();
        if (ans < d) {ans = d; idx = n - 1;}
        set.add(idx);
        return idx;
    }
    
    public void leave(int p) {
        set.remove(p);
    }
}
