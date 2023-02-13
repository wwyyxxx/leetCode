package wyx.wyx20230213;
/*
 * @Author: Tungbo
 * @Date: 2023-02-10 12:04:45
 * @LastEditTime: 2023-02-13 12:27:10
 * @LastEditors: Tungbo
 * @Description: leecode: 1234. 替换子串得到平衡字符串
 */
public class Solution1234 {
    public int balancedString(String s) {
        // Map<Character,Integer> dic = new HashMap<>();
        int[] dic = new int['X'];
        for(char c : s.toCharArray()) {
            // dic.put(c,dic.getOrDefault(0) + 1);
            dic[c]++;
        }
        int n = s.length(), m = s.length() / 4;
        int ans = n, l = 0;
        if(dic['Q'] == m && dic['W'] == m && dic['E'] == m && dic['R'] == m) return 0;
        for(int r = 0; r < n; r++) {
            dic[s.charAt(r)]--;
            while(dic['Q'] <= m && dic['W'] <= m && dic['E'] <= m && dic['R'] <= m) {
                ans = Math.min(ans, r-l+1);
                dic[s.charAt(l++)]++;
            }
        }
        return ans;
    }
}
