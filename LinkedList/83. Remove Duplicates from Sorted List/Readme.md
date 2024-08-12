# Remove Duplicates from Sorted List
[Go to the problem on Leetcode](https://leetcode.com/problems/remove-duplicates-from-sorted-list/)

## Intuition
In a sorted linked list, duplicates are always consecutive. This allows us to remove them by simply comparing each node with the next one. If two consecutive nodes have the same value, we remove the second node by skipping over it.

## Approach
1. Initialize a pointer (`current`) to the head of the linked list.
2. Traverse the list with this pointer.
3. For each node, compare its value with the value of the next node:
   - If the values are equal, skip the next node by setting `current.next` to `current.next.next`.
   - If the values are not equal, move the pointer to the next node.
4. Continue this process until the end of the list is reached.
5. Return the modified list starting from the head.

## Complexity

- **Time Complexity:** O(n) where `n` is the number of nodes in the linked list. We only traverse the list once.
- **Space Complexity:** O(1) because we are using a constant amount of space, only modifying the existing pointers.

## Code
```python
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        current = head

        while current and current.next:
            # If the current node's value is equal to the next node's value
            if current.val == current.next.val:
                # Skip the next node
                current.next = current.next.next
            else:
                # Move to the next node
                current = current.next
        # Return the modified list
        return head