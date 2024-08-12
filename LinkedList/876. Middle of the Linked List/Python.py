# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def middleNode(self, head: Optional[ListNode]) -> Optional[ListNode]:
        #floyd's hawa ibba algorithm
        hawa = head

        while hawa and hawa.next:
            head = head.next
            hawa = hawa.next.next

        return head        

#The idead is in the following , the above code improved for better efficiency
class Solution:
    def middleNode(self, head: Optional[ListNode]) -> Optional[ListNode]:
        #floyd's hawa ibba algorithm
        ibba = head
        hawa = head

        while hawa and hawa.next:
            ibba = ibba.next
            hawa = hawa.next.next

        return ibba  