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
    public ListNode mergeNodes(ListNode head) {
        ListNode temp = head.next;
        ListNode ptr = temp;
        while(ptr!=null){
            int sum = 0;
            while(ptr.val!=0){
                sum+=ptr.val;
                ptr = ptr.next;    
            }
            temp.val = sum;
            ptr = ptr.next;
            temp.next = ptr;
            temp = temp.next;
        }
        return head.next;
    }
}
