package pers.wmx.practice.linkedlist;

/**
 * @author: wangmingxin03
 * @date: 2020-06-03
 */
public class MergeLinkedList {

    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode head = new ListNode(-1);
        head.next = null;

        //合并的链表
        ListNode mergeList = head;
        ListNode p = list1;
        ListNode q = list2;

        while(p != null && q != null){
            if(p.var < q.var){
                head.next = p;
                head = p;
                p = p.next;
            }else{
                head.next = q;
                head = q;
                q = q.next;
            }
        }

        if(p != null){
            head.next = p;
        }

        if(q != null){
            head.next=q;
        }

        return mergeList.next;
    }

}
