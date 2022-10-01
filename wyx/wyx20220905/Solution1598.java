package wyx.wyx20220905;

/*
 * @Author: Tungbo
 * @Date: 2022-09-09 16:31:52
 * @LastEditTime: 2022-09-09 16:37:50
 * @LastEditors: Tungbo
 * @Description: leecode: 1598. 文件夹操作日志搜集器
 * 
 * 每当用户执行变更文件夹操作时，LeetCode 文件系统都会保存一条日志记录
 * 给你一个字符串列表 logs ，其中 logs[i] 是用户在 ith 步执行的操作
 * 文件系统启动时位于主文件夹，然后执行 logs 中的操作
 * 执行完所有变更文件夹操作后，请你找出 返回主文件夹所需的最小步数
 * 
 */
public class Solution1598 {

    public int minOperations(String[] logs) {
        int ans = 0;
        for (int i = 0; i < logs.length; i++) {
            if (ans > 0 && logs[i].equals("../")) {
                ans--;
            }
            if (!logs[i].equals("./") && !logs[i].equals("../"))
                ans++;
        }
        return ans;
    }
}
