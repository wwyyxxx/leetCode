public class TestUtil {
    public static void main(String[] args) {

        MaxQueue q = new MaxQueue();
        q.push_back(1);
        q.push_back(2);
        System.out.println("1 "+q.max_value());
        System.out.println("2 "+q.pop_front());
        System.out.println("3 "+q.max_value());
    }
}
/*
 * @Author: Tungbo
 * @Date: 2021-09-03 15:09:15
 * @LastEditTime: 2021-09-03 15:12:32
 * @LastEditors: Tungbo
 * @Description: leecode: 
 */
