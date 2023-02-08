/*
 * @Author: Tungbo
 * @Date: 2023-02-08 11:49:53
 * @LastEditTime: 2023-02-08 11:51:49
 * @LastEditors: Tungbo
 * @Description: leecode: 1233. 删除子文件夹
 */
package wyx.wyx20230206;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution1233 {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        Set<String> ans = new HashSet<>();
        String cur = folder[0];
        for(int i = 1; i < folder.length; i++) {
            ans.add(cur);
            int idx = folder[i].indexOf(cur+"/");
            //|| (idx == 0 && folder[i].charAt(cur.length()) != '/')
            if(idx != 0 ) {
                cur = folder[i];
                if(i == folder.length -1) ans.add(cur);
            }
        }
        return new ArrayList<>(ans);
    }
}
