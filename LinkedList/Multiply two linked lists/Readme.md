# Multiply Two Linked Lists

[Go to the Problem on GfG](https://www.geeksforgeeks.org/problems/multiply-two-linked-lists/1)

## Intuition
The problem asks us to multiply two numbers, where each number is represented by a linked list. Each node in the linked list contains a single digit, and the digits are arranged in a sequence, forming the complete number. The challenge lies in the potential size of the numbers, which could lead to overflow if handled incorrectly.

The solution needs to carefully handle large numbers, ensuring that we avoid overflow while still performing the multiplication accurately.

## Approach
1. **Representing Numbers from Linked Lists:**
   - Each linked list represents a large number, with each node storing a digit.
   - To form the entire number from the linked list, we start from the head (most significant digit) and move towards the tail, constructing the number digit by digit.
   - To avoid overflow during this process, we keep the number within a manageable range using the modulo operation.

2. **Modulo Operation:**
   - We use a large prime number, \(10^9 + 7\), as the modulo value (`MOD`) to prevent overflow and keep the numbers within the `long` data type's range.
   - As we traverse each linked list, we multiply the current accumulated number by 10 (to shift the digits left) and add the current digit, then apply the modulo operation.

3. **Multiplying the Numbers:**
   - Once we have the two numbers from the linked lists, we multiply them and again use the modulo operation to ensure the result doesn't exceed the allowed range.

4. **Return the Result:**
   - Finally, we return the product of the two numbers, modulo \(10^9 + 7\).

## Complexity
- **Time Complexity:**  
  The time complexity is \(O(N + M)\), where \(N\) is the length of the first linked list and \(M\) is the length of the second linked list. This is because we traverse each linked list once to calculate the respective numbers.

- **Space Complexity:**  
  The space complexity is \(O(1)\) because we only use a constant amount of extra space for variables (`firstNum`, `secondNum`, and `MOD`). No additional data structures are used.

## Time Complexity:
- \(O(N + M)\)

## Space Complexity:
- \(O(1)\)

## Code
```java
class Solution {
    public long multiplyTwoLists(Node first, Node second) {
        // Modulo value to avoid overflow
        long MOD = 1000000007;
        
        long firstNum = 0;
        long secondNum = 0;
        
        // Traverse the first linked list
        while (first != null) {
            firstNum = (firstNum * 10 + first.data) % MOD;
            first = first.next;
        }
        
        // Traverse the second linked list
        while (second != null) {
            secondNum = (secondNum * 10 + second.data) % MOD;
            second = second.next;
        }
        
        // Multiply the two numbers and take modulo
        return (firstNum * secondNum) % MOD;
    }
}
```