# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        #floyd's hawa ibba cycle detection algorithm
        #ibba = head
        hawa = head

        while hawa and hawa.next:
            #ibba = ibba.next
            head = head.next
            hawa = hawa.next.next
            if (hawa == head): return True
        
        return False