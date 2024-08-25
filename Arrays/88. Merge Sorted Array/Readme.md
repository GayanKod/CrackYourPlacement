# 88. Merging Two Sorted Arrays

[Go to the problem on Leetcode](https://leetcode.com/problems/merge-sorted-array/)

## Intuition

Imagine you have two lists of numbers, and both lists are already sorted. Your job is to combine these two lists into one big list, while keeping everything in order. The trick is to do this efficiently, without using any extra space, and directly in one of the lists.

## Approach

To merge the two lists:

- Start by looking at the biggest numbers in both lists.
- Compare these two numbers and place the bigger one at the very end of the combined list.
- Move backwards through the lists, repeating this process, so that you’re always placing the next biggest number in the correct position.
- If one list runs out of numbers before the other, just copy the remaining numbers from the second list into the combined list.

By working from the back of the list to the front, we avoid overwriting any of the important numbers that we haven’t yet moved.

## Complexity

### Time complexity:
The time it takes to merge the two lists is proportional to the total number of elements in both lists. Specifically, it takes **O(m + n)** time, where `m` is the number of elements in the first list and `n` is the number of elements in the second list. This is because we are processing each element once.

### Space complexity:
The method uses constant space, **O(1)**, because it doesn’t require any additional space beyond the input arrays. The merging is done directly within the first list, `nums1`.

## Code

```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; // Pointer for the last valid element in nums1
        int j = n - 1; // Pointer for the last element in nums2
        int k = m + n - 1; // Pointer for the last position in nums1

        // Start merging from the end
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        // If there are remaining elements in nums2, copy them
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}