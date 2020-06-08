package pers.wmx.practice.linkedlist;

/**
 * @author: wangmingxin03
 * @date: 2020-06-08
 */
public class FindKthToTail {

    public ListNode findKthToTail(ListNode head, int k) {
        if(k <= 0 || head == null) {
            return null;
        }

        //维护2个指针p和q
        ListNode p = head;
        ListNode q = head;
        ListNode temp = p;

        int distance = 0;
        while (temp.next != null) {
            q = q.next;
            distance ++;  //p与q的距离++
            if(distance == k-1) {
                break;
            }

            temp = temp.next;
        }

        if(distance < k-1) {
            //说明没走到k-1的距离，已经为空
            return null;
        }

        while(q.next != null) {
            //2个指针每次向后移动一位，直到q.next == null说明到尾节点
            q = q.next;
            p = p.next;
        }

        return p;
    }
}
