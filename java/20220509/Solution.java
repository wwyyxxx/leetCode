import bean.Node;

/*
 * @Author: Tungbo
 * @Date: 2021-07-06 14:44:26
 * @LastEditTime: 2022-05-11 19:14:08
 * @LastEditors: Tungbo
 * @Description: leecode: 展平多级双向链表
 * 多级双向链表中，除了指向下一个节点和前一个节点指针之外，它还有一个子链表指针，可能指向单独的双向链表。这些子列表也可能会有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
 *
 * 给定位于列表第一级的头节点，请扁平化列表，即将这样的多级双向链表展平成普通的双向链表，使所有结点出现在单级双链表中。
 *
 */
public class Solution {

    public static void main(String[] args) {
    }

    public Node flatten(Node head) {
        handleChilderNode(head);
        return head;
    }

    private Node handleChilderNode(Node head) {
        Node cur = head;
        Node last = null;
        
        while(cur!=null) {
           Node temp = cur.next;
           if(cur.child != null) {
            Node childLast = handleChilderNode(cur.child);

            cur.next = cur.child;
            cur.child.prev = cur;
            
            if(temp!=null) {
                childLast.next = temp;
                temp.prev = childLast;
            }
            cur.child = null;
            last = childLast;
           } else {
                last = cur;
           }
           cur = temp;
        }
        return last;
    }

}