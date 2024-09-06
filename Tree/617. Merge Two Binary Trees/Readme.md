# 617. Merge Two Binary Trees - Solution Explanation

[Go to the problem on Leetcode](https://leetcode.com/problems/merge-two-binary-trees/)

## Intuition
The idea is simple: we want to merge two binary trees into a new tree. The merging process works by comparing the nodes of the two trees:
- If both trees have a node at the same position, their values are summed up.
- If one tree has a node and the other doesn't, we take the existing node.
- If both trees are missing a node, we stop at that point.

This results in a new tree where each node is the sum of the nodes in the original trees, if they both exist.

## Approach
1. **Base Case**:
   - If one of the trees is `null` at a position, return the node from the other tree.
   - If both nodes are `null`, there's nothing to merge at that position.

2. **Create a New Node**:
   - For nodes where both trees have values, create a new node with the sum of the two node values (`root1.val + root2.val`).

3. **Recursive Merge**:
   - Recursively apply the merging process for the left and right child nodes:
     - Merge the left children of both trees and assign the result as the left child of the new tree.
     - Merge the right children and assign the result as the right child.

4. **Return the New Tree**:
   - Once all nodes are processed, return the root of the newly created merged tree.

## Complexity

- **Time complexity**:  
  The time complexity is **O(n)** where `n` is the total number of nodes in the smaller of the two trees. We need to visit each node once to merge it.

- **Space complexity**:  
  The space complexity is **O(h)** where `h` is the height of the tree. This is due to the recursive calls and the space needed for the call stack.

## Code

```java
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        
        if (root1 == null) return root2;  // If one tree is null, return the other tree
        if (root2 == null) return root1;  // If the other tree is null, return the first tree

        // Create a new node for the merged tree with the sum of root1 and root2 values
        TreeNode tree = new TreeNode(root1.val + root2.val);

        // Recursively merge the left and right children of both trees
        tree.left = mergeTrees(root1.left, root2.left);
        tree.right = mergeTrees(root1.right, root2.right);

        return tree;  // Return the merged tree
    }
}