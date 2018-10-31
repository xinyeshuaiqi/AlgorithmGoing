package pers.wmx.leetcode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * Example:
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * Note:
 * Your algorithm should use only constant extra space.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 *
 * @author: wangmingxin1
 * @create: 2018-10-31 14:38
 **/
public class LeetCode_24_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        //创建一个虚拟头结点，方便操作
        ListNode newHead=new ListNode(0);
        newHead.next=head;

        //我们需要4个指针
        ListNode pre = newHead;
        ListNode p1 = newHead;
        ListNode p2 = newHead;
        ListNode next = newHead;

        while(pre.next!=null && pre.next.next!=null){
            p1=pre.next;
            p2=p1.next;
            next=p2.next;

            pre.next=p2;
            p2.next=p1;
            p1.next=next;
            pre=p1;
        }

        return newHead.next;
    }
}
