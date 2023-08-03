/*
 * @Author: Tungbo
 * @Date: 2023-08-03 15:07:54
 * @LastEditTime: 2023-08-03 15:31:00
 * @LastEditors: Tungbo
 * @Description: leecode: 722. 删除注释
 */
package wyx.wyx20230731;

import java.util.ArrayList;
import java.util.List;

public class Solition722 {
    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<String>();
        StringBuilder newLine = new StringBuilder();
        boolean inBlock = false;
        for(String line : source) {
            for(int i =0; i < line.length(); i++){
                if(inBlock) {
                    if(i + 1 < line.length() && line.charAt(i) == '*' && line.charAt(i+1) == '/') {
                        inBlock = false;
                        i++;
                    }
                } else {
                    if(i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i+1) == '*') {
                        inBlock = true;
                        i++;
                    } else if (i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i+1) == '/') {
                        break;
                    } else {
                        newLine.append(line.charAt(i));
                    }
                }
            }
            if(!inBlock && newLine.length() > 0) {
                res.add(newLine.toString());
                newLine.setLength(0);
            }
        }
        return res;
    }
}
