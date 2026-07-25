class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int n1 = arr1.length, n2 = arr2.length;
        int count = 0;
        for(int x : arr1){
            boolean flag = true;
            for(int y : arr2){
                if(Math.abs(x-y) <= d){
                    flag = false;
                    break;
                }
            }
            if(flag) count++;
        }
        return count;
    }
}