class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = n-1; i >= 0; i--){
            if(!map.containsKey(nums2[i])){
                while(!st.isEmpty() && st.peek() <= nums2[i]) st.pop();
                if(!st.isEmpty()) map.put(nums2[i],st.peek());
                else map.put(nums2[i],-1);   
                st.push(nums2[i]);  
            }
        }
        for(int i = 0; i < nums1.length; i++){
            if(map.containsKey(nums1[i])) nums1[i] = map.get(nums1[i]);
            else nums1[i] = -1;
        }
        return nums1;
    }
}