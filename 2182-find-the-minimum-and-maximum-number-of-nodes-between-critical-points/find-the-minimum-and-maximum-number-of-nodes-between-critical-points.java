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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ArrayList<Integer> map = new ArrayList<>();
        ListNode temp =head;
        ListNode prev= head;
        int c=0;
        while(temp.next!=null){
            c++;
            if((temp.val>prev.val && temp.val>temp.next.val) ||(temp.val<prev.val && temp.val<temp.next.val)){
                map.add(c);
            }
            prev = temp;
            temp = temp.next;
        }
        if(map.size()<2)return new int[]{-1,-1};
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < map.size(); i++) {
            min = Math.min(min, map.get(i) - map.get(i - 1));
        }
        int max = map.get(map.size() - 1) - map.get(0);
        if(min ==Integer.MAX_VALUE && max == Integer.MIN_VALUE)return new int[]{-1,-1};
        return new int[]{min,max};
    }
}
