## Longest Common Prefix

[Go to the problem on Leetcode](https://leetcode.com/problems/longest-common-prefix)

### Intuition
The problem asks us to find the longest common prefix shared by all the strings in an array. A common prefix is a sequence of characters that appear at the start of every string in the array. For example, in the array `["flower", "flow", "flight"]`, the longest common prefix is `"fl"`.

### Approach
1. **Sort the Array**:
   - Start by sorting the array of strings. Sorting helps by bringing the strings with the smallest differences together, especially the ones with the smallest and largest lexicographical order.
   
2. **Compare First and Last Strings**:
   - After sorting, the first and last strings in the array will have the most and the least common characters in terms of the prefix. This is because sorting arranges them in lexicographical order.
   - Compare characters of the first and last string in the array since they represent the minimum and maximum boundaries of possible common prefixes.
   
3. **Build the Common Prefix**:
   - Use a loop to compare each character of the first and last strings. As long as the characters match, keep adding them to the result.
   - If you encounter a mismatch, stop the comparison. The common prefix up to that point is the longest one.

4. **Return the Result**:
   - The result string will contain the longest common prefix. If there’s no common prefix, the result will be an empty string.

### Complexity
- **Time complexity**: `O(N * log N + M)`  
  - `N * log N` comes from sorting the array of strings, where `N` is the number of strings.
  - `M` is the length of the common prefix and the comparison of the first and last strings.
  
- **Space complexity**: `O(1)`  
  The space complexity is constant because we only use a few extra variables for comparisons and to store the result.

### Code

```csharp
public class Solution {
    public string LongestCommonPrefix(string[] strs) {
        StringBuilder ans = new StringBuilder();
        Array.Sort(strs);
        string first = strs[0];
        string last = strs[strs.Length - 1];

        for (int i = 0; i < Math.Min(first.Length, last.Length); i++) {
            if (first[i] != last[i]) {
                // Stop if characters don't match
                return ans.ToString();
            }
            ans.Append(first[i]);
        }

        return ans.ToString();
    }
}