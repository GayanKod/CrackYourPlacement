# 560. Subarray Sum Equals K

[Go to the problem on Leetcode](https://leetcode.com/problems/subarray-sum-equals-k)

The "Subarray Sum Equals K" problem asks you to find the total number of continuous subarrays within a given array `nums` that sum up to a target value `k`.

## Intuition

To solve this problem, we can leverage the concept of prefix sums. A prefix sum is the cumulative sum of elements from the beginning of the array up to a certain index. The key idea is that if the difference between the prefix sum up to two different indices equals `k`, then the subarray between these two indices sums to `k`.

By maintaining a running total of the prefix sums and using a hash map to store the frequency of each prefix sum, we can efficiently count the number of subarrays that sum to `k`.

## Approach

1. **Initialize Variables**:
   - Create a variable `count` to keep track of the number of valid subarrays.
   - Create a variable `presum` to store the running prefix sum.
   - Use a hash map `map` to store the frequency of each prefix sum encountered.

2. **Iterate Through the Array**:
   - For each element in the array, update the `presum` with the current element's value.
   - Calculate `remove = presum - k`. This value represents the prefix sum that, when removed from `presum`, gives the sum `k`.
   - If `remove` exists in the hash map, it means there is a subarray that sums to `k`. Add the frequency of `remove` in the hash map to `count`.
   - Update the hash map to include the current `presum`, incrementing its frequency by 1.

3. **Return the Result**:
   - After processing all elements, return `count`, which contains the total number of subarrays that sum to `k`.

## Complexity

- **Time complexity**:
  - The time complexity is `O(n)`, where `n` is the length of the array. This is because we only make a single pass through the array, performing constant-time operations for each element.

- **Space complexity**:
  - The space complexity is `O(n)` because, in the worst case, the hash map might store all the prefix sums.

## Code

```java
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int presum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // to deal with the cases where presum - k == 0

        for (int i = 0; i < n; i++) {
            presum += nums[i];

            int remove = presum - k; // as we will remove up to this sum to find our desired subarray
            // Look for occurrences of 'remove', because if presum - k exists in the map, it means there's a subarray that sums to k
            count += map.getOrDefault(remove, 0); // if 'remove' is not found, return 0

            // Update the frequency of the current prefix sum in the map
            map.put(presum, map.getOrDefault(presum, 0) + 1);
        }

        return count;
    }
}
```