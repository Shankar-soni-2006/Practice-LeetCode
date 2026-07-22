class Solution {
     public void pse(int[] arr,int[] prev){
        Stack<Integer> pst = new Stack<>();
        for(int i = 0; i < arr.length; i++){
            while(!pst.isEmpty() && arr[pst.peek()] >= arr[i]) pst.pop();
            if(pst.isEmpty()) prev[i] = -1;
            else prev[i] = pst.peek();
            pst.push(i);
         }
    }
    public void nse(int[] arr,int[] next){
        Stack<Integer> nst = new Stack<>();
        for(int i = arr.length-1; i >= 0; i--){
            while(!nst.isEmpty() && arr[nst.peek()] > arr[i]) nst.pop();
            if(nst.isEmpty()) next[i] = arr.length;
            else next[i] = nst.peek();
            nst.push(i);
        }
    }
    public int largestRectangleArea(int[] arr) {
        int n = arr.length;
        int ans = 0;
        int[] prev = new int[n];
        int[] next = new int[n];
        pse(arr,prev);
        nse(arr,next);
        for(int i = 0; i < n; i++){
            int area =(next[i]-prev[i]-1)*arr[i];
            ans = Math.max(ans,area);
            // int j = i,k =i;
            // while(j >= 0 && arr[j] >= arr[i]) j--;
            // while(k < n && arr[k] >= arr[i]) k++;
            // ans = Math.max(ans,(arr[i]*(k-j-1)));
        }
        return ans;
    }
}