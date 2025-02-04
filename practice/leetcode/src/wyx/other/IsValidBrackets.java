/*
 * @Author: Tungbo
 * @Date: 2021-08-08 22:21:17
 * @LastEditTime: 2022-05-26 21:57:23
 * @LastEditors: Tungbo
 * @Description: leecode: 
 */
package practice.leetcode.src.wyx.other;

class IsValidBrackets {
    
    public boolean isValid(String s) {
        if(s.length() % 2 != 0 ){
            return false;
        }

        if(s.contains("(") && !s.contains(")") ){
            return false;
        }
        if(s.contains("(") && !s.contains("}") ){
            return false;
        }
        if(s.contains("(") && !s.contains(")") ){
            return false;
        }
        if(!s.contains(")") && s.contains("}") && s.contains("}")){
            return false;
        }
        checkChar(s,"(");
        return false;
    }

    private boolean checkChar(String s,String cha){
        int index = s.indexOf(cha);
        int lastIndex = s.lastIndexOf(cha);
        if(index != -1 && lastIndex != -1){
            String result = s.substring(index+1,lastIndex);
            return result.length() % 2 != 0 ;
        }

        return false;
    }
}
