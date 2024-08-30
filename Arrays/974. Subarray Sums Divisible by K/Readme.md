### Problem: Subarray Sums Divisible by K

**LeetCode Problem Link:** [Subarray Sums Divisible by K](https://leetcode.com/problems/subarray-sums-divisible-by-k/)

#### Intuition

The problem requires us to find the number of subarrays whose sum is divisible by a given number `k`. A subarray is a continuous part of an array. The key insight is that if two subarrays have the same remainder when their sums are divided by `k`, the difference between their sums is divisible by `k`. This can be used to efficiently count how many subarrays meet the requirement.

#### Approach

1. **Prefix Sum:** 
   - First, calculate a running sum of the elements in the array (also called a prefix sum). The prefix sum up to a certain index represents the sum of all elements from the start of the array to that index.

2. **Remainder Handling:**
   - For each prefix sum, calculate its remainder when divided by `k`. 
   - If this remainder has been seen before (in a map or dictionary), it means there is a subarray whose sum is divisible by `k`. The count of how many times this remainder has appeared before tells us how many such subarrays exist.

3. **Handling Negative Remainders:**
   - If the remainder is negative, adjust it by adding `k` to make it positive.

4. **Counting Subarrays:**
   - Keep track of how many times each remainder has appeared using a map (or dictionary).
   - For each new remainder, check if it has appeared before. If yes, add the count of this remainder to the result, as each occurrence corresponds to a valid subarray.

5. **Initialization:**
   - Initialize the map with the remainder `0` having a count of `1`. This is important because if a subarray from the start has a sum divisible by `k`, it should be counted.

#### Complexity

- **Time Complexity:** 
  - The algorithm involves a single pass through the array, and each operation (including map lookups and updates) is `O(1)`. Thus, the time complexity is `O(n)` where `n` is the length of the array.

- **Space Complexity:**
  - The space complexity is `O(min(n, k))`, where `n` is the number of elements in the array. The space is used to store the remainders in a map.

#### Code

```java
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int c = 0;
        
        // Initialize with 0 remainder case (important for counting subarrays that start from index 0)
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = sum % k;

            // Handle negative remainders
            if (rem < 0) rem += k;

            // Check if this remainder has been seen before
            if (map.containsKey(rem)) {
                c += map.get(rem);  // Add the count of this remainder to the result
            }
            
            // Update the map with the current remainder's count
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        return c;
    }
}