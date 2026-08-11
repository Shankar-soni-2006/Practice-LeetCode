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
    ListNode head;
    Random rand;
    public Solution(ListNode head) {
        this.head = head;
        this.rand = new Random();
    }
    public int getRandom() {
        ListNode temp = this.head;
        int res= temp.val;
        int c =1;
        while(temp!=null){
            if(rand.nextInt(c)==0)res = temp.val;
        c++;
        temp=temp.next;
        }
        return res;

    }
}


/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */