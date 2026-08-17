class Solution {
    public boolean isChecker(int[] q, int k, int mid){
        if(mid == 0) return false;
        int cnt = 0;
        for(int i : q){
            // cnt+=((i+mid-1) / mid); 
            cnt+=Math.ceil((double)i/mid);
        }
        return cnt <= k;
    }
    public int minimizedMaximum(int k, int[] q) {
        int n = q.length;
        int l = 0, r = 0;
        for(int x : q) r = Math.max(r, x);    
        while(l <= r){
            int mid = l+(r-l)/2;
            if(isChecker(q, k, mid)) r = mid-1;
            else l = mid+1;
        }
        return l;
    }
}