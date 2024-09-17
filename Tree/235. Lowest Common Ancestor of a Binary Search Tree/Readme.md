# Lowest Common Ancestor of a Binary Search Tree

## Problem Description
Given a Binary Search Tree (BST), we are tasked with finding the **Lowest Common Ancestor (LCA)** of two nodes `p` and `q`. The LCA of two nodes is defined as the lowest node in the tree that has both `p` and `q` as descendants.

### Intuition
A **Binary Search Tree (BST)** has the property that for any given node:
- All values in the left subtree are less than the node's value.
- All values in the right subtree are greater than the node's value.

Given this, the position of the nodes `p` and `q` relative to the root will determine whether we should move left or right in the tree to find the LCA.

- If both `p` and `q` are smaller than the current node, then the LCA must lie in the left subtree.
- If both `p` and `q` are larger than the current node, then the LCA must lie in the right subtree.
- If `p` and `q` are on opposite sides (one is smaller and the other is larger), then the current node is the LCA.

### Approach
1. Start from the root of the BST.
2. Compare the values of `p` and `q` with the current node:
   - If both `p` and `q` are greater than the current node, move to the right subtree.
   - If both `p` and `q` are less than the current node, move to the left subtree.
   - If one of the nodes is smaller and the other is larger (or one equals the current node), then the current node is the **Lowest Common Ancestor**.
3. Return the current node once you find the LCA.

### Complexity

#### Time Complexity:
- **O(h)**, where `h` is the height of the tree. In the worst case, the tree is skewed (like a linked list), and we may need to traverse all the way down to find the LCA.
- In a balanced BST, the height is `O(log n)`, where `n` is the number of nodes in the tree.

#### Space Complexity:
- **O(1)**, since we are not using any extra space apart from the input tree and the pointers. The solution is iterative, so no recursion stack is involved.

### Code

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // As long as the root is not null
        while (root != null) {
            // If both p and q are greater than root, go right
            if (p.val > root.val && q.val > root.val) {
                root = root.right;
            }
            // If both p and q are less than root, go left
            else if (p.val < root.val && q.val < root.val) {
                root = root.left;
            }
            // If p and q are on different sides, or one of them equals root, this is the LCA
            else {
                return root;
            }
        }
        return null;
    }
}