package pers.wmx.leetcode;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 *
 * Note:
 * Given n will always be valid.
 *
 * Follow up:
 * Could you do this in one pass?
 *
 *
 * @author: wangmingxin1
 * @create: 2018-10-31 15:06
 **/
public class LeetCode_19_RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //创建虚拟头结点
        ListNode newHead =new ListNode(0);
        newHead.next=head;

        ListNode p1= newHead;
        ListNode p2= newHead;
        int dis=0;  //2个指针的距离
        while(p2!=null){
            if(dis == (n+1)){
                p1=p1.next;
                dis--;
            }
            p2=p2.next;
            dis++;
        }
        p1.next=p1.next.next;

        return newHead.next;
    }
}
