# 15. 3Sum

[Go to the problem on Leetcode](https://leetcode.com/problems/3sum/)

## Problem Description
Given an integer array `nums`, return all the triplets `[nums[i], nums[j], nums[k]]` such that `i != j`, `i != k`, and `j != k`, and `nums[i] + nums[j] + nums[k] == 0`.

The solution set must not contain duplicate triplets.

## Intuition
The problem asks us to find all unique triplets in the array that sum up to zero. Since it's challenging to directly find such combinations in an unsorted array, we can simplify our task by first sorting the array. Sorting helps in efficiently avoiding duplicate triplets and also allows us to use a two-pointer technique to find the other two numbers that sum to zero for each element.

## Approach
1. **Sort the Array**:  
   - Start by sorting the array. Sorting helps to avoid duplicate triplets later and makes it easier to use the two-pointer technique.

2. **Iterate with a Fixed Element**:  
   - Loop through the array, fixing one element at a time. For each fixed element, the problem reduces to finding two numbers that sum up to the negative of this fixed element.

3. **Two-Pointer Technique**:  
   - For each fixed element, use two pointers (`left` and `right`) to scan the remaining part of the array.
   - The `left` pointer starts just after the fixed element, and the `right` pointer starts at the end of the array.
   - Calculate the sum of the current three elements (`nums[i] + nums[left] + nums[right]`).
   - If the sum equals zero, add the triplet to the result list.
   - If the sum is less than zero, move the `left` pointer to the right to increase the sum.
   - If the sum is greater than zero, move the `right` pointer to the left to decrease the sum.
   - Skip duplicate elements while moving the pointers to ensure that each triplet is unique.

4. **Avoid Duplicates**:
   - Skip duplicate fixed elements to avoid duplicate triplets in the result.
   - Skip duplicate `left` and `right` elements while adding valid triplets to ensure uniqueness.

5. **Continue the Process**:
   - Repeat the process until all possible triplets are considered.

## Complexity

- **Time Complexity**:  
  The time complexity of this solution is O(n^2). The array is sorted in O(n log n) time, and the two-pointer technique runs in O(n^2) as it involves iterating through the array and for each element, scanning the rest of the array using two pointers.

- **Space Complexity**:  
  The space complexity is O(1) excluding the space required for the output, as we are only using a few extra variables for the two pointers and the result list.

## Code

```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);  // Sort the array to make it easier to avoid duplicates

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;  // Skip duplicate elements
            
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;  // Skip duplicates
                    while (left < right && nums[right] == nums[right - 1]) right--;  // Skip duplicates
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return result;
    }
}