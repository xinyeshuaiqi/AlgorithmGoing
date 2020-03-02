package pers.wmx.leetcode;

/**Invert a binary tree.

 Example:

 Input:

      4
    /   \
   2     7
  / \   / \
 1   3 6   9

 Output:

     4
   /   \
  7     2
 / \   / \
 9   6 3   1
 *
 *
 * @author: wangmingxin1
 * @create: 2018-11-06 11:54
 **/
public class LeetCode_226_InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {

        //递归终止条件
        if(root == null) {
            return root;
        }


        TreeNode left=root.left;
        TreeNode right=root.right;

        root.left=right;
        root.right=left;

        //反转左子树
        invertTree(root.left);
        //反转右子树
        invertTree(root.right);

        return root;
    }
}
