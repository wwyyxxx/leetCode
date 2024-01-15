/*
 * @Author: Tungbo
 * @Date: 2022-10-29 15:04:59
 * @LastEditTime: 2022-10-29 15:09:52
 * @LastEditors: Tungbo
 * @Description: leecode: 1773. 统计匹配检索规则的物品数量
 * 
 * 给你一个数组 items ，其中 items[i] = [typei, colori, namei] ，描述第 i 件物品的类型、颜色以及名称
 * 另给你一条由两个字符串 ruleKey 和 ruleValue 表示的检索规则。
 * 如果第 i 件物品能满足下述条件之一，则认为该物品与给定的检索规则 匹配 
 *  ruleKey == "type" 且 ruleValue == typei 。
 *  ruleKey == "color" 且 ruleValue == colori 。
 *  ruleKey == "name" 且 ruleValue == namei 。
 * 统计并返回 匹配检索规则的物品数量 。
 * 
 */
package wyx.wyx20221024;

import java.util.List;

public class Solution1773 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int ans = 0;
        int key = "type".equals(ruleKey) ? 0 : "color".equals(ruleKey) ? 1 : 2;
        for (List<String> list : items) {
            if(list.get(key).equals(ruleValue)) ans++;
        }
        return ans;
    }
}
