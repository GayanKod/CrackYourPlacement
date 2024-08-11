# 628. Maximum Product of Three Numbers

[Go to the problem on Leetcode](https://leetcode.com/problems/maximum-product-of-three-numbers)

### Intuition
To find the maximum product of three numbers in an array, there are two main scenarios to consider:
1. The product of the three largest positive numbers in the array.
2. The product of the two smallest (most negative) numbers and the largest positive number. This can yield a large positive product when multiplied together.

### Approach
1. **Edge Case:** If the array contains exactly three numbers, simply return the product of these three numbers.
2. **General Case:** 
   - Sort the array to easily identify the largest and smallest values.
   - Calculate two possible products:
     1. The product of the three largest numbers (last three elements in the sorted array).
     2. The product of the two smallest numbers (first two elements in the sorted array) and the largest number (last element in the sorted array).
   - Compare these two products and return the maximum.

### Complexity
- **Time complexity:** `O(N log N)`  
  Sorting the array is the most time-consuming operation in this approach.
- **Space complexity:** `O(1)`  
  No additional space is required other than the input array.

### Code

```csharp
public class Solution {
    public int MaximumProduct(int[] nums) {
        if (nums.Length == 3) {
            return nums[0] * nums[1] * nums[2];
        } else {
            int n = nums.Length;
            Array.Sort(nums);
            int m1 = nums[n - 1] * nums[n - 2] * nums[n - 3];
            int m2 = nums[0] * nums[1] * nums[n - 1]; // If you can produce a max positive number, that would be two negative numbers and the maximum positive number.
            if (m1 > m2) {
                return m1;
            } else {
                return m2;
            }
        }
    }
}

![Submission](./image.png)