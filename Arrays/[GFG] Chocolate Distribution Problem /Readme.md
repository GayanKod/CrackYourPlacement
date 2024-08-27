# **Chocolate Distribution Problem**

## **Problem Statement**

Given an array `a` of `n` integers where each element represents the number of chocolates in a packet, the goal is to distribute exactly `m` packets such that the difference between the maximum number of chocolates in the chosen `m` packets and the minimum number of chocolates in the chosen `m` packets is minimized.

## **Intuition**

The problem is about finding a way to distribute `m` packets of chocolates to children such that the difference between the packet with the most chocolates and the packet with the fewest chocolates is as small as possible. If we sort the array first, the packets with the smallest difference will be close to each other in the sorted list.

## **Approach**

1. **Sort the Array**:
   - First, sort the array `a`. Sorting helps in grouping chocolates that are close in quantity together, making it easier to find the minimum difference.

2. **Sliding Window**:
   - Initialize two pointers `i` and `j`. The pointer `i` starts at the beginning of the array and `j` starts at `m-1` (since we are considering a subarray of length `m`).
   - Compute the difference between the elements at `j` and `i` (i.e., `a[j] - a[i]`), which gives the difference between the maximum and minimum chocolates in this subarray.
   - Keep track of the minimum difference found.
   - Move both pointers one step to the right and repeat the process until the end of the array is reached.

3. **Return the Minimum Difference**:
   - After examining all possible subarrays of length `m`, the minimum difference is returned.

## **Complexity**

- **Time Complexity:** `O(n log n)`, where `n` is the number of packets. Sorting the array takes `O(n log n)`, and the sliding window approach to find the minimum difference takes `O(n)`.

- **Space Complexity:** `O(1)`, as we are not using any additional space that grows with the input size except for a few variables.

## **Code**

```cpp
#include <algorithm>
#include <vector>
#include <climits>

class Solution {
public:
    long long findMinDiff(std::vector<long long> a, long long n, long long m) {
        // Sort the array
        std::sort(a.begin(), a.end());
        
        // Initialize the minimum difference to a large value
        long long int minimum = LLONG_MAX;
        
        // Use sliding window to find the minimum difference
        int i = 0;
        int j = m - 1;
        while (j < n) {
            // Calculate the difference between the max and min in this subarray
            long long int diff = a[j] - a[i];
            // Update the minimum difference if a smaller one is found
            minimum = std::min(minimum, diff);
            i++;
            j++;
        }
        
        return minimum;
    }
};