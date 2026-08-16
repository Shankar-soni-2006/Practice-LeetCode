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
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
    public int[] nextLargerNodes(ListNode head) {
        ListNode rev = reverse(head);
        List<Integer> temp = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        ListNode curr = rev;
        while(curr != null){
            while(!st.isEmpty() && st.peek() <= curr.val) st.pop();
            if(st.isEmpty()) temp.add(0);
            else temp.add(st.peek());
            st.push(curr.val);
            curr = curr.next;
        }
        Collections.reverse(temp);
        int[] nge = new int[temp.size()];
        for(int i = temp.size()-1; i >= 0; i--) nge[i] = temp.get(i);
        return nge;
    }
}