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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<String>();
        // Edge case: if root is null, return an empty list
        if (root == null) return list;
        // Call helper method to start collecting paths
        getPath(root, "", list);
        return list;
    }

    public void getPath(TreeNode node, String path, List<String> list) {
        if (node == null) return;

        // Append current node value to the path
        path += node.val;

        // If it's a leaf node, add the path to the list
        if (node.left == null && node.right == null) {
            list.add(path);
        } else {
            // If not a leaf, continue the path with "->" separator
            path += "->";
            // Recursively traverse left and right subtrees
            if (node.left != null) getPath(node.left, path, list);
            if (node.right != null) getPath(node.right, path, list);
        }
    }
}