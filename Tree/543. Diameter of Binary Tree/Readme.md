# 543 Diameter of Binary Tree

[Go to the problem on Leetcode](https://leetcode.com/problems/diameter-of-binary-tree/)

## Intuition

The diameter of a binary tree is the length of the longest path between any two nodes in the tree. This path may or may not pass through the root of the tree. To find this path, we need to consider the height (or depth) of the left and right subtrees of every node, because the longest path will always be the sum of the heights of two child nodes plus one.

## Approach

1. **Define a Recursive Function:**
   - We define a recursive function `height()` to calculate the height of each node. The height of a node is defined as the number of edges on the longest path from that node to a leaf.

2. **Base Case:**
   - If the node is `null` (meaning there's no tree), the height is `0` because there are no edges.

3. **Calculate Heights of Left and Right Subtrees:**
   - Recursively calculate the height of the left subtree (`leftH`) and the height of the right subtree (`rightH`).

4. **Update the Diameter:**
   - The diameter of the tree at this node can be updated as the sum of the heights of the left and right subtrees. If this value is greater than the current maximum diameter, update it.

5. **Return the Height:**
   - The function then returns the height of the tree rooted at the current node, which is `1` (for the current node) plus the maximum height of the left or right subtree.

6. **Final Diameter:**
   - The main function `diameterOfBinaryTree()` initializes the diameter as an array of size `1` (to hold the maximum diameter found during the recursion) and calls the `height()` function to start the process from the root of the tree. Finally, it returns the calculated diameter.

## Complexity

### Time Complexity:
- **O(n)**: The function visits every node in the tree exactly once, where `n` is the number of nodes in the tree. Therefore, the time complexity is linear.

### Space Complexity:
- **O(h)**: The space complexity is determined by the height of the tree `h`, due to the recursive calls that are stored in the function call stack. In the worst case, when the tree is completely unbalanced (like a linked list), the height is `n`, making the space complexity O(n). In the best case, when the tree is balanced, the height is `log(n)`.

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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];  // Array to store the maximum diameter
        height(root, diameter);       // Calculate height and update diameter
        return diameter[0];           // Return the maximum diameter
    }

    public int height(TreeNode node, int[] diameter) {
        if (node == null) return 0;   // Base case: if no node, height is 0

        int leftH = height(node.left, diameter);   // Height of left subtree
        int rightH = height(node.right, diameter); // Height of right subtree

        diameter[0] = Math.max(diameter[0], leftH + rightH);  // Update diameter

        return 1 + Math.max(leftH, rightH);  // Return the height of the current node
    }
}