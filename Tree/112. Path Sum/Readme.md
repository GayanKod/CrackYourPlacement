# 112. Path Sum

[Go to the problem on Leetcode](https://leetcode.com/problems/path-sum)

Given a binary tree and a target sum, we need to check if there exists a path from the root to any leaf node such that the sum of the node values along the path equals the target sum.

## Intuition

The problem asks us to find a path from the root of the binary tree to a leaf where the sum of the node values equals a given target sum. A **leaf** node is a node with no children (both left and right are `null`).

We can solve this by traversing the tree and keeping track of the sum of values as we go. At each step, we add the value of the current node to a running sum. When we reach a leaf node, we check if the accumulated sum matches the target sum.

If we find a matching path, we return `true`. If no such path is found, we return `false`.

## Approach

1. **Base Case (Empty Tree):** 
   If the tree is empty (i.e., `root == null`), return `false` because there are no paths.

2. **Recursive Traversal:** 
   We perform a depth-first search (DFS) to explore all paths from the root to the leaves.
   - At each node, add the node's value to the current sum.
   - When we reach a leaf node (both `left` and `right` are `null`), check if the sum equals the target sum.
   - If we find a matching path, return `true`.
   - If not, keep searching the left and right subtrees.

3. **Return Result:**
   If any of the recursive calls return `true`, it means there is a valid path. Otherwise, if all calls return `false`, there is no valid path.

## Complexity

### Time complexity:
- **O(N)**, where `N` is the number of nodes in the tree. In the worst case, we may need to visit all nodes once to check every possible path.

### Space complexity:
- **O(H)**, where `H` is the height of the tree. This is the space used by the recursion stack. In the worst case (for a skewed tree), the height `H` can be equal to `N`, leading to O(N) space complexity. In the best case (for a balanced tree), the height would be `log(N)`.

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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // Base case: if the tree is empty, no path exists
        if (root == null) return false;

        int sum = 0;  // Initialize the sum to 0

        // Start the depth-first search from the root
        return dfs(root, sum, targetSum);
    }

    // Helper function to perform DFS and check for the path sum
    boolean dfs (TreeNode root, int sum, int targetSum) {
        // If the current node is not null
        if (root != null) {
            // Add the current node's value to the running sum
            sum += root.val;

            // If we reach a leaf node (both left and right are null)
            if (root.left == null && root.right == null) {
                // Check if the current sum matches the target sum
                if (sum == targetSum) {
                    return true;
                } else {
                    return false;
                }
            }

            // Recursively search the left and right subtrees
            return dfs(root.left, sum, targetSum) || dfs(root.right, sum, targetSum);
        } else {
            // If the node is null, return false
            return false;
        }
    }
}