class Solution {
    public long minimumSteps(String s) {
        long black = 0;
        long step = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i)=='1') black++;
            else{
                step += black;
            }
        }
        return step;
    }
}