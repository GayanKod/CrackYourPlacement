# 75. Sort Colors

[Go to the problem on Leetcode](https://leetcode.com/problems/sort-colors/)

## Problem Description
Given an array `nums` with `n` objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue. We will use the integers `0`, `1`, and `2` to represent the colors red, white, and blue, respectively.

## Intuition
The problem can be solved efficiently by utilizing a three-pointer approach. The idea is to partition the array into three sections:
- The leftmost section contains only `0`s (red).
- The middle section contains only `1`s (white).
- The rightmost section contains only `2`s (blue).

By carefully swapping elements and moving pointers, we can sort the array in a single pass.

## Approach
1. **Initialization:**
   - We use three pointers: `start`, `middle`, and `end`.
   - `start` is the boundary for the `0`s (red) section.
   - `end` is the boundary for the `2`s (blue) section.
   - `middle` is used to traverse through the array.

2. **Traversing the Array:**
   - We start with `start = 0`, `middle = 0`, and `end = nums.length - 1`.
   - As we traverse the array using `middle`, we check the value at `nums[middle]`:
     - If it's `0`, we swap it with the value at `start`, move both `start` and `middle` pointers forward.
     - If it's `1`, we simply move the `middle` pointer forward, as `1`s should be in the middle.
     - If it's `2`, we swap it with the value at `end`, and move the `end` pointer backward.

3. **Continue Until Done:**
   - We continue this process until `middle` surpasses `end`. At this point, all elements are sorted with `0`s at the start, `1`s in the middle, and `2`s at the end.

## Complexity
- **Time Complexity:** The algorithm runs in O(n) time since each element is processed at most once.
- **Space Complexity:** The space complexity is O(1) as we are sorting the array in place and only using a few extra variables.

## Code
```java
class Solution {
    public void sortColors(int[] nums) {
        // 3-pointer Solution
        int start = 0;
        int middle = 0;
        int end = nums.length - 1;

        while (middle <= end) {
            if (nums[middle] == 0) {
                swap(start, middle, nums);
                start++;
                middle++;
            } else if (nums[middle] == 1) {
                middle++;
            } else if (nums[middle] == 2) {
                swap(middle, end, nums);
                end--;
            }
        }
    }

    public void swap(int one, int two, int[] nums) {
        int t = nums[one];
        nums[one] = nums[two];
        nums[two] = t;
    }
}