/*
 * @Author: Tungbo
 * @Date: 2024-07-01 16:36:42
 * @LastEditTime: 2024-07-02 16:32:41
 * @LastEditors: Tungbo
 * @Description: leecode: 146. LRU 缓存
 */
package wyx.bean;

public class DLinkedNode {
    public int key;
    public int val;
    public DLinkedNode next;
    public DLinkedNode prev;
    public DLinkedNode(){}
    public DLinkedNode(int key,int val){
        this.key = key;
        this.val = val;
    }
}
