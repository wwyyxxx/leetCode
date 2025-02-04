/*
 * @Author: Tungbo
 * @Date: 2022-08-16 21:02:58
 * @LastEditTime: 2022-08-16 21:17:43
 * @LastEditors: Tungbo
 * @Description: leecode: 1656. 设计有序流
 * 
 * 有 n 个 (id, value) 对，其中 id 是 1 到 n 之间的一个整数，value 是一个字符串。不存在 id 相同的两个 (id, value) 对
 * 设计一个流，以 任意 顺序获取 n 个 (id, value) 对，并在多次调用时 按 id 递增的顺序 返回一些值
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220815;

import java.util.ArrayList;
import java.util.List;

public class OrderedStream {

    String[] stream;
    int ptr;
    List<String> ans;

    //造一个能接收 n 个值的流，并将当前指针 ptr 设为 1
    public OrderedStream(int n) {
        stream = new String[n + 1];
        ptr = 1;
        ans = new ArrayList<String>();
    }

    //向流中存储新的 (id, value) 对。存储后
    //如果流存储有 id = ptr 的 (id, value) 对，则找出从 id = ptr 开始的 最长 id 连续递增序列 ，并按顺序返回与这些 id 关联的值的列表。然后，将 ptr 更新为最后那个  id + 1
    //否则，返回一个空列表
    public List<String> insert(int idKey, String value) {
        ans.clear();
        stream[idKey] = value;
        while (ptr < stream.length && stream[ptr] != null) {
            ans.add(stream[ptr]);
            ptr++;
        }
        return ans;
    }

}
