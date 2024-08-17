# 938. Range Sum of BST

[Go to the problem on Leetcode](https://leetcode.com/problems/range-sum-of-bst/)

**Problem Description:**  

Given a Binary Search Tree (BST) and a range `[low, high]`, you need to find the sum of all node values within that range.

## Intuition

In a Binary Search Tree (BST):
- The left subtree of any node contains values less than the node's value.
- The right subtree of any node contains values greater than the node's value.

Using these properties, you can skip entire subtrees if their values are not within the given range, making the algorithm more efficient.

## Approach

1. **Base Case:**  
   If the current node is `null`, return `0` because an empty tree contributes `0` to the sum.

2. **Check Current Node:**  
   - If the current node's value is within the range `[low, high]`, add its value to the sum.

3. **Recursive Traversal:**
   - **Left Subtree:** If the current node's value is greater than the `low` bound, recursively traverse the left subtree because there might be values within the range.
   - **Right Subtree:** If the current node's value is less than the `high` bound, recursively traverse the right subtree because there might be values within the range.

4. **Return Sum:**  
   Return the accumulated sum of all nodes that fall within the specified range.

## Complexity

### Time Complexity:
- **O(N)** where `N` is the number of nodes in the BST.  
  Each node is visited at most once, but unnecessary subtrees are skipped based on the value range, which can reduce the effective number of nodes visited in practice.

### Space Complexity:
- **O(H)** where `H` is the height of the tree.  
  This space is used for the recursive call stack. In the worst case, the height of the tree can be as large as `N` (if the tree is skewed), so the space complexity can be `O(N)` in the worst case. For a balanced tree, it is `O(log N)`.

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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0; // Base case: if the current node is null, return 0

        int sum = 0; // Initialize sum

        // If the current node's value is within the range, add it to the sum
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
        
        return sum; // Return the total sum of all nodes within the range
    }
}