# Sum of Left Leaves

## Problem
You are given the root of a binary tree. Your task is to find the sum of all left leaves in the tree. A **left leaf** is defined as a leaf node that is the left child of its parent.

Link to problem: [Sum of Left Leaves](https://leetcode.com/problems/sum-of-left-leaves/description/)

## Intuition
The problem asks us to sum all the left leaves in a binary tree. A **leaf** is a node that has no children. If this leaf is also the left child of its parent, it qualifies as a "left leaf".

We can solve this problem using a recursive approach where we explore each node in the tree and check:
1. If the left child is a leaf (has no children), we add its value to the sum.
2. If not, we recursively explore the left and right subtrees of the current node.

### Key Observations:
- A left leaf is a node that has no left or right children and is the left child of its parent.
- We need to explore each node of the tree and check if its left child is a leaf.

## Approach
We can solve this problem using a recursive method:
1. Traverse the tree starting from the root.
2. For each node:
   - Check if the left child exists and is a leaf node (i.e., both its left and right children are `null`). If true, add its value to the sum.
   - Recursively explore the left and right subtrees to continue searching for other left leaves.
3. If the node is `null`, return 0 because an empty subtree has no leaves.

### Steps:
- Start at the root of the tree.
- For each node, if it has a left child that is a leaf, add the value of the left child to the sum.
- Recursively call the function for both the left and right children of the current node.

## Code

```java
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