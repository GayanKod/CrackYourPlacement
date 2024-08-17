## 442. Find All Duplicates in an Array

[Go to the problem on Leetcode](https://leetcode.com/problems/find-all-duplicates-in-an-array)

### Intuition

To find duplicates in an array where each number ranges from `1` to `n` (the length of the array), we can leverage the fact that numbers in this range can be used as indices in the array itself. By marking indices as negative when we encounter a number, we can identify duplicates when we encounter a negative value at a previously visited index.

### Approach

1. **Use the Array Itself for Marking**:
   - Iterate through the array and use the absolute value of each number to index into the array.
   - If the number at the indexed position is negative, it means the number corresponding to this index has been seen before, indicating a duplicate.
   - If the number at the indexed position is positive, make it negative to mark that the number has been seen.

2. **Add Duplicates to Result List**:
   - If an index is already marked negative, add the absolute value of the current number to the result list.

### Complexity

- **Time Complexity**: `O(n)`
  - Each element is processed exactly once during the iteration through the array. Operations such as marking and checking the sign of an element are `O(1)`.

- **Space Complexity**: `O(1)`
  - We only use a constant amount of extra space (excluding the result list). The input array is modified in place to track seen numbers.

### Code

```java
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> out = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {                     
            if (nums[Math.abs(nums[i]) - 1] < 0) {
                out.add(Math.abs(nums[i]));
            } else if (nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] = nums[Math.abs(nums[i]) - 1] * -1;
            }  
        }

        return out;
    }
}