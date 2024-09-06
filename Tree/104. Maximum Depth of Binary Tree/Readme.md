# 104. Maximum Depth of Binary Tree - Solution Explanation

[Go to the problem on Leetcode](https://leetcode.com/problems/maximum-depth-of-binary-tree/)

## Intuition
The problem asks us to find the maximum depth (or height) of a binary tree. The depth is defined as the number of nodes along the longest path from the root to a leaf node. A simple way to approach this is to traverse the tree, and for each node, find the maximum depth of its left and right subtrees. The deepest subtree will give us the answer.

If the tree is empty, the depth is `0`. Otherwise, we recursively calculate the depth of the left and right subtrees and return the larger value, adding `1` to account for the current node.

## Approach
1. **Base Case**:
   - If the current node is `null`, return `0`. This means we have reached the end of a branch (leaf node).
   
2. **Recursive Depth Calculation**:
   - For each node, recursively find the depth of the left subtree and the right subtree.
   - If both left and right subtrees exist, increase the depth by 1.
   - The depth of the current node is the maximum of the two depths plus 1 (to account for the current node).

3. **Final Result**:
   - Return the maximum depth after traversing both subtrees.

## Complexity

- **Time complexity**:  
  The time complexity is **O(n)** where `n` is the total number of nodes in the tree. Each node is visited exactly once to compute its depth.

- **Space complexity**:  
  The space complexity is **O(h)** where `h` is the height of the tree. This space is used by the recursive call stack.

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
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;  // Base case: if tree is empty
        int m = 1;  // Initialize depth as 1 (since we are starting from root)
        return findDepth(root, m);  // Call the helper function to find max depth
    }

    int findDepth(TreeNode node, int n) {
        if (node == null) return n;  // If node is null, return current depth
        if (node.left != null || node.right != null) {
            n++;  // If the node has children, increase depth
        }
        // Recursively find max depth in both left and right subtrees
        n = Math.max(findDepth(node.left, n), findDepth(node.right, n));
        return n;  // Return the maximum depth found
    }
}