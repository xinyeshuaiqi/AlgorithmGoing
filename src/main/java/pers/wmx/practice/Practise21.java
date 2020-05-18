package pers.wmx.practice;

/**
 * @author: wangmingxin03
 * @date: 2020-05-18
 */
public class Practise21 {


    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode == null) {
            return null;
        }

        //如果节点有右子树
        if(pNode.right != null){
            TreeLinkNode p = pNode.right;

            //找到右子树最左边的节点
            while(p.left != null) {
                p = p.left;
            }
            return p;
        }else{
            //如果节点无右子树

            //是其父节点的左子树
            TreeLinkNode parent = pNode.next;
            if(parent==null || parent.left == pNode) {
                return parent;
            } else{
                //是其父节点的右子树
                TreeLinkNode  pparent = parent.next;
                while(pparent != null && pparent.left != parent){
                    parent = pparent;
                    pparent = pparent.next;
                }
                return pparent;
            }
        }
    }




}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;   //记录父节点

    TreeLinkNode(int val) {
        this.val = val;
    }
}