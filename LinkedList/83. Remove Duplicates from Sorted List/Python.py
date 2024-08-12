# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        current=head

        while current and current.next:
            # If the current node's value is equal to the next node's value
            if (current.val == current.next.val):
                # Skip the next node
                current.next = current.next.next
            else: 
                current = current.next
        #return the modified list
        return head
        