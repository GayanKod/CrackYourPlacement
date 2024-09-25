# 22. **Generate Parentheses**

## Problem Description

Given an integer `n`, generate all combinations of well-formed parentheses. Each combination must contain `n` pairs of parentheses.

For example:
- Input: `n = 3`
- Output: `["((()))","(()())","(())()","()(())","()()()"]`

---

## **Intuition**

The problem is about generating all possible valid combinations of parentheses. A valid combination means that:
- Every opening parenthesis `(` has a corresponding closing parenthesis `)`.
- The order must be correct (e.g., you can't close a parenthesis without having opened it first).

We need to explore all possible ways to place the parentheses while ensuring that the combination remains valid.

---

## **Approach**

This is a classic **backtracking** problem where we explore all possibilities. Here’s how we approach it step-by-step:

1. **Backtracking**: We start with an empty string and add parentheses one by one. We add an opening `(` if we haven't reached `n` open parentheses. We add a closing `)` if it wouldn't exceed the number of opening parentheses.
  
2. **Stopping condition**: The base case of the recursion happens when we have added exactly `n` opening and `n` closing parentheses to form a valid combination. At this point, we add the combination to the result list.

3. **Recursive logic**: 
    - If we have fewer than `n` opening parentheses, we add `(`.
    - If we have fewer closing parentheses than opening parentheses, we add `)`.

---

## **Complexity**

- **Time Complexity**: The time complexity is **O(4^n / sqrt(n))**. This is a well-known result for generating all valid parentheses combinations.
- **Space Complexity**: The space complexity is **O(4^n / sqrt(n))** due to the recursion stack and the result list storing all combinations.

---

### **Time complexity:**
O(4^n / sqrt(n)) - The reason behind this complexity is because each valid sequence corresponds to a valid Dyck word of length 2n, which is a Catalan number.

---

### **Space complexity:**
O(4^n / sqrt(n)) - This is the space required to store the result and recursion stack, as the function can go up to `2n` recursive calls deep.

---

## **Code**

```java
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }
    
    // Helper function for backtracking
    private void backtrack(List<String> result, String current, int open, int close, int max) {
        // Base case: If the current string length is 2*n, it's a valid combination
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }
        
        // If we can still add an opening parenthesis, add it
        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }
        
        // If we can add a closing parenthesis (only if it doesn't exceed open parentheses)
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }
}
```

---

## **Explanation of the Code:**

1. **Base Case**: The `backtrack` function checks if the length of the current string is `2*n` (because each valid combination consists of `n` opening and `n` closing parentheses). If so, it adds the combination to the result list.
  
2. **Recursive Calls**:
   - If we haven't added `n` opening parentheses yet, we add an opening parenthesis `(` and make a recursive call.
   - If we have more opening parentheses than closing parentheses, we can add a closing parenthesis `)` and make a recursive call.

3. **Result**: Once all the valid combinations are generated, the `generateParenthesis` function returns the result list.

---
