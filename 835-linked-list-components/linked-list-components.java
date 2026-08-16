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
    public int numComponents(ListNode head, int[] nums) {
        int comp = 0;
        int idx = 0;
        ListNode temp = head;
        HashMap<Integer,Boolean> map = new HashMap<>();
        for(int i:nums) map.put(i,true);
        while(temp!=null){
            if(map.containsKey(temp.val) && (temp.next==null || !map.containsKey(temp.next.val))) comp++;
            temp = temp.next;
        }
        return comp;
    }
}