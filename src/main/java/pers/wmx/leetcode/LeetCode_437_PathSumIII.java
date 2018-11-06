package pers.wmx.leetcode;

/**
 * You are given a binary tree in which each node contains an integer value.
 *
 * Find the number of paths that sum to a given value.
 *
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 *
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 *
 * Example:
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * Return 3. The paths that sum to 8 are:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 *
 * @author: wangmingxin1
 * @create: 2018-11-06 15:17
 **/

public class LeetCode_437_PathSumIII {
    public int pathSum(TreeNode root, int sum) {

        if (root == null) {
            return 0;
        }

        int result = findPath(root, sum);

        result+=pathSum(root.left, sum);
        result+=pathSum(root.right, sum);

        return result;
    }

    public int findPath(TreeNode node, int num) {

        if(node==null){
            return 0;
        }

        int result=0;

        if(node.val==num){
            result+=1;
        }

        result+=findPath(node.left, num-node.val);
        result+=findPath(node.right, num-node.val);

        return result;
    }
}
