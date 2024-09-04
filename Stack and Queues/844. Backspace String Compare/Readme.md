Sure! Here's a markdown description for your code solution:
# 844. Backspace String Compare

[Go to the Problem on Leetcode](https://leetcode.com/problems/backspace-string-compare/)

## Intuition
The problem asks us to compare two strings, `s` and `t`, to see if they are equal after processing all the backspaces (`#`). A backspace means that the previous character (if any) should be deleted. The key idea is to simulate this process for both strings and then compare the final results.

## Approach
1. **Simulating the Backspace Operation**: 
   - We define a helper function `write`, which processes a string by iterating through each character.
   - If we encounter a `#`, we remove the last character in the result (if there is one).
   - If the character is not `#`, we simply add it to the result.
   - This simulates the effect of backspaces as we build the final processed string.

2. **Comparing the Final Strings**: 
   - After processing both strings `s` and `t` using the `write` function, we compare the resulting strings.
   - If the processed versions of `s` and `t` are the same, the function returns `true`; otherwise, it returns `false`.

## Complexity
- **Time complexity**: 
  - The time complexity is `O(n + m)`, where `n` is the length of `s` and `m` is the length of `t`. This is because we process each string once.
  
- **Space complexity**: 
  - The space complexity is `O(n + m)` as we may need to store the processed versions of both `s` and `t` in memory.

## Code
```java
class Solution {
    public boolean backspaceCompare(String s, String t) {
        
        s = write(s);
        t = write(t);

        return s.equals(t);
    }

    String write(String s) {
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (result.length() > 0) {
                    // Remove the last character from the result
                    result.deleteCharAt(result.length() - 1);
                }
            } else {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }
}
```

## Explanation with Example
Suppose `s = "ab#c"` and `t = "ad#c"`. 

- For string `s`:
  - `a` is added.
  - `b` is added.
  - `#` removes `b`.
  - `c` is added.
  - Final processed string: `"ac"`.

- For string `t`:
  - `a` is added.
  - `d` is added.
  - `#` removes `d`.
  - `c` is added.
  - Final processed string: `"ac"`.

Since both processed strings are equal, the function will return `true`.

---