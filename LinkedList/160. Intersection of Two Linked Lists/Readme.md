# 160. Intersection of Two Linked Lists

[Go to the Problem on Leetcode](https://leetcode.com/problems/intersection-of-two-linked-lists/)

## Intuition
The problem requires us to find the node where two singly linked lists intersect. If they do not intersect, we should return `null`. The key observation here is that if two linked lists intersect, they share common nodes from the intersection point to the end of the lists. Therefore, the nodes beyond this intersection point will have the same memory addresses in both lists.

To solve this problem, we can utilize a data structure to keep track of the nodes we have seen in one list and then check if any node in the other list has already been visited.

## Approach
1. **Using a HashSet to Track Nodes:**
   - We create an empty `HashSet` to store the nodes of the first linked list (List A).
   - As we traverse through List A, we add each node to the `HashSet`. Since the `HashSet` only stores unique elements, it allows us to track which nodes we've already seen.

2. **Checking for Intersection:**
   - Next, we traverse through the second linked list (List B). For each node in List B, we check if it already exists in the `HashSet`.
   - If a node from List B is found in the `HashSet`, it means that this node is the intersection point because it has already been visited in List A.
   - If no intersection is found by the end of the traversal, we return `null`.

3. **Return the Intersection Node:**
   - The first node where the two lists intersect will be returned. If there's no intersection, the function will return `null`.

## Complexity
- **Time Complexity:**  
  The time complexity is \(O(N + M)\), where \(N\) is the number of nodes in List A and \(M\) is the number of nodes in List B. We need to traverse both lists once.

- **Space Complexity:**  
  The space complexity is \(O(N)\) because we store the nodes of List A in a `HashSet`. The space required is proportional to the number of nodes in List A.

## Time Complexity:
- \(O(N + M)\)

## Space Complexity:
- \(O(N)\)

## Code
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();

        // Add all nodes from List A to the set
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        // Check each node in List B to see if it exists in the set
        while (headB != null) {
            if (!set.add(headB)) return headB; // Found intersection
            headB = headB.next;
        }

        return null; // No intersection found
    }
}
```
