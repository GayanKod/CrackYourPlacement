# Minimum Absolute Difference in BST

## Problem
Given the root of a Binary Search Tree (BST), return the **minimum absolute difference** between the values of any two nodes in the tree.

Link to problem: [Minimum Absolute Difference in BST](https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/)

## Intuition
In a Binary Search Tree (BST), the left child of a node is always smaller than the node, and the right child is always larger. Because of this, the values of the nodes in an inorder traversal of a BST (left-root-right) will always be in ascending order.

The minimum absolute difference between any two nodes in a BST will be the smallest difference between two adjacent values in this inorder traversal. By traversing the tree in inorder, we can easily compute this minimum difference.

## Approach
1. Perform an **inorder traversal** of the BST. This will give us the nodes in increasing order of their values.
2. During the traversal, compare the current node's value with the previous node's value (starting with the second node) to find the absolute difference.
3. Keep track of the **minimum difference** encountered.
4. Return this minimum difference as the result.

### Steps:
1. Use a helper function to traverse the tree in **inorder**.
2. Maintain two variables:
   - `prev`: To store the value of the previous node in the inorder traversal.
   - `minDiff`: To store the current minimum absolute difference between consecutive nodes.
3. For each node during the traversal:
   - Calculate the absolute difference between the current node and the previous node.
   - Update `minDiff` if the calculated difference is smaller.
4. Return the value of `minDiff` at the end of the traversal.

## Complexity

### Time Complexity:
- **O(n)**, where `n` is the number of nodes in the tree. We visit each node exactly once during the inorder traversal.

### Space Complexity:
- **O(h)**, where `h` is the height of the tree. This is the space used by the recursion stack in the worst case. For a balanced tree, `h` is `O(log n)`; for a skewed tree, `h` is `O(n)`.

## Code

```java
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