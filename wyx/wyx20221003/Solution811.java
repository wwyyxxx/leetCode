package wyx.wyx20221003;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @Author: Tungbo
 * @Date: 2022-10-04 15:21:52
 * @LastEditTime: 2022-10-04 15:42:02
 * @LastEditors: Tungbo
 * @Description: leecode: 811. 子域名访问计数
 * 
 * 网站域名 "discuss.leetcode.com" 由多个子域名组成。
 * 顶级域名为 "com" ，二级域名为 "leetcode.com" ，最低一级为 "discuss.leetcode.com" 。
 * 当访问域名 "discuss.leetcode.com" 时，同时也会隐式访问其父域名 "leetcode.com" 以及 "com" 。
 * 
 * 给你一个 计数配对域名 组成的数组 cpdomains ，解析得到输入中每个子域名对应的 计数配对域名 ，并以数组形式返回。可以按 任意顺序 返回答案
 * 
 */
public class Solution811 {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < cpdomains.length; i++) {
            String cpdomain = cpdomains[i];
            String[] cp = cpdomain.split(" ");
            int count = Integer.valueOf(cp[0]);
            String domain = cp[1];
            map.put(domain, map.getOrDefault(domain, 0)+count);
            
            while(domain.indexOf(".")!=-1) {
                domain = domain.substring(domain.indexOf(".")+1, domain.length());
                map.put(domain, map.getOrDefault(domain, 0)+count);
            }
        }
        List<String> ans = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue()+" "+entry.getKey());
        }
        return ans;
    }
}
