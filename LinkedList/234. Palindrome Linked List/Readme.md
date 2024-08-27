# **234. Palindrome Linked List**

[Go to the problem on Leetcode](https://leetcode.com/problems/palindrome-linked-list/)

## **Intuition**

A palindrome is a sequence that reads the same forward and backward. To determine if a linked list is a palindrome, we need to check whether the values in the list are symmetrical. The key idea is to split the list into two halves, reverse the second half, and then compare the two halves. If all corresponding elements are equal, the list is a palindrome.

## **Approach**

1. **Find the Middle of the Linked List:**
   - Use two pointers, `fast` and `slow`, starting from the head. The `fast` pointer moves twice as fast as the `slow` pointer. By the time `fast` reaches the end, `slow` will be at the middle of the list.
  
2. **Handle Odd Number of Nodes:**
   - If the list has an odd number of nodes, the middle element doesn't need to be compared. So, move the `slow` pointer one step forward to skip the middle element.

3. **Reverse the Second Half of the List:**
   - Reverse the nodes in the second half of the list, starting from where the `slow` pointer is currently positioned.

4. **Compare the Two Halves:**
   - Compare the nodes in the first half of the list with the nodes in the reversed second half. If all corresponding nodes have the same value, the list is a palindrome.

5. **Return the Result:**
   - If all comparisons are equal, return `true`; otherwise, return `false`.

## **Complexity**

- **Time Complexity:** `O(n)` where `n` is the number of nodes in the linked list. We traverse the list multiple times (to find the middle, reverse the second half, and compare the halves), but each traversal is linear.
  
- **Space Complexity:** `O(1)` as we only use a few extra pointers, and no additional space is required proportional to the input size.

## **Code**

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        
        ListNode fast = head;
        ListNode slow = head;

        // Find the middle
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        // For odd number of nodes, skip the middle node
        if(fast != null){
            slow = slow.next;
        }

        // Reverse the second half
        slow = reverseList(slow);
        fast = head;

        // Compare the two halves
        while(slow != null){
            if (fast.val != slow.val){
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }

        return true;
    }

    // Helper function to reverse a linked list
    ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}