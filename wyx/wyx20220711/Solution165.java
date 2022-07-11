/*
 * @Author: Tungbo
 * @Date: 2022-07-11 17:10:18
 * @LastEditTime: 2022-07-11 18:40:30
 * @LastEditors: Tungbo
 * @Description: leecode: 165. 比较版本号
 * 
 * 给你两个版本号 version1 和 version2 ，请你比较它们。
 * 版本号由一个或多个修订号组成，各修订号由一个 '.' 连接。每个修订号由 多位数字 组成，可能包含 前导零 。每个版本号至少包含一个字符。修订号从左到右编号，下标从 0 开始，最左边的修订号下标为 0 ，下一个修订号下标为 1 ，以此类推。例如，2.5.33 和 0.1 都是有效的版本号。
 * 比较版本号时，请按从左到右的顺序依次比较它们的修订号。比较修订号时，只需比较 忽略任何前导零后的整数值 。也就是说，修订号 1 和修订号 001 相等 。如果版本号没有指定某个下标处的修订号，则该修订号视为 0 。例如，版本 1.0 小于版本 1.1 ，因为它们下标为 0 的修订号相同，而下标为 1 的修订号分别为 0 和 1 ，0 < 1 。
 *  如果 version1 > version2 返回 1
 *  如果 version1 < version2 返回 -1，
 *  除此之外返回 0。
 * 
 */
package wyx.wyx20220711;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution165 {
    
    public static void main(String[] args) {

        List<String> data = new ArrayList<String>();
        data.add("1.3.0");
        data.add("1.2");
        data.add("1.1");
        data.add("2.3.3");
        data.add("4.3.5");
        data.add("0.3.1");
        System.out.println(new Solution165().compareVersion(data));
    }

    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int n = Math.max(v1.length, v2.length);
        for (int i = 0; i < n; i++) {
            int code1 = v1.length <= i ? 0 : Integer.parseInt(v1[i]);
            int code2 = v2.length <= i ? 0 : Integer.parseInt(v2[i]);
            if(code1 > code2) return 1;
            if(code1 < code2) return -1;
        }
        return 0;
    }

    public List<String> compareVersion(List<String> versions) {
        Collections.sort(versions);
        // Collections.sort(versions,new Comparator<String>() {
        //     @Override
        //     public int compare(String version1, String version2) {
        //         String[] v1 = version1.split("\\.");
        //         String[] v2 = version2.split("\\.");
        //         int n = Math.max(v1.length, v2.length);
        //         for (int i = 0; i < n; i++) {
        //             int code1 = v1.length <= i ? 0 : Integer.parseInt(v1[i]);
        //             int code2 = v2.length <= i ? 0 : Integer.parseInt(v2[i]);
        //             if(code1 > code2) return 1;
        //             if(code1 < code2) return -1;
        //         }
        //         return 0;
        //     }
            
        // });
        return versions;
    }

}
