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
    public int getC(ListNode head){
        if(head==null)return 0;
        int next = getC(head.next);
        int t = (head.val*2)+next;
        head.val = t%10;
        return t/10;     
    }
    public ListNode doubleIt(ListNode head) {
        int c = getC(head);
        if(c>0){
            ListNode newNode = new ListNode(c);
            newNode.next = head;
            head = newNode;
        }
        return head;
    }
}