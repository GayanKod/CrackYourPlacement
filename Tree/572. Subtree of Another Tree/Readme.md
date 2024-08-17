# **572. Subtree of Another Tree**

[Go to the problem on Leetcode](https://leetcode.com/problems/subtree-of-another-tree)

**Problem:**  
Given two non-empty binary trees `root` and `subRoot`, determine if `subRoot` is a subtree of `root`. A subtree of a binary tree `root` is a tree consisting of a node in `root` and all of this node's descendants. The tree `root` could also be considered a subtree of itself.

---

## **Intuition**

The problem asks if one tree is a subtree of another. A subtree means that there's a node in the main tree (`root`) where a subtree starts, and this subtree is exactly the same as the given tree (`subRoot`).

To solve this, we need to traverse the main tree (`root`) and at each node, check if the tree rooted at that node is identical to `subRoot`. If we find such a node where the subtree matches `subRoot`, we can return `true`. If we traverse the entire tree and find no such match, we return `false`.

---

## **Approach**

1. **Base Case:** 
   - If the `root` is `null`, `subRoot` cannot be a subtree of `root`, so we return `false`.

2. **Check for Subtree:**
   - If the value of the current node in `root` matches the value of `subRoot`, we call a helper function `isEqual` to check if the trees rooted at this node in `root` and `subRoot` are identical.

3. **Recursion:**
   - If the current node does not match or the trees are not identical, we recursively check the left and right children of `root` to see if `subRoot` is a subtree of either.

4. **Helper Function (`isEqual`):**
   - This function checks if two trees are identical. It compares the root values and then recursively checks the left and right children. If both trees match in structure and node values, `isEqual` returns `true`.

---

## **Complexity**

- **Time Complexity:**
  - The worst-case scenario occurs when we compare every node in the main tree with the subtree. For each node in `root`, we may potentially compare the entire `subRoot`.
  - This results in a time complexity of **O(N * M)**, where `N` is the number of nodes in `root` and `M` is the number of nodes in `subRoot`.

- **Space Complexity:**
  - The space complexity is **O(H)**, where `H` is the height of the main tree (`root`). This is because of the recursive stack used when traversing the tree.

---

## **Code**

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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }

        if (root.val == subRoot.val) {
            boolean found = isEqual(root, subRoot);
            if (found) {
                return true;
            }
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isEqual(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }

        boolean isEqual = isEqual(node1.left, node2.left);
        if (!isEqual) {
            return false;
        }
        return isEqual(node1.right, node2.right);
    }
}
```

### Code Explanation

The code consists of two main parts:
1. **isSubtree Method:** This checks if subRoot is a subtree of root.
2. **isEqual Method:** This checks if two trees are identical.

#### isSubtree Method

```java
public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    if (root == null) {
        return false;
    }

    if (root.val == subRoot.val) {
        boolean found = isEqual(root, subRoot);
        if (found) {
            return true;
        }
    }

    return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
}
```
- `if (root == null) { return false; }`:
  This checks if `root` is `null`. If it is, it means there’s no tree left to search, so `subRoot` can’t be a subtree, and we return `false`.

- `if (root.val == subRoot.val)`:
  This checks if the current node in `root` has the same value as the root node of `subRoot`. If they are the same, there is a possibility that `subRoot` could be a subtree starting from this node.

- `boolean found = isEqual(root, subRoot);`:
  If the values match, the code then calls the `isEqual` method to check if the tree rooted at this node (root) is identical to `subRoot`.

- `if (found) { return true; }`:
  If the trees are identical (`isEqual` returns `true`), then we have found the subtree, so we return `true`.

- `return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);`:
  If the current node doesn’t match or the trees are not identical, the code recursively checks the left and right children of root to see if `subRoot` is a subtree of either.
