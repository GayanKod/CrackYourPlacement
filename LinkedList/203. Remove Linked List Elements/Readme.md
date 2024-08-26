# 203. Remove Linked List Elements

[Go to the problem on Leetcode](https://leetcode.com/problems/remove-linked-list-elements/)

## Intuition

In this problem, we are given a linked list and a value `val`. Our goal is to remove all nodes from the list that contain the value `val`. The challenge is to do this efficiently without using extra space. Linked lists are linear data structures where each element points to the next, so we must carefully adjust these pointers to remove the elements.

## Approach

1. **Head Adjustment**: 
   - First, we handle the case where the head of the linked list contains the value `val`. We keep moving the head pointer to the next node until we find a node that doesn't contain `val` or until the list becomes empty.
   
2. **Traversing the List**:
   - We then traverse the rest of the list with a pointer called `current`. For each node, we check if the next node contains the value `val`.
   - If it does, we adjust the `next` pointer of `current` to skip the node that needs to be removed.
   - If it doesn’t, we move the `current` pointer to the next node.

3. **Return the Updated List**:
   - After we have traversed the entire list and removed the necessary nodes, we return the modified head of the list.

This approach efficiently removes all instances of `val` from the linked list.

## Complexity

### Time complexity:
- **O(n)**: We traverse the entire linked list once, where `n` is the number of nodes in the list.

### Space complexity:
- **O(1)**: We are using a constant amount of extra space, as we only use a few pointers (`head` and `current`).

## Code

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
    public ListNode removeElements(ListNode head, int val) {
        
        // If nodes that should be removed are in the head
        while (head != null && head.val == val) {
            head = head.next;
        }

        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}