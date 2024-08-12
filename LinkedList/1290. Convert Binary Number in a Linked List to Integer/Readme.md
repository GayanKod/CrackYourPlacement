# Convert Binary Number in a Linked List to Integer

[Go to the problem on Leetcode](https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/)

## Intuition
The problem requires us to convert a binary number represented as a linked list into its decimal (integer) form. Each node in the linked list contains a binary digit (0 or 1), and the order of the nodes represents the binary number. To convert this binary number to decimal, we can use the concept of positional values, where each digit is multiplied by 2 raised to the power of its position.

## Approach
1. Initialize a variable `answer` to 0, which will hold the decimal value.
2. Traverse through each node in the linked list.
3. For each node:
   - Update `answer` by multiplying it by 2 (shifting left) and adding the current node's value (`head.val`).
4. Move to the next node in the linked list.
5. Continue this process until all nodes have been processed.
6. Finally, return the computed decimal value stored in `answer`.

This approach effectively builds the decimal number by processing the binary digits from left to right.

## Complexity
- **Time Complexity**: O(N), where N is the number of nodes in the linked list. This is because we need to traverse the entire linked list once.
- **Space Complexity**: O(1), as we are using a constant amount of space (only the `answer` variable) regardless of the input size.

## Code
```python
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def getDecimalValue(self, head: ListNode) -> int:
        answer = 0
        while head: 
            answer = 2 * answer + head.val 
            head = head.next 
        return answer 