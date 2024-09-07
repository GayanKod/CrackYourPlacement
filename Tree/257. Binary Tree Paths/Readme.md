# 257. Binary Tree Paths

[Go to the problem on Leetcode](https://leetcode.com/problems/binary-tree-paths/)

## Intuition

The task is to find all the paths from the root of a binary tree to each leaf node. A leaf node is defined as a node that has no children (both left and right child nodes are `null`). We need to return these paths as strings, where each path is a sequence of node values connected by the string `"->"`. 

For example, if the tree looks like this:
```
     1
    / \
   2   3
    \
     5
```
The paths from root to leaf would be: `"1->2->5"` and `"1->3"`.

## Approach

1. **Start from the root** and initialize an empty string to store the current path.
2. Traverse the tree recursively:
    - For each node, append the node's value to the current path.
    - If the node is a **leaf** (i.e., it has no left or right children), add the current path to the list of paths.
    - If the node is **not a leaf**, append `"->"` to the path and continue traversing its left and right children.
3. Once all leaf nodes are reached, the list will contain all the root-to-leaf paths.

## Complexity

### Time Complexity:
- In the worst case, we visit every node of the tree exactly once. So, the time complexity is **O(N)**, where **N** is the number of nodes in the tree.

### Space Complexity:
- The space complexity depends on the depth of the recursion, which is proportional to the height of the tree. In the worst case (when the tree is skewed), the space complexity will be **O(N)** due to the recursion stack. In the best case (for a balanced tree), the space complexity will be **O(log N)**.

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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<String>();
        // Edge case: if root is null, return an empty list
        if (root == null) return list;
        // Call helper method to start collecting paths
        getPath(root, "", list);
        return list;
    }

    public void getPath(TreeNode node, String path, List<String> list) {
        if (node == null) return;

        // Append current node value to the path
        path += node.val;

        // If it's a leaf node, add the path to the list
        if (node.left == null && node.right == null) {
            list.add(path);
        } else {
            // If not a leaf, continue the path with "->" separator
            path += "->";
            // Recursively traverse left and right subtrees
            if (node.left != null) getPath(node.left, path, list);
            if (node.right != null) getPath(node.right, path, list);
        }
    }
}
```

---