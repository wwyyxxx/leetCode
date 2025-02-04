/*
 * @Author: Tungbo
 * @Date: 2022-06-04 18:09:34
 * @LastEditTime: 2022-06-04 18:12:44
 * @LastEditors: Tungbo
 * @Description: leecode: 929. 独特的电子邮件地址
 * 
 * 每个 有效电子邮件地址 都由一个 本地名 和一个 域名 组成，以 '@' 符号分隔。除小写字母之外，电子邮件地址还可以含有一个或多个 '.' 或 '+' 。
 * 
 * 如果在电子邮件地址的 本地名 部分中的某些字符之间添加句点（'.'），则发往那里的邮件将会转发到本地名中没有点的同一地址。请注意，此规则 不适用于域名 。
 * 
 * 如果在 本地名 中添加加号（'+'），则会忽略第一个加号后面的所有内容。这允许过滤某些电子邮件。同样，此规则 不适用于域名 。
 * 给你一个字符串数组 emails，我们会向每个 emails[i] 发送一封电子邮件。返回实际收到邮件的不同地址数目。
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220530;

import java.util.HashSet;
import java.util.Set;

public class Solution929 {
    
    public static void main(String[] args) {
        System.out.println(new Solution929().numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.email.leet+alex@code.com"}));
    }


    public int numUniqueEmails(String[] emails) {
        Set<String> addres = new HashSet<String>();
        for(String email : emails) {
            //分割
            String[] temp = email.split("@");
            //处理 + 号
            temp[0] = temp[0].split("\\+")[0];
            //处理 . 号
            temp[0] = temp[0].replace(".","");
            //去重
            addres.add(temp[0]+"@"+temp[1]);
        }
        return addres.size();
    }
}
