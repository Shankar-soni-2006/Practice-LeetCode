class Solution {
    public boolean check(int[] price, int k, int mid){
        int curr = 1, prev = price[0];
        for(int i = 1; i < price.length; i++){
            if(price[i]-prev >=  mid){
                curr++;
                prev = price[i];
            }
        }
        return curr >= k;
    }
    public int maximumTastiness(int[] price, int k) {
        int n = price.length;
        Arrays.sort(price);
        int l = 0, h = price[n-1]-price[0];
        while(l <= h){
            int mid = l+(h-l)/2;
            if(check(price, k, mid)) l = mid+1;
            else h = mid-1;
        }
        return h;
    }
}