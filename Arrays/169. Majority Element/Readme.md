# 169. Majority Element

[Go to the problem on Leetcode](https://leetcode.com/problems/majority-element/)

### Intuition

The problem asks us to find the "majority element" in an array, which is defined as an element that appears more than `n/2` times in the array, where `n` is the size of the array. The key insight is that if such an element exists, it will dominate the array in terms of frequency. The Boyer-Moore Voting Algorithm is an efficient way to find this element by making a single pass through the array and using constant space.

### Approach

1. **Candidate Selection**:
   - Start by assuming the first element as the potential "candidate" for the majority element. 
   - Initialize a `count` to 0.

2. **Vote Counting**:
   - Traverse the array. For each element:
     - If `count` is 0, update the `candidate` to the current element.
     - If the current element matches the `candidate`, increase `count` by 1.
     - If it does not match, decrease `count` by 1.
   - The idea is that the count increases when we see the candidate and decreases when we see different elements. If the candidate is the majority element, it will end up as the candidate when the array is fully processed.

3. **Result**:
   - After one pass through the array, the `candidate` will hold the majority element because the majority element will not be fully canceled out by other elements.

### Complexity

- **Time Complexity**: `O(n)`
  - The algorithm only requires a single pass through the array to determine the majority element, making it linear in time complexity.
  
- **Space Complexity**: `O(1)`
  - The algorithm uses a constant amount of extra space (`candidate` and `count` variables), so the space complexity is constant.

### Code

```java
class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}