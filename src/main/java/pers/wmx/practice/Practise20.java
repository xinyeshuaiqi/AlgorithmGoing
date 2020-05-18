package pers.wmx.practice;

/**
 * @author: wangmingxin03
 * @date: 2020-05-18
 */
public class Practise20 {

    public boolean SameTree(TreeNode root1,TreeNode root2){
        if(root1 == null && root2 == null)return true;
        if(root1 == null)return false;
        if(root2 == null)return true;

        if(root1.val == root2.val)
            return SameTree(root1.left, root2.left) && SameTree(root1.right, root2.right);
        else
            return false;
    }

    //solution
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {

        if(root1 == null && root2 == null)return false;
        if(root1 == null)return false;
        if(root2 == null)return false;

        //当前根节点相同
        if(root1.val == root2.val) {
            //左子树相同 + 右子树相同
            if (SameTree(root1.left, root2.left) &&
                    SameTree(root1.right, root2.right)) {
                return true;
            }
        }

        //root1的左子树、右子树分别和root2比较，看看是否部分相同
        if(HasSubtree(root1.left, root2))
            return true;
        if(HasSubtree(root1.right, root2))
            return true;
        return false;

    }

}


class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}