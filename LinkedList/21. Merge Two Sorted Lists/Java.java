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
        
        ListNode sortedList = new ListNode(0); //the head is always 0
        ListNode out = sortedList;

        while (list1 != null && list2 != null){
            if (list1.val <= list2.val){
                out.next = list1;
                list1 = list1.next;
            }
            else if (list2.val <= list1.val){
                out.next = list2;
                list2 = list2.next;
            }
            out = out.next;
        }

        if (list1 != null){
            out.next = list1;
        }else if (list2 != null){
            out.next = list2;
        }

        return sortedList.next;
        //Always remember, when you check node by node and add nodes
        //add as a node, not try to add with a value when you are given linkedlists
    }
}