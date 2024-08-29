## 168. Excel Sheet Column Title

[Go to the problem on Leetcode](https://leetcode.com/problems/excel-sheet-column-title/)

Given a positive integer, you need to convert it to its corresponding column title as it appears in an Excel sheet.

For example:
- 1 -> A
- 2 -> B
- 3 -> C
- ...
- 26 -> Z
- 27 -> AA
- 28 -> AB

---

### Intuition

When thinking about Excel column titles, we can imagine them as a number system, much like the decimal system we use every day, but instead of being base-10 (using digits 0-9), it's base-26 (using letters A-Z). The problem is similar to converting a number from decimal to any other base.

Each letter in the title corresponds to a position in this base-26 system. The key difference from typical number systems is that it doesn't have a zero; instead, it starts from 1 (A=1, B=2, ..., Z=26).

### Approach

1. **Find the Last Character**: 
   - To determine the last character of the title, take the remainder when the number is divided by 26. 
   - Subtract 1 from the column number first to handle the fact that there's no zero in this system (e.g., 1 maps to A, not 0).
   - Convert this remainder to the corresponding letter by adding it to 'A'.
   - Append this letter to the result.

2. **Reduce the Number**: 
   - Divide the column number by 26 (after adjusting it with the subtraction).
   - Continue this process until the number is reduced to zero.

3. **Build the Result**: 
   - Since each new letter is calculated from the least significant to the most significant, prepend each letter to the result.

### Complexity

**Time Complexity**: 
- The number of operations depends on how many times we can divide the number by 26. This is proportional to the logarithm of the number, specifically `O(log26(columnNumber))`. For large numbers, this is efficient.

**Space Complexity**: 
- The space required to store the output string is proportional to the length of the title, which also depends on `O(log26(columnNumber))`. The additional space for variables is minimal, so the overall space complexity is `O(1)` if we don't consider the output string.

### Code

```java
class Solution {
    public String convertToTitle(int columnNumber) {
        
        StringBuilder output = new StringBuilder();

        while (columnNumber > 0){
            int index = (columnNumber - 1) % 26;
            output.insert(0, (char)('A' + index));
            columnNumber = (columnNumber - 1) / 26;
        }

        return output.toString();

    }
}