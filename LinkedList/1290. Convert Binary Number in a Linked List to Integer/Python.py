# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

#solution 01
class Solution:
    def getDecimalValue(self, head: ListNode) -> int:
        answer = 0
        while head: 
            answer = 2*answer + head.val 
            head = head.next 
        return answer 


#solution 02 (my solution)
class Solution:
    def getDecimalValue(self, head: ListNode) -> int:
        current = head
        arr = []
        while current:
            arr.append(current.val)
            current = current.next
        
        arr.reverse()
        j=0
        cal=0
        for i in arr:
            cal = cal + i * (2**j)
            j+=1
        
        return cal