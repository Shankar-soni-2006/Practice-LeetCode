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
    public ListNode partition(ListNode head, int x) {
        ListNode temp = head;
        ListNode ls = new ListNode(-1);
        ListNode gs = new ListNode(-1);
        ListNode isLess = ls;
        ListNode isGreat = gs;
        while(temp != null){
            if(temp.val < x){
                isLess.next = temp;
                isLess = isLess.next;
            }else{
                isGreat.next = temp;
                isGreat = isGreat.next;
            }
            temp = temp.next;
        }
        isLess.next = gs.next;
        isGreat.next = null;
        head = ls.next;
        return head;
    }
}