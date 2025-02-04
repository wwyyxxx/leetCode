/*
 * @Author: Tungbo
 * @Date: 2022-09-23 11:09:32
 * @LastEditTime: 2022-09-23 14:46:58
 * @LastEditors: Tungbo
 * @Description: leecode: 707. 设计链表
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220919;

public class MyLinkedList {

    int size;
    ListNode dummy;

    public MyLinkedList() {
        size = 0;
        dummy = new ListNode(0);
    }
    
    //get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1
    public int get(int index) {
        ListNode node = dummy.next;
        for (int i = 0; i < index; i++) {
            if(node == null) return -1;
            node = node.next;
        }
        return node.val;
    }
    
    //addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点
    public void addAtHead(int val) {
        addAtIndex(0,val);
    }
    
    //addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素
    public void addAtTail(int val) {
        addAtIndex(size,val);
    }
    
    //addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        size++;
        ListNode node = dummy;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        ListNode addNode = new ListNode(val);
        addNode.next = node.next;
        node.next = addNode;
    }
    
    //deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        ListNode node = dummy;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        node.next = node.next.next;
    }

}

class ListNode {
    public int val;
    public ListNode next;
    public ListNode() { }
    public ListNode(int x) { val = x; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}