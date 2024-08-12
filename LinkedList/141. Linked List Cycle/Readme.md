# 141. Linked List Cycle

[Go to the problem on Leetcode](https://leetcode.com/problems/linked-list-cycle/)

#### Intuition
In this problem, we need to determine if a linked list contains a cycle. A cycle occurs when a node’s `next` pointer points back to a previous node in the list, creating a loop. To detect this, we can use a clever approach known as Floyd's Cycle Detection Algorithm, also called the "Tortoise and Hare" algorithm.

#### Approach
1. We use two pointers: `hawa` (the fast pointer) and `head` (the slow pointer).
2. Both pointers start at the head of the linked list.
3. In each step:
   - The `head` pointer moves one step at a time.
   - The `hawa` pointer moves two steps at a time.
4. If there is a cycle, the fast pointer will eventually catch up to the slow pointer within the cycle.
5. If the fast pointer (`hawa`) meets the slow pointer (`head`), a cycle is detected, and we return `True`.
6. If the fast pointer reaches the end of the list (`None`), there is no cycle, and we return `False`.

#### Complexity

- **Time Complexity**: 
  - The time complexity is `O(n)`, where `n` is the number of nodes in the linked list. In the worst case, the fast pointer will traverse all nodes before detecting a cycle or reaching the end.

- **Space Complexity**: 
  - The space complexity is `O(1)` because we are only using two pointers without any additional data structures.

#### Code

```python
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        # Using Floyd's Cycle Detection Algorithm
        hawa = head  # 'hawa' is the fast pointer

        while hawa and hawa.next:
            head = head.next  # Move slow pointer one step
            hawa = hawa.next.next  # Move fast pointer two steps
            
            if hawa == head:  # If they meet, there is a cycle
                return True
        
        return False  # No cycle detected