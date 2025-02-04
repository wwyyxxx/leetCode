/*
 * @Author: Tungbo
 * @Date: 2022-06-21 15:21:50
 * @LastEditTime: 2022-06-21 15:21:52
 * @LastEditors: Tungbo
 * @Description: leecode: 1108. IP 地址无效化
 * 
 * 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
 * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220620;

public class Solution1108 {
    public String defangIPaddr(String address) {
        return address.replace(".","[.]");
    }
}
