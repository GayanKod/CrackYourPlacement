# Check whether BST contains Dead End

## Problem
Given a Binary Search Tree (BST), check if the tree contains a **dead end** or not. A dead end occurs when no further nodes can be inserted. For example, if a node's valid value range becomes restricted to a single value, no more nodes can be added, making it a dead end.

## Intuition
In a Binary Search Tree, each node has a specific range of values that can be inserted into its left and right subtrees:
- For a left child, the valid range is between `minLimit` and `node.val - 1`.
- For a right child, the valid range is between `node.val + 1` and `maxLimit`.

If at any point, the range of values for a node reduces to a single number, we cannot insert any more values at this point. This signifies a dead end.

## Approach

1. **Track Valid Ranges**: We maintain valid ranges of values that can be inserted for every node. The range starts from `(1, ∞)` because values in the tree must be at least 1.

2. **Recursive Traversal**: As we traverse the BST, we update the valid range for each node's left and right children.
   - The left subtree has a valid range from `minLimit` to `node.val - 1`.
   - The right subtree has a valid range from `node.val + 1` to `maxLimit`.

3. **Check for Dead End**: If at any node, the valid range becomes such that `minLimit == maxLimit`, the node is a dead end. We stop further recursion when this condition is met and return `true`.

4. **Base Case**: If a node is `null`, we return `false` since an empty subtree does not have a dead end.

## Complexity

### Time Complexity:
- **O(n)**, where `n` is the number of nodes in the tree. This is because we visit each node once during the recursive traversal.

### Space Complexity:
- **O(h)**, where `h` is the height of the tree. This space is used by the recursion stack. In the worst case, the tree can be skewed, leading to a height of `O(n)`.

## Code

```java
class Solution {
    public static boolean isDeadEnd(Node root) {
        // We start checking from the root with an initial valid range (1, infinity)
        return checkDeadEnd(root, 1, Integer.MAX_VALUE);
    }
    
    // Helper function to recursively check for dead ends
    private static boolean checkDeadEnd(Node node, int minLimit, int maxLimit) {
        // Base case: If node is null, return false (no dead end in this path)
        if (node == null) {
            return false;
        }
        
        // If the current node's range has only one value left, it's a dead end
        if (minLimit == maxLimit) {
            return true;
        }
        
        // Recursively check the left and right subtrees
        // Left subtree: Values less than node's value, update the max limit
        // Right subtree: Values greater than node's value, update the min limit
        return checkDeadEnd(node.left, minLimit, node.data - 1) ||
               checkDeadEnd(node.right, node.data + 1, maxLimit);
    }
}