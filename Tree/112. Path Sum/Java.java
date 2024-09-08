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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        
        if (root == null) return false;

        int sum = 0;

        return dfs(root, sum, targetSum);
        
    }

    boolean dfs (TreeNode root, int sum, int targetSum){

        if (root != null){
            sum += root.val;

            if (root.left == null && root.right == null){
                if (sum == targetSum)return true;
                else return false;
            }

            return dfs(root.left, sum, targetSum) || dfs(root.right, sum, targetSum);
        }else{
            return false;
        }

    }
}