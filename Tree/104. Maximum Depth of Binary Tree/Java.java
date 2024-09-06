/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int m = 1;
        return findDepth(root, m);
    }

    int findDepth(TreeNode node, int n){

        if (node == null) return n;
        if (node.left != null || node.right != null){
            n++;
        }
        n = Math.max(findDepth(node.left, n), findDepth(node.right, n));

        return n;

    }
}