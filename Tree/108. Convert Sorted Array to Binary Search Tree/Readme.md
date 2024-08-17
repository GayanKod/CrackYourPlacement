# 108. Convert Sorted Array to Binary Search Tree

**Problem Link:** [Convert Sorted Array to Binary Search Tree](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/)

## Intuition

The problem asks to convert a sorted array into a height-balanced Binary Search Tree (BST). In a BST, for any node, all elements in its left subtree are smaller, and all elements in its right subtree are larger. A height-balanced BST is one where the depths of the two subtrees of every node never differ by more than one.

Since the array is sorted, the best way to create a balanced BST is to use the middle element as the root. The elements to the left of this middle element will form the left subtree, and the elements to the right will form the right subtree. By choosing the middle element recursively, we ensure the BST remains balanced.

## Approach

1. **Choose the Middle Element as the Root**:
   - Select the middle element of the array as the root node. This divides the array into two parts.

2. **Recursive Division**:
   - Recursively apply the same logic to the left half of the array to build the left subtree.
   - Recursively apply the same logic to the right half of the array to build the right subtree.

3. **Base Case**:
   - The recursion stops when the `left` index exceeds the `right` index, which means there are no elements left to process. In this case, return `null`.

4. **Construct the Tree**:
   - The nodes are combined by linking the left and right subtrees to the root node.

## Complexity

- **Time Complexity**: `O(n)`
  - The function processes each element of the array exactly once. Therefore, the time complexity is linear.

- **Space Complexity**: `O(log n)`
  - The space complexity is logarithmic due to the recursion stack depth, which in the worst case (when the tree is perfectly balanced) is `log n`.

## Code

```java
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // Choose the middle element as the root
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);

        // Recursively build the left and right subtrees
        node.left = buildBST(nums, left, mid - 1);
        node.right = buildBST(nums, mid + 1, right);

        return node;
    }
}