# 20 Valid Parentheses

[Go to the problem on Leetcode](https://leetcode.com/problems/valid-parentheses/)

### Intuition
When working with parentheses, braces, or brackets in a string, each opening symbol (`(`, `{`, `[`) must have a corresponding closing symbol (`)`, `}`, `]`) in the correct order. This problem is about determining if a given string of symbols is "valid," meaning every opening symbol is properly closed and nested.

### Approach
1. **Using a Stack**:
   - A stack is a data structure that works on the principle of "Last In, First Out" (LIFO). This means that the last item added is the first one to be removed, making it ideal for this problem.
   
2. **Process Each Character**:
   - Convert the string into an array of characters and process each one.
   - If the character is an opening symbol (`(`, `{`, `[`), push the corresponding closing symbol onto the stack. This ensures that we know which symbol we expect to match later.
   - If the character is a closing symbol (`)`, `}`, `]`), check if it matches the top symbol in the stack:
     - If the stack is empty (meaning no opening symbol to match with), or if the top symbol doesn’t match, the string is not valid, so return `false`.
     - If it matches, pop the top symbol off the stack (remove it).
   
3. **Final Check**:
   - After processing all characters, the stack should be empty if all opening symbols were properly matched and closed.
   - If the stack is not empty, it means there are unmatched opening symbols left, so return `false`.

### Complexity
- **Time complexity**: `O(N)`  
  The algorithm processes each character in the string once, so the time complexity is linear relative to the length of the string.
  
- **Space complexity**: `O(N)`  
  In the worst case, all opening symbols are added to the stack, so the space complexity is also linear.

### Code

```csharp
public class Solution {
    public bool IsValid(string s) {
        // Create a new empty stack
        Stack<char> stack = new Stack<char>();

        foreach (char c in s.ToCharArray()){
            if (c == '(')
                stack.Push(')');
            else if (c == '[')
                stack.Push(']');
            else if (c == '{')
                stack.Push('}');
            else if (stack.Count == 0 || stack.Pop() != c)
                return false;
            // If the stack is empty or the top of the stack doesn't match the closing symbol, return false
        }
        return stack.Count == 0;
        // Return true if the stack is empty (all symbols were matched), otherwise return false
    }
}