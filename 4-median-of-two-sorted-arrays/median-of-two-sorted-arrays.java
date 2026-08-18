class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int n = nums1.length, m = nums2.length;
        int l =0, h = n;
        while(l <=h){
            int x = l+(h-l)/2;
            int y = (m+n+1)/2 - x;
            int l1 = (x==0) ? Integer.MIN_VALUE : nums1[x-1];
            int r1 = (x == n) ? Integer.MAX_VALUE : nums1[x];
            int l2 = (y==0) ? Integer.MIN_VALUE : nums2[y-1];
            int r2 = (y == m)? Integer.MAX_VALUE : nums2[y];
            if(l1 <= r2 && l2 <= r1){
                if((n+m)%2 == 1) return Math.max(l1,l2);
                return (Math.max(l1,l2)+Math.min(r1,r2)) / 2.0;
            }
            if(l1 > r2) h = x-1;
            else l = x+1;
        }
        return 0.0;    
    }
}