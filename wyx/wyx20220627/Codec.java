/*
 * @Author: Tungbo
 * @Date: 2022-06-29 11:05:11
 * @LastEditTime: 2022-06-29 11:17:07
 * @LastEditors: Tungbo
 * @Description: leecode: 535. TinyURL 的加密与解密
 * 
 * 
 */
package wyx.wyx20220627;

import java.util.HashMap;

public class Codec {
    
    HashMap<Integer,String> map = new HashMap<Integer,String>();
    int id = 0;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        id++;
        map.put(id, longUrl);
        return "http://tinyurl.com/"+id;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String[] strs = shortUrl.split("/");
        int id = Integer.parseInt(strs[strs.length - 1]);
        return map.get(id);
    }

}
