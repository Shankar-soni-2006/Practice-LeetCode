class Solution {
    public char slowestKey(int[] rT, String keysPressed) {
        int max = rT[0];
        int idx = 0;
        for(int i = 1; i < rT.length; i++){
            if(rT[i]-rT[i-1] > max){
                 max = rT[i]-rT[i-1];
                 idx = i;
            }else if(rT[i]-rT[i-1]==max && keysPressed.charAt(i) > keysPressed.charAt(idx)) idx = i;
        }
        return keysPressed.charAt(idx);
    }
}