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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        int sum = 0;

        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }
        
        // If the current node's value is greater than the lower bound,
        // there might be valid values in the left subtree
        if (root.val > low) {
            sum += rangeSumBST(root.left, low, high);
        }
        
        // If the current node's value is less than the upper bound,
        // there might be valid values in the right subtree
        if (root.val < high) {
            sum += rangeSumBST(root.right, low, high);
        }
        
        return sum;
    }
}