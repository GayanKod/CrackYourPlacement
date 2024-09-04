# 206. Reverse Linked List

[Go to the problem on Leetcode](https://leetcode.com/problems/reverse-linked-list/)

## Intuition

Reversing a linked list means we need to reverse the direction of every pointer in the list. Normally, each node in a linked list points to the next node. In a reversed list, each node should point to the previous node instead. The challenge is to do this efficiently by updating pointers as we traverse the list.

## Approach

To reverse the linked list, we use three pointers: `prev`, `curr`, and `nextTemp`.

1. **Initialize Pointers:** 
   - `prev` starts as `null` because the new head of the reversed list will have `null` as its `next` pointer.
   - `curr` starts at the head of the list and will move through each node.

2. **Iterate Through the List:**
   - In each iteration, temporarily store the `next` node in `nextTemp` to avoid losing the rest of the list.
   - Change the `next` pointer of the `curr` node to point to `prev`, effectively reversing the link direction.
   - Move `prev` and `curr` one step forward, repeating the process until `curr` becomes `null`.

3. **Return the New Head:**
   - After the loop ends, `prev` will be pointing to the new head of the reversed list, so return `prev`.

This method efficiently reverses the linked list in a single pass.

## Complexity

- **Time Complexity:** `O(n)`, where `n` is the number of nodes in the linked list. We go through each node exactly once.
- **Space Complexity:** `O(1)`, as we only use a few extra variables regardless of the list size.

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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        return prev;
    }
}
```