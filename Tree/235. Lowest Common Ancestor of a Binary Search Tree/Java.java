/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // As long as the root is not null
        while (root != null) {
            // If both p and q are greater than root, go right
            if (p.val > root.val && q.val > root.val) {
                root = root.right;
            }
            // If both p and q are less than root, go left
            else if (p.val < root.val && q.val < root.val) {
                root = root.left;
            }
            // If p and q are on different sides, or one of them equals root, this is the LCA
            else {
                return root;
            }
        }
        return null;
    }
}