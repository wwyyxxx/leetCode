/**
 * @Author WYX
 * @Description TODO
 * @Date 2019/10/26 2:20
 */
public class isValidBrackets {

    public static void main(String[] args) {

    }

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
