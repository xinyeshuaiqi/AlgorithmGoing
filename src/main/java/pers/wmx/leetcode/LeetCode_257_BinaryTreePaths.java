package pers.wmx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**Given a binary tree, return all root-to-leaf paths.

 Note: A leaf is a node with no children.

 Example:

 Input:

      1
    /   \
   2     3
    \
      5

 Output: ["1->2->5", "1->3"]

 Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 *
 *
 * @author: wangmingxin1
 * @create: 2018-11-06 14:28
 **/
public class LeetCode_257_BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList();
        dfs(result, "", root);
        return result;
    }

    public void dfs(List<String> result, String cur, TreeNode root) {
        if (root == null) return;

        cur += String.valueOf(root.val);

        if (root.left == null && root.right == null) {
            result.add(cur);
            //cur = "";
        } else {
            cur += "->";
        }

        dfs(result, cur, root.left);
        dfs(result, cur, root.right);
    }
}