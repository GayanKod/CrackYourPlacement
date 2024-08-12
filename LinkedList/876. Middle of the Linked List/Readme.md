# 876 Middle of the Linked List

[Go to the problem on Leetcode](https://leetcode.com/problems/middle-of-the-linked-list/)

#### Intuition
To find the middle of a linked list, we can use two pointers moving at different speeds. If one pointer moves twice as fast as the other, by the time the faster pointer reaches the end of the list, the slower pointer will be at the middle.

#### Approach
1. We use two pointers: `hawa` and `head`.
2. `hawa` (the fast pointer) moves two nodes at a time.
3. `head` (the slow pointer) moves one node at a time.
4. By the time `hawa` reaches the end of the list, `head` will be exactly in the middle.
5. We return `head` as the middle node of the linked list.

#### Complexity

- **Time Complexity**: 
  - The time complexity is `O(n)`, where `n` is the number of nodes in the linked list. This is because we only traverse the list once.
  
- **Space Complexity**: 
  - The space complexity is `O(1)` because we are only using two pointers and no additional data structures.

#### Code

```python
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def middleNode(self, head: Optional[ListNode]) -> Optional[ListNode]:
        # Using two pointers (Floyd's Tortoise and Hare algorithm)
        hawa = head  # 'hawa' is the fast pointer

        while hawa and hawa.next:
            head = head.next  # Move slow pointer one step
            hawa = hawa.next.next  # Move fast pointer two steps

        return head  # When 'hawa' reaches the end, 'head' will be at the middle