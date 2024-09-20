# 493. Reverse Pairs Problem Explanation

[Go to Problem on Leetcode](https://leetcode.com/problems/reverse-pairs/)

## Problem
We are given an array of integers `nums`. We want to find the number of **reverse pairs**. A reverse pair is when an index `i` is smaller than `j` (`i < j`), but the value at index `i` is more than **twice** the value at index `j`, i.e., `nums[i] > 2 * nums[j]`.

---

## Intuition
The problem is about finding pairs in the array where one number is more than double the other. Instead of checking every possible pair (which would take a long time), we can use a more efficient approach by sorting the array while counting these special pairs. The idea is similar to **merge sort**, a well-known algorithm for sorting that also allows us to compare elements efficiently.

---

## Approach
1. **Divide and Conquer**:
   - We use a technique called **merge sort**, which breaks the array into smaller parts, sorts them, and then merges them back together.
   - As we divide the array into smaller parts, we can also count how many reverse pairs exist by comparing elements from two halves of the array.

2. **Counting Reverse Pairs**:
   - After dividing the array, when we merge two sorted halves back together, we check how many elements in the left half of the array are more than double the elements in the right half.
   - For each element `i` in the left part, we count how many elements `j` in the right part satisfy `nums[i] > 2 * nums[j]`.

3. **Merge Two Halves**:
   - Once the reverse pairs are counted, we merge the two halves back into one sorted array, just like in the standard merge sort.

---

## Complexity

### Time Complexity:
- The time complexity of this approach is **O(n log n)**, where `n` is the number of elements in the array. This is because we are using a divide-and-conquer approach (merge sort) that splits the array into halves repeatedly (log n times), and each time, it processes the entire array (n elements).

### Space Complexity:
- The space complexity is **O(n)** because we are using a temporary array to store sorted elements during the merge step.

---

## Code

```java
class Solution {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0; // If the array has less than 2 elements, no pairs can be found.
        }
        
        // Use the helper function to apply merge sort and count reverse pairs.
        return mergeSortAndCount(nums, 0, nums.length - 1);
    }
    
    // Helper function that recursively sorts and counts reverse pairs.
    private int mergeSortAndCount(int[] nums, int start, int end) {
        if (start >= end) {
            return 0; // Base case: When there's only one element or no element, no pairs exist.
        }
        
        int mid = (start + end) / 2; // Find the middle point of the array.
        int count = mergeSortAndCount(nums, start, mid) // Sort and count for the left half.
                     + mergeSortAndCount(nums, mid + 1, end); // Sort and count for the right half.
        
        // Now, count the reverse pairs where one element is in the left half and one is in the right half.
        int j = mid + 1;
        for (int i = start; i <= mid; i++) {
            while (j <= end && nums[i] > 2L * nums[j]) {
                j++; // Find how many elements in the right half satisfy nums[i] > 2 * nums[j].
            }
            count += (j - (mid + 1)); // Add the number of valid j's for each i.
        }
        
        // Merge the two halves back together in sorted order.
        int[] temp = new int[end - start + 1];
        int left = start, right = mid + 1, k = 0;
        
        // Merge the two sorted halves into the temp array.
        while (left <= mid && right <= end) {
            if (nums[left] <= nums[right]) {
                temp[k++] = nums[left++];
            } else {
                temp[k++] = nums[right++];
            }
        }
        
        // Copy any remaining elements from the left half.
        while (left <= mid) {
            temp[k++] = nums[left++];
        }
        
        // Copy any remaining elements from the right half.
        while (right <= end) {
            temp[k++] = nums[right++];
        }
        
        // Copy the sorted elements back into the original array.
        for (int i = 0; i < temp.length; i++) {
            nums[start + i] = temp[i];
        }
        
        return count; // Return the total count of reverse pairs.
    }
}