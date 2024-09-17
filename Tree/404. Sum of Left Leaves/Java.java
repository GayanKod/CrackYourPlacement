class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        // If the tree is empty, return 0
        if (root == null) {
            return 0;
        }

        int sum = 0;

        // Check if the left child exists and is a leaf
        if (root.left != null && root.left.left == null && root.left.right == null) {
            // Add the value of the left leaf to the sum
            sum += root.left.val;
        }

        // Recursively calculate the sum for the left and right subtrees
        sum += sumOfLeftLeaves(root.left); // Check the left subtree
        sum += sumOfLeftLeaves(root.right); // Check the right subtree

        return sum;
    }
}