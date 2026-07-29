class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] res = new int[nums.length-k+1];
        int idx = 0;
        for(int i = 0; i < nums.length; i++){
            while(!dq.isEmpty() && dq.peekLast() < nums[i]) dq.removeLast();
            dq.addLast(nums[i]);
            if(i >= k-1) res[idx++] = dq.peekFirst();
            if(i-k+1 >= 0 && dq.peekFirst() == nums[i-k+1]) dq.removeFirst();
        }
        return res;
    }
}