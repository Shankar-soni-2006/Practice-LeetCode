class Solution {
    public boolean uniformArray(int[] arr) {
        boolean flag = true;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(arr[i],min);
            if(arr[i] % 2 != 0) flag = false;
        }
        return flag || (min %2 != 0);
    }
}
