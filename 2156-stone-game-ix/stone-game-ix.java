class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[] arr = new int[3];
        for(int x : stones) arr[x%3]++;
        if(arr[0] % 2 == 0) return arr[1] >0 && arr[2] > 0;
        return Math.abs(arr[1] - arr[2]) > 2;
    }
}