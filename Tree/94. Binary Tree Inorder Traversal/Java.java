// Recursive Approach
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>(); // List to store the inorder traversal result
        inorderHelper(root, result); // Call the helper function to perform inorder traversal
        return result;
    }
    
    // Helper function to perform inorder traversal
    private void inorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) {
            return; // Base case: if the node is null, return
        }
        
        inorderHelper(node.left, result); // Recurse on the left subtree
        result.add(node.val); // Add the current node's value to the result list
        inorderHelper(node.right, result); // Recurse on the right subtree
    }
}