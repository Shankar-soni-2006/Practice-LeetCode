class Solution {
    public boolean isChecker(int[] time, int k, long mid){
        long cnt = 0;
        for(int i : time){
            cnt += (mid/i);
            if(cnt >= k) return true;
        }
        return cnt >= k;
    }
    public long minimumTime(int[] time, int k) {
        int n = time.length;
        long l = 1, r = 0;
        for(int x : time) r = Math.max(r, x);
        r = r * k;
        while(l <= r){
            long mid = l+(r-l)/2;
            if(isChecker(time, k, mid)) r = mid-1;
            else l = mid+1;
        }
        return l;
    }
}