/*
 * @Author: Tungbo
 * @Date: 2025-02-24 10:09:47
 * @LastEditTime: 2025-02-24 10:32:14
 * @LastEditors: Tungbo
 * @Description: leecode: 1656. 设计有序流
 */
package practice.leetcode.src.wyx.leetcode2025.wyx20250224;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderedStream {

    int n = 0;
    int prt = 0;
    String[] values;
    int[] ids;

    public OrderedStream(int n) {
        this.n = n;
        values = new String[n];
        ids = new int[n];
        Arrays.fill(values, "");
    }
    
    public List<String> insert(int idKey, String value) {
        List<String> res = new ArrayList<String>();
        if (idKey-1 >= n) {
            return res;
        }
        values[idKey-1] = value;
        ids[idKey-1] = idKey;
        if (idKey-1 == prt) {
            while (prt < n && !"".equals(values[prt])) {
                res.add(values[prt++]);
            }
        }
        return res;
    }

}
