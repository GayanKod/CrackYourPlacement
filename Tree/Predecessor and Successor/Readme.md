# Predecessor and Successor in BST

## Problem
You are given a binary search tree (BST) and a key. Your task is to find the predecessor and successor of the given key in the BST. The predecessor of a node is the largest value smaller than the key, and the successor is the smallest value greater than the key.

Link to problem: [Predecessor and Successor](https://www.geeksforgeeks.org/problems/predecessor-and-successor/1)

## Intuition
In a Binary Search Tree (BST):
- The **predecessor** of a node is the node with the largest value that is smaller than the given key.
- The **successor** of a node is the node with the smallest value that is larger than the given key.

Since the BST is structured in such a way that all nodes in the left subtree are smaller and all nodes in the right subtree are larger, we can use this property to efficiently find the predecessor and successor.

### Key Observations:
1. If the current node’s value is greater than the key, the successor could be the current node, but we need to explore the left subtree for a potentially smaller successor.
2. If the current node’s value is smaller than the key, the predecessor could be the current node, but we need to explore the right subtree for a potentially larger predecessor.

## Approach
We will perform a modified in-order traversal of the BST. During the traversal:
- If we encounter a node greater than the key, we update the successor and move to the left subtree.
- If we encounter a node smaller than the key, we update the predecessor and move to the right subtree.
- If we find the exact node equal to the key, we check its left and right subtrees to directly find the predecessor (largest node in the left subtree) and successor (smallest node in the right subtree).

### Steps:
1. Traverse the BST while comparing each node's value with the given key.
2. Keep updating the predecessor and successor based on the current node’s value relative to the key.
3. Once the key is found, check the immediate left and right subtrees to update the predecessor and successor if needed.

## Code

```java
class Solution {
    public static void findPreSuc(Node root, Node[] pre, Node[] suc, int key) {
        // Start by traversing the BST
        while (root != null) {
            if (root.data < key) {
                // This node could be the predecessor (as it's smaller than the key)
                pre[0] = root;
                root = root.right; // Move to the right subtree to find a closer predecessor
            } else if (root.data > key) {
                // This node could be the successor (as it's larger than the key)
                suc[0] = root;
                root = root.left; // Move to the left subtree to find a closer successor
            } else {
                // If the node is the key itself, check its left and right subtrees

                // Find the predecessor (rightmost node of the left subtree)
                if (root.left != null) {
                    Node temp = root.left;
                    while (temp.right != null) {
                        temp = temp.right;
                    }
                    pre[0] = temp; // The predecessor is the rightmost node in the left subtree
                }

                // Find the successor (leftmost node of the right subtree)
                if (root.right != null) {
                    Node temp = root.right;
                    while (temp.left != null) {
                        temp = temp.left;
                    }
                    suc[0] = temp; // The successor is the leftmost node in the right subtree
                }
                break; // Key found, no need to traverse further
            }
        }
    }
}