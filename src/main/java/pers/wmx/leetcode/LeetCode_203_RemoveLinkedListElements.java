package pers.wmx.leetcode;

/**
 * 删除值为指定值的节点
 *
 * @author: wangmingxin1
 * @create: 2018-10-31 14:15
 **/
public class LeetCode_203_RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        //删除节点时，如果是头结点需要特殊处理
        //创建一个虚拟头结点，可以简化这一操作

        ListNode newHead = new ListNode(0);
        newHead.next=head;
        //遍历链表的指针
        ListNode cur = newHead;
        ListNode next = null;

        while(cur.next!=null){
            next=cur.next;
            if(next.val==val){
                cur.next=next.next;
            }else{
                cur = cur.next;
            }
        }

        return newHead.next;

    }
}

