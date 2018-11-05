package pers.wmx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**二叉树后序遍历
 *
 * @author: wangmingxin1
 * @create: 2018-11-05 17:49
 **/
public class LeetCode_145_BinaryTreePostorderTraversal {
    List<Integer> result=new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root!=null){
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            result.add(root.val);
        }
        return result;
    }
}
