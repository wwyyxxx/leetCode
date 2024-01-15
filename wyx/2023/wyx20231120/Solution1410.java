/*
 * @Author: Tungbo
 * @Date: 2023-11-23 14:41:25
 * @LastEditTime: 2023-11-23 14:41:27
 * @LastEditors: Tungbo
 * @Description: leecode: 1410. HTML 实体解析器
 */
package wyx.wyx20231120;

import java.util.LinkedHashMap;
import java.util.Map;

public class Solution1410 {
    public String entityParser(String text) {
        Map<String,String> dic = new LinkedHashMap(){{
            put("&quot;","\"");
            put("&apos;","'");
            put("&gt;",">");
            put("&lt;","<");
            put("&frasl;","/");
            put("&amp;","&");
        }};
        for(Map.Entry<String,String> entry: dic.entrySet()) {
            text = text.replaceAll(entry.getKey(), entry.getValue());
        }
        return text;
    }
}
