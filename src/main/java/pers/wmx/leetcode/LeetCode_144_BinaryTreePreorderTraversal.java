package pers.wmx.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**二叉树前序遍历
 *
 * Given a binary tree, return the preorder traversal of its nodes' values.

 Example:
 Input: [1,null,2,3]
  1
   \
    2
  /
 3

 Output: [1,2,3]
 Follow up: Recursive solution is trivial, could you do it iteratively?
 *
 *
 * @author: wangmingxin1
 * @create: 2018-11-05 17:37
 **/
public class LeetCode_144_BinaryTreePreorderTraversal {

    List<Integer> result = new ArrayList<>();

    //递归法
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root != null){
            result.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return result;
    }

    //非递归法  借助栈
    public List<Integer> preorderTraversal1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root == null) return result;
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if(node.left != null) stack.push(node.right);
            if(node.right != null) stack.push(node.left);
        }
        return result;
    }

}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }