// class Solution {
//     public void pse(int[] arr,int[] prev){
//         Stack<Integer> pst = new Stack<>();
//         for(int i = 0; i < arr.length; i++){
//             while(!pst.isEmpty() && arr[pst.peek()] >= arr[i]) pst.pop();
//             if(pst.isEmpty()) prev[i] = -1;
//             else prev[i] = pst.peek();
//             pst.push(i);
//          }
//     }
//     public void nse(int[] arr,int[] next){
//         Stack<Integer> nst = new Stack<>();
//         for(int i = arr.length-1; i >= 0; i--){
//             while(!nst.isEmpty() && arr[nst.peek()] > arr[i]) nst.pop();
//             if(nst.isEmpty()) next[i] = arr.length;
//             else next[i] = nst.peek();
//             nst.push(i);
//         }
//     }
//     public int sumSubarrayMins(int[] arr) {
//         long sum = 0;
//         long mod = 1_000_000_007;
//         int n = arr.length;
//         int[] prev = new int[n];
//         int[] next = new int[n];
//         pse(arr,prev);
//         nse(arr,next);
//         for(int i = 0; i < n; i++){
//             long ans = (((i-prev[i]) * (next[i] - i))%mod*(arr[i])%mod)%mod;
//             sum+=(ans % mod);
//         }
//         return (int)(sum % mod);
//     }
// } 

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int mod = 1000000007;
        int[] right = new int[n + 1];
        int[] left = new int[n + 1];
        int[] sum = new int[n + 1];

        for (int i = 0; i < n; ++i) {
            right[i + 1] = arr[i];
        }

        int res = 0;
        for (int i = 1; i <= n; i++) {
            int curr = right[i];
            int j = i - 1;

            while (right[j] >= curr) {
                j = left[j];
            }
            
            left[i] = j;
            sum[i] = sum[j] + curr * (i - j);
            res = (res + sum[i]) % mod;
        }

        return res;
    }
}