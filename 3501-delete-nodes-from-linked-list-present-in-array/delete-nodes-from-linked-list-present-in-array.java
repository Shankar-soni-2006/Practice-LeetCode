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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Map<Integer, Boolean> mp = new HashMap<>();
        for(int i : nums) mp.put(i,true);
        ListNode temp = head;
        ListNode prev = null;
        while(temp != null){
            if(mp.containsKey(temp.val)){
                if(prev == null) head = temp.next;
                else prev.next = temp.next;
            }else prev = temp;
            temp = temp.next;
        }
        return head;
    }
}