class Solution {
    public int[] asteroidCollision(int[] ast) {
        Stack<Integer> st = new Stack<>();
        for(int i : ast){
            boolean flag = true;
            while(flag && !st.isEmpty() && st.peek() > 0 && i < 0){
                if(Math.abs(st.peek()) < Math.abs(i)) st.pop();
                else if(Math.abs(st.peek()) == Math.abs(i)){
                    st.pop();
                    flag = false;
                }else flag = false;
            }
            if(flag) st.push(i);
        }
        int[] arr = new int[st.size()];
        for(int i = 0 ;i < arr.length; i++) arr[i] = st.get(i);
        return arr;
    }
}