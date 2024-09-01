# **18. 4Sum**

[Go to the problem on Leetcode](https://leetcode.com/problems/4sum/)

## **Intuition**
The problem asks us to find all unique combinations of four numbers from an array that add up to a given target value. To solve this problem efficiently, we need to explore all possible combinations but in a smart way to avoid unnecessary calculations and duplicates.

The key idea is to use a combination of sorting and the two-pointer technique. Sorting helps us manage and skip duplicates easily, and the two-pointer approach efficiently finds pairs of numbers that sum up to a specific value.

## **Approach**
1. **Sorting the Array**:
   - Begin by sorting the array. Sorting helps in easily managing duplicate elements and applying the two-pointer technique effectively.

2. **Iterating through the Array**:
   - Use two nested loops to fix the first two elements (`nums[i]` and `nums[j]`). This helps in systematically exploring all possible pairs.
   - For each pair of `i` and `j`, use two pointers (`left` and `right`) to find the remaining two numbers that complete the sum to the target.

3. **Two-Pointer Technique**:
   - After fixing `i` and `j`, set `left` to `j + 1` and `right` to `n - 1` (where `n` is the length of the array).
   - Calculate the sum of the four numbers. If the sum equals the target, add the combination to the result list.
   - If the sum is less than the target, move the `left` pointer to the right to increase the sum.
   - If the sum is greater than the target, move the `right` pointer to the left to decrease the sum.

4. **Handling Duplicates**:
   - To ensure the uniqueness of the combinations, skip any duplicate values for the fixed elements (`i` and `j`) and also for the elements pointed by `left` and `right`.

5. **Return the Result**:
   - After iterating through all possible combinations, return the list of unique quadruplets that sum to the target.

## **Complexity**

- **Time Complexity**: `O(n^3)`
  - The time complexity is cubic because we have two nested loops and a two-pointer search within those loops. Sorting the array takes `O(n log n)`, but the overall complexity is dominated by the three nested loops, resulting in `O(n^3)`.

- **Space Complexity**: `O(1)`
  - The space complexity is constant, excluding the space required for the output list. We are using only a few extra variables to track indices and store the sum, so the space used does not scale with the size of the input.

## **Code**

```java
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }
        
        Arrays.sort(nums);  // Sort the array first
        int n = nums.length;
        
        for (int i = 0; i < n - 3; i++) {
            // Skip duplicates for the first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicates for the second element
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                
                int left = j + 1;
                int right = n - 1;
                
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        
                        // Skip duplicates for the third element
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        // Skip duplicates for the fourth element
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        
        return result;
    }
}