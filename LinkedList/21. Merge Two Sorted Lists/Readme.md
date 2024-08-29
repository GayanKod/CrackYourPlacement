## 21. Merge Two Sorted Lists

[Go to the problem on Leetcode](https://leetcode.com/problems/merge-two-sorted-lists/)

Given two sorted linked lists, the task is to merge them into a single sorted linked list. The resulting list should also be sorted.

For example:
- `list1: 1 -> 2 -> 4`, `list2: 1 -> 3 -> 4`
- The merged list would be `1 -> 1 -> 2 -> 3 -> 4 -> 4`.

---

### Intuition

When you have two sorted linked lists, the simplest way to merge them is to compare the smallest elements (head of each list) and build a new list by choosing the smaller element. We repeat this process until all elements from both lists are merged.

### Approach

1. **Dummy Node for Ease**:
   - We create a dummy node called `sortedList` with an initial value of `0`. This node acts as a starting point for the merged list. It's helpful because it simplifies edge cases and makes it easier to return the head of the merged list later.

2. **Merging Process**:
   - We use two pointers, `list1` and `list2`, to traverse the two input lists.
   - We also use a pointer `out` to build the merged list, starting from the dummy node.
   - As we traverse both lists, we compare the current nodes pointed to by `list1` and `list2`. We choose the smaller node and attach it to `out.next`, then move the pointer of the chosen list to the next node.
   - We continue this process until one of the lists is fully traversed.

3. **Handle Remaining Nodes**:
   - If one list is longer than the other, there will be nodes left in that list after the other list is fully traversed. We simply attach the remaining nodes to the end of the merged list.

4. **Return the Merged List**:
   - Finally, we return `sortedList.next` as the head of the merged list. We use `sortedList.next` because the first node (`sortedList`) is just a dummy node with a value of `0` and should not be included in the final output.

### Complexity

**Time Complexity**:
- The time complexity is `O(n + m)`, where `n` and `m` are the lengths of `list1` and `list2`, respectively. This is because we traverse each list exactly once.

**Space Complexity**:
- The space complexity is `O(1)` (constant space). We do not use any extra space that grows with the size of the input lists, except for the pointers used to traverse the lists and build the merged list.

### Code

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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) return list2;
        if (list2 == null) return list1;
        
        ListNode sortedList = new ListNode(0); // Dummy node to start the merged list
        ListNode out = sortedList;

        while (list1 != null && list2 != null){
            if (list1.val <= list2.val){
                out.next = list1; // Attach the smaller node to the merged list
                list1 = list1.next; // Move the pointer to the next node in list1
            }
            else {
                out.next = list2; // Attach the smaller node to the merged list
                list2 = list2.next; // Move the pointer to the next node in list2
            }
            out = out.next; // Move the pointer to the next position in the merged list
        }

        // If any nodes are left in either list, attach them to the merged list
        if (list1 != null){
            out.next = list1;
        } else if (list2 != null){
            out.next = list2;
        }

        return sortedList.next; // Return the merged list, starting after the dummy node
    }
}