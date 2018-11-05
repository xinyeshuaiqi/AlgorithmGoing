package pers.wmx.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

 For example:
 Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
 return its level order traversal as:
 [
 [3],
 [9,20],
 [15,7]
 ]

 *
 *
 * @author: wangmingxin1
 * @create: 2018-11-05 18:12
 **/
public class LeetCode_102_BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return null;
        }

        List<List<Integer>> result = new ArrayList<>();


        Queue<newTreeNode> queue = new LinkedList<>();
        queue.add(new newTreeNode(root,0));

        while (!queue.isEmpty()){
            newTreeNode cur = queue.poll();
            int level = cur.level;
            result.get(level).add(cur.node.val);


        }

        return result;
    }

}

class newTreeNode{
    TreeNode node;
    int level;

    public newTreeNode(TreeNode node,int level){
        this.node=node;
        this.level=level;
    }
}
