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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        ListNode ans = lists[0];
        for(int i=1;i<lists.length;i++){
            ans = mergeTwoLists(ans,lists[i]);
        }
        return ans;
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null && list2==null){
            return null;
        } 
        if(list1==null) return list2;
        if(list2==null) return list1;
        ListNode head = new ListNode(-101);
        ListNode tail = head;
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        while(temp1!=null && temp2!=null){
            if(temp1.val<=temp2.val){
                if(head==null){
                    head = temp1;
                }
                tail.next = temp1;
                tail = tail.next;
                temp1 = temp1.next;
            }
            else{
                if(head==null){
                    head = temp2;
                }
                tail.next = temp2;
                tail = tail.next;
                temp2 = temp2.next;
            }
        }
        if(temp1!=null){
            tail.next = temp1;
            temp1 = temp1.next;
        }
        if(temp2!=null){
            tail.next = temp2;
            temp2 = temp2.next;
        }
        return head.next;
    }
}

