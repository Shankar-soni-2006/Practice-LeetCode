class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int total = 0;
        for(int i : arr) total+=i;
        if(total % 3 != 0) return false;
        int count = 0;
        int target = total/3;
        int curr = 0;
        for(int i : arr){
            curr+=i;
            if(curr == target){
                count++;
                curr = 0;
            }
        }
        return count >= 3;
    }
}