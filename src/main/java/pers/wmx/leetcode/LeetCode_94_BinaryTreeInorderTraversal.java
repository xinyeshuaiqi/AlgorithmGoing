package pers.wmx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树中序遍历
 *
 * @author: wangmingxin1
 * @create: 2018-11-05 17:46
 **/
public class LeetCode_94_BinaryTreeInorderTraversal {
    List<Integer> result=new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root!=null){
            inorderTraversal(root.left);
            result.add(root.val);
            inorderTraversal(root.right);
        }

        return result;
    }
}
