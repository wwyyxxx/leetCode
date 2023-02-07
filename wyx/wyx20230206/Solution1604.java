/*
 * @Author: Tungbo
 * @Date: 2023-02-07 12:42:53
 * @LastEditTime: 2023-02-07 13:04:07
 * @LastEditors: Tungbo
 * @Description: leecode: 1604. 警告一小时内使用相同员工卡大于等于三次的人
 */
package wyx.wyx20230206;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Solution1604 {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        List<String> ans = new ArrayList<String>();
        Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
        for (int i = 0; i < keyTime.length; i++) {
            map.computeIfAbsent(keyName[i], k -> new ArrayList<>()).add(coverTime(keyTime[i]));
        }
        for(Map.Entry<String,List<Integer>> entry: map.entrySet()) {
            String name = entry.getKey();
            List<Integer> times = entry.getValue();
            Collections.sort(times);
            if(times.size() <= 2) continue;
            for (int i = 2; i < times.size(); i++) {
                if(times.get(i) - times.get(i-2) <= 60) {
                    ans.add(name);
                    break;
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }

    private int coverTime(String str) {
        String[] times = str.split(":");
        return Integer.valueOf(times[0])*60 + Integer.valueOf(times[1]);
    }
}
