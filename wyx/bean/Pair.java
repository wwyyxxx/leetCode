/*
 * @Author: Tungbo
 * @Date: 2022-08-27 16:44:17
 * @LastEditTime: 2022-08-27 16:50:35
 * @LastEditors: Tungbo
 * @Description: leecode: 
 */
package wyx.bean;

public class Pair<K, V> {
    private final K element0;
    private final V element1;

    public static <K, V> Pair<K, V> createPair(K element0, V element1) {
        return new Pair<K, V>(element0, element1);
    }

    public Pair(K element0, V element1) {
        this.element0 = element0;
        this.element1 = element1;
    }

    public K getKey() {
        return element0;
    }

    public V getValue() {
        return element1;
    }
}
