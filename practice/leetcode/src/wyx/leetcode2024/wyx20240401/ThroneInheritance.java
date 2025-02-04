/*
 * @Author: Tungbo
 * @Date: 2024-04-07 22:55:27
 * @LastEditTime: 2024-04-07 22:55:31
 * @LastEditors: Tungbo
 * @Description: leecode: 1600. 王位继承顺序
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240401;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThroneInheritance {
    Map<String, List<String>> edges;
    Set<String> dead;
    String king;

    public ThroneInheritance(String kingName) {
        edges = new HashMap<String, List<String>>();
        dead = new HashSet<String>();
        king = kingName;
    }
    
    public void birth(String parentName, String childName) {
        List<String> children = edges.getOrDefault(parentName, new ArrayList<String>());
        children.add(childName);
        edges.put(parentName, children);
    }
    
    public void death(String name) {
        dead.add(name);
    }
    
    public List<String> getInheritanceOrder() {
        List<String> ans = new ArrayList<String>();
        preorder(ans, king);
        return ans;
    }

    private void preorder(List<String> ans, String name) {
        if (!dead.contains(name)) {
            ans.add(name);
        }
        List<String> children = edges.getOrDefault(name, new ArrayList<String>());
        for (String childName : children) {
            preorder(ans, childName);
        }
    }
}
