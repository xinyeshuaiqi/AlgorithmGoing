package pers.wmx.leetcode;

/**
 * Reverse a singly linked list.
 *
 * Example:
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 *
 * Follow up:
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 *
 * @author: wangmingxin1
 * @create: 2018-10-30 15:18
 **/
public class LeetCode_206_ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        while(cur.next!=null){
            next=cur.next;
            cur.next=pre;
            pre =cur;
            cur = next;
        }
        cur.next=pre;

        return cur;
    }

}

/**
 * Definition for singly-linked list.
 * */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}