/*
 * @Author: Tungbo
 * @Date: 2023-02-09 11:29:38
 * @LastEditTime: 2023-02-09 11:55:47
 * @LastEditors: Tungbo
 * @Description: leecode: 1797. 设计一个验证系统
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20230206;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationManager {

    int timeToLive;
    Map<String,Integer> dic;
    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        dic = new HashMap<>();
    }
    
    public void generate(String tokenId, int currentTime) {
        dic.put(tokenId,currentTime+timeToLive);
    }
    
    public void renew(String tokenId, int currentTime) {
        if(!dic.containsKey(tokenId)) return;
        if(dic.get(tokenId) <= currentTime) dic.remove(tokenId);
        else dic.put(tokenId,currentTime+timeToLive);
    }
    
    public int countUnexpiredTokens(int currentTime) {
        int ans = 0;
        for(Map.Entry<String,Integer> e : dic.entrySet()) {
            if(e.getValue() > currentTime){
                ans++;
            }
        }
        return ans;
    }

}
