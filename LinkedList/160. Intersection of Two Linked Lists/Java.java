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

        //add all node addresses of LinkedList A
        while (headA != null){
            set.add(headA);
            headA = headA.next;
        }

        //check addresses with headB addresses
        while (headB != null){
            if (!set.add(headB)) return headB;
            headB = headB.next;
        }

        return null;
    }
}