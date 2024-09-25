# 12. **Integer to Roman**

[Go to the problem on Leetcode](https://leetcode.com/problems/integer-to-roman/)

## Problem Description

Convert an integer to a Roman numeral. Roman numerals are represented by the following symbols:

```
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
```

The integer is between 1 and 3999.

---

## **Intuition**

The task is to convert a given integer into a Roman numeral. Roman numerals have specific values for symbols, and combinations of those symbols represent different numbers. Larger numbers are placed before smaller numbers to form the Roman numeral (e.g., 6 is `VI` (5 + 1), and 9 is `IX` (10 - 1)).

To solve this problem, we need to repeatedly subtract the largest possible Roman numeral value from the number, adding the corresponding Roman numeral symbol to the result each time, until the number becomes zero.

---

## **Approach**

1. **List the Roman numerals**: First, we create a list of Roman numeral symbols paired with their integer values, sorted from the largest to the smallest.
  
2. **Iterate through the list**: Start from the largest Roman numeral and check how many times the numeral can fit into the number.
   - For example, if the number is 3549, the largest Roman numeral that fits is `M` (1000).
  
3. **Subtract and add**: Subtract the value of the numeral from the number and add the corresponding symbol to the result string.
  
4. **Continue until the number becomes zero**: Repeat this process until the number is fully converted.

---

## **Complexity**

- **Time Complexity**: The time complexity is O(1), because the input is constrained between 1 and 3999, and the number of Roman numerals we are processing is constant.
  
- **Space Complexity**: The space complexity is O(1), since we are only using a fixed amount of extra space to store the Roman numerals and the result string.

---

## **Time complexity:**
O(1) - Constant time because the algorithm runs in a fixed amount of time regardless of the input size (since the largest number is 3999).

---

## **Space complexity:**
O(1) - Constant space because we use a fixed amount of space for variables and the result string.

---

## **Code**

```java
class Solution {
    public String intToRoman(int num) {
        // Define arrays of Roman numerals and their corresponding values
        String[] romanSymbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        // Initialize an empty StringBuilder to store the resulting Roman numeral
        StringBuilder result = new StringBuilder();

        // Loop through each Roman numeral, starting with the largest
        for (int i = 0; i < values.length; i++) {
            // While the current value can be subtracted from num
            while (num >= values[i]) {
                // Subtract the value from num
                num -= values[i];
                // Append the corresponding Roman numeral to the result
                result.append(romanSymbols[i]);
            }
        }
        
        // Convert the StringBuilder to a string and return the result
        return result.toString();
    }
}
```

---

### **Explanation of the Code:**

1. **Roman symbols and values**: We store the Roman numeral symbols and their corresponding integer values in two arrays: `romanSymbols[]` and `values[]`.

2. **Result**: We use a `StringBuilder` to efficiently build the final Roman numeral string.

3. **Main loop**: We loop through the values from largest to smallest. For each value, we repeatedly subtract it from `num` and add the corresponding Roman numeral symbol to the result until `num` becomes smaller than the current value.

4. **Return**: Finally, we return the result as a string.

---
