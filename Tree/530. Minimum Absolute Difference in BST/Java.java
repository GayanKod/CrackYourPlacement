class Solution {
    private Integer prev = null; // To store the value of the previous node
    private int minDiff = Integer.MAX_VALUE; // To store the minimum absolute difference
    
    public int getMinimumDifference(TreeNode root) {
        inorder(root); // Perform inorder traversal
        return minDiff; // Return the minimum difference
    }
    
    // Helper function to perform inorder traversal
    private void inorder(TreeNode node) {
        if (node == null) {
            return; // Base case: if the node is null, return
        }
        
        // Recurse on the left subtree
        inorder(node.left);
        
        // Process the current node
        if (prev != null) {
            // Calculate the absolute difference between the current and previous node values
            minDiff = Math.min(minDiff, node.val - prev);
        }
        // Update prev to the current node's value
        prev = node.val;
        
        // Recurse on the right subtree
        inorder(node.right);
    }
}