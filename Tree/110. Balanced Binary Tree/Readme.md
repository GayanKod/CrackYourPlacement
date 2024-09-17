# Balanced Binary Tree Solution

## Problem
We are tasked with determining if a binary tree is height-balanced. A height-balanced binary tree is defined as a binary tree where:
- The left and right subtrees of every node differ in height by no more than 1.

Link to problem: [Balanced Binary Tree](https://leetcode.com/problems/balanced-binary-tree/)

## Intuition
The problem is asking us to check if a binary tree is "balanced." A binary tree is considered balanced if for every node in the tree, the difference in height between the left subtree and the right subtree is no more than 1.

So, we need to:
1. Calculate the height of the left and right subtrees for each node.
2. Check if the height difference is within the allowed range (≤ 1).
3. Ensure this condition holds true for every node in the tree.

If any node violates this condition, the tree is unbalanced.

## Approach
The idea is to perform a post-order traversal of the binary tree (i.e., we check the left subtree, then the right subtree, and finally the current node). During this traversal:
1. We calculate the height of the left subtree.
2. We calculate the height of the right subtree.
3. If the height difference between the two subtrees is more than 1, the tree is not balanced, and we return `-1` as a signal that the subtree is unbalanced.
4. If both subtrees are balanced, we return the height of the current node, which is `1 + max(leftHeight, rightHeight)`.

By returning `-1` for any unbalanced subtree, we can propagate the result up the tree and stop further unnecessary checks.

### Steps:
1. Start from the root and recursively check the height of the left and right subtrees.
2. If any subtree is unbalanced (i.e., the height difference between left and right subtrees is greater than 1), return `-1` immediately.
3. If the subtree is balanced, return its height to the parent node.
4. Finally, the `isBalanced` function checks if the overall tree is balanced by verifying the returned value from the root.

## Complexity

### Time complexity:
- **O(n)**: We visit each node once, checking its left and right subtrees, which means the time complexity is proportional to the number of nodes in the tree, `n`.

### Space complexity:
- **O(h)**: The space complexity is proportional to the height of the tree, `h`, because the recursion stack can go as deep as the height of the tree. In the worst case, if the tree is skewed, this can be as large as `O(n)` (for a completely unbalanced tree), and in the best case, it will be `O(log n)` (for a balanced tree).

## Code

```java
class Solution {
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }
    
    // Helper function to check the height and balance of the tree
    private int checkHeight(TreeNode node) {
        if (node == null) {
            return 0; // An empty subtree is height 0 and balanced
        }
        
        // Recursively check the height of the left subtree
        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) return -1; // Left subtree is not balanced
        
        // Recursively check the height of the right subtree
        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) return -1; // Right subtree is not balanced
        
        // Check the balance condition at the current node
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // Current node is not balanced
        }
        
        // Return the height of the current node
        return Math.max(leftHeight, rightHeight) + 1;
    }
}