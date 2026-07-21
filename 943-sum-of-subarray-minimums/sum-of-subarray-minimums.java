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
    public int sumSubarrayMins(int[] arr) {
        long sum = 0;
        long mod = 1_000_000_007;
        int n = arr.length;
        int[] prev = new int[n];
        int[] next = new int[n];
        pse(arr,prev);
        nse(arr,next);
        for(int i = 0; i < n; i++){
            long ans = (((i-prev[i]) * (next[i] - i))%mod*(arr[i])%mod)%mod;
            sum+=(ans % mod);
        }
        return (int)(sum % mod);
    }
}