/*
 * @Author: Tungbo
 * @Date: 2023-03-03 11:50:23
 * @LastEditTime: 2023-03-03 11:50:27
 * @LastEditors: Tungbo
 * @Description: leecode: 1487. 保证文件名唯一
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20230227;

import java.util.HashMap;
import java.util.Map;

public class Solution1487 {
    public String[] getFolderNames(String[] names) {
        Map<String,Integer> map = new HashMap<>();
        for(int i =0; i < names.length;i++) {
            if(map.containsKey(names[i])) {
                int k = map.get(names[i]);
                while(map.containsKey(names[i] + "("+k+")")) k++;
                map.put(names[i],k);
                names[i] += "("+k+")";
            }
            map.put(names[i],1);
        }
        return names;
    }
}
