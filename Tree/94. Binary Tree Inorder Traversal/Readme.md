# Binary Tree Inorder Traversal

## Problem
Given the root of a binary tree, you need to return the **inorder traversal** of its nodes' values. In inorder traversal, we visit nodes in the following order:
1. First, visit the left subtree.
2. Then, visit the root node.
3. Finally, visit the right subtree.

Link to problem: [Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/description/)

## Intuition
Inorder traversal is one of the depth-first traversal techniques for a binary tree. When you perform an inorder traversal, you visit nodes in a left-root-right order. This means:
- You first go as far left as possible, visiting all left children.
- Once you can’t go left anymore, you visit the current node.
- After visiting the current node, you explore its right subtree.

In simple terms, for any node, you:
1. Traverse the left subtree.
2. Process the current node.
3. Traverse the right subtree.

This results in a sorted order traversal for binary search trees (BSTs), but works on any binary tree.

## Approach
There are multiple ways to perform inorder traversal:
1. **Recursive approach**: You can solve the problem by using recursion. The idea is to recursively traverse the left subtree, visit the current node, and then recursively traverse the right subtree.
   
   Recursive methods naturally fit tree structures because you can solve each subtree as a smaller problem.

2. **Iterative approach**: You can use a stack to simulate the system call stack used in recursion. The iterative approach may sometimes be preferred because it avoids deep recursion which can cause stack overflow for very large trees.

### Recursive Approach:
1. Define a helper function that takes the current node.
2. If the current node is not `null`:
   - First, recursively call the helper function on the left subtree.
   - Add the value of the current node to the result list.
   - Then, recursively call the helper function on the right subtree.
3. If the current node is `null`, just return.

### Iterative Approach (for reference):
- Use a stack to simulate the recursive calls.
- Push all the left nodes onto the stack.
- Process each node by popping it from the stack and adding its value to the result list.
- Then move to the right subtree.

### Code

```java
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