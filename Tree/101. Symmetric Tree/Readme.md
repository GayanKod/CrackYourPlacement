# 101. Symmetric Tree

[Go to the code on Leetcode](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/)

## Problem Description

You are given the root of a binary tree. You need to determine if the tree is symmetric around its center. In other words, the tree is symmetric if the left subtree is a mirror reflection of the right subtree.

## Intuition

To check if a binary tree is symmetric, you need to ensure that the left and right subtrees are mirror images of each other. This means that:
- The root node's left subtree should look like the mirror image of the right subtree.
- For every node in the left subtree, the corresponding node in the right subtree should have the same value and vice versa.

## Approach

1. **Base Case:**
   - If the root is `null`, the tree is symmetric by definition because an empty tree is considered symmetric.

2. **Mirror Check:**
   - Compare the left and right subtrees of the root node to see if they are mirror images of each other.
   - This involves checking:
     - If both nodes are `null`, they are symmetric.
     - If one node is `null` and the other is not, they are not symmetric.
     - If both nodes have values, check if the values are equal and recursively verify:
       - The left subtree of the first node with the right subtree of the second node.
       - The right subtree of the first node with the left subtree of the second node.

## Complexity

### Time Complexity

- **O(n)**: Each node in the tree is visited once. Here, `n` is the number of nodes in the tree.

### Space Complexity

- **O(h)**: The maximum space used is determined by the height of the tree, `h`, due to the recursion stack. In the worst case (unbalanced tree), this could be `O(n)` where `n` is the number of nodes. In the best case (balanced tree), it is `O(log n)`.

## Code

```java
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
    public boolean isSymmetric(TreeNode root) {
        // A null tree is symmetric
        if (root == null) return true;
        
        // Check if the left and right subtrees are mirror images of each other
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        // If both nodes are null, they are symmetric
        if (t1 == null && t2 == null) return true;
        
        // If only one of the nodes is null, they are not symmetric
        if (t1 == null || t2 == null) return false;
        
        // Check if the values are the same and recursively check the subtrees
        return (t1.val == t2.val)
            && isMirror(t1.left, t2.right)
            && isMirror(t1.right, t2.left);
    }
}