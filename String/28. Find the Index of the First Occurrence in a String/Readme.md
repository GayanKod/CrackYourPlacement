## 28. Find the Index of the First Occurrence in a String

[Go to the problem on Leetcode](https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/)

### Intuition
The problem asks us to find the first occurrence of a substring (`needle`) within another string (`haystack`). If the `needle` exists in the `haystack`, we should return the index where it first appears. If it doesn't exist, we return `-1`. The idea is to compare each part of the `haystack` with the `needle` until we either find a match or exhaust all possibilities.

### Approach
1. **Initialize Lengths**:
   - Start by determining the lengths of both the `haystack` and `needle`. This helps in controlling our loop and checks.
   
2. **Iterate Through the Haystack**:
   - Use a loop to iterate over the `haystack` character by character.
   - For each character in the `haystack`, compare it with the corresponding character in the `needle`.
   
3. **Character Matching**:
   - If the characters match, move to the next character in the `needle` by incrementing the `needle` index.
   - If the characters don't match, reset the `needle` index and adjust the `haystack` index to start searching from the next position after the previous start.

4. **Check for Complete Match**:
   - If the `needle` index reaches the length of the `needle`, it means we've found a match. In that case, return the starting index of this match.
   
5. **Return -1 if No Match Found**:
   - If we finish the loop without finding the `needle` in the `haystack`, return `-1`.

### Complexity
- **Time complexity**: `O((N - M) * M)`  
  Where `N` is the length of `haystack` and `M` is the length of `needle`. In the worst case, we might compare each character of `needle` with many substrings of `haystack`.
  
- **Space complexity**: `O(1)`  
  The space complexity is constant because the only extra space used is for a few integer variables.

### Code

```csharp
public class Solution {
    public int StrStr(string haystack, string needle) {
        int hLen = haystack.Length;
        int nLen = needle.Length;
        int nIndex = 0;

        for (int i = 0; i < hLen; i++) {
            // As long as the characters are equal, increment needleIndex
            if (haystack[i] == needle[nIndex]) {
                nIndex++;
            } else {
                // Start from the next index after the previous start index
                i = i - nIndex;
                // Needle should start from index 0
                nIndex = 0;
            }

            // Check if needleIndex reached needle length
            if (nIndex == nLen) {
                // Return the first index of the match
                return i - nLen + 1;
            }
        }
        return -1;
    }
}