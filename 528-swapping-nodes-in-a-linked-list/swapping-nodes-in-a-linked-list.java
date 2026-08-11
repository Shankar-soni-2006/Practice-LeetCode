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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode temp = head;
        ListNode n1 = null;
        ListNode n2 = null;
        int n = 0;
        while(temp!=null){
            n++;
            temp = temp.next;
        }
        temp = head;
        int c = 0;
        while(temp!=null){
            c++;
            if(c==k)n1 = temp;
            if(c==(n-(k-1))) n2=temp;
            temp = temp.next;
        }
        int t = n1.val;
        n1.val = n2.val;
        n2.val = t;
        return head;
    }
}
