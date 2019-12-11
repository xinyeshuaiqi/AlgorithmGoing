package pers.wmx.practice.linkedlist;


/**
 * @author wmx
 * @date 2019-11-29
 */
public class ReverseLinedList {

    public ListNode reverse(ListNode origin){
        if(origin == null){
            return origin;
        }

        ListNode pre = null;
        ListNode cur = origin;
        ListNode next = null;

        //反转核心代码
        while (cur.next!=null){
            //next 指针记录后面的元素，否则会断掉
            next = cur.next;
            cur.next = pre;

            //pre、cur一起右移
            pre = cur;
            cur = next;
        }

        //到链表末尾的特殊处理 cur.next == null; 最后一处还未反转
        cur.next = pre;

        return cur;

    }

}
