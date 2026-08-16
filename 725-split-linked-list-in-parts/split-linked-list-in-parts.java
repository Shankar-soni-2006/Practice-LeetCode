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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = 0;
        ListNode temp = head;
        while(temp!=null){
            len++;
            temp = temp.next;
        }
        temp = head;
        int bs = len/k;
        int rm = len%k;
        ListNode []ans= new ListNode[k];
        for(int i=0;i<k;i++){
            if(temp==null){
                ans[i]= null;
                continue;
            }
            ans[i] = temp;
            int cur = bs+(rm>0?1:0);
            rm--;
            for(int j=0;j<cur-1;j++){
                if(temp!=null) temp = temp.next;
            }
            if(temp!=null){
                ListNode nxt = temp.next;
                temp.next = null;
                temp = nxt;
            }
        }
        return ans;
    }
}