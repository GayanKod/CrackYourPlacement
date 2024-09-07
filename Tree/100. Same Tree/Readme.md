# 100. Same Tree - LeetCode Problem 

[Go to the problem on Leetcode](https://leetcode.com/problems/same-tree/)

## Intuition

The problem asks us to determine if two binary trees are identical. Two binary trees are considered the same if they:
1. Have the same structure.
2. Have nodes with the same values at each corresponding position.

If any of the nodes or structures are different, the trees are not the same.

## Approach

1. Start at the roots of both trees.
   - If both roots are `null`, then they are the same (base case for recursion).
   - If one root is `null` and the other is not, or if their values are different, then the trees are not the same.
2. Recursively compare the left subtrees of both trees.
3. Recursively compare the right subtrees of both trees.
4. If both left and right subtrees are identical, then the entire trees are identical.

We use a depth-first search (DFS) approach where we go deep into the tree, comparing each node.

## Complexity

### Time Complexity:
- **O(N)**, where N is the total number of nodes in the trees. In the worst case, we have to visit every node to confirm whether the trees are the same.

### Space Complexity:
- **O(H)**, where H is the height of the tree. The space is required for the recursion stack. In the worst case (a completely unbalanced tree), the height could be N, making the space complexity O(N). In the best case (a balanced tree), the height is log(N), making the space complexity O(log N).

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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // If both nodes are null, the trees are the same
        if (p == null && q == null) return true;

        // If one is null or values are different, return false
        if (p == null || q == null || p.val != q.val) return false;

        // Recursively compare left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
```

## Explanation:
1. **Base cases:**
   - If both `p` and `q` are `null`, return `true` because both trees are empty.
   - If one is `null` and the other isn’t, or if their values don’t match, return `false`.
   
2. **Recursive checks:**
   - Call the `isSameTree` function on the left children of both `p` and `q`.
   - Call the `isSameTree` function on the right children of both `p` and `q`.

If all recursive calls return `true`, the trees are the same. Otherwise, they are different.

---