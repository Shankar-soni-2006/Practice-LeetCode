class Solution {
    public int minAddToMakeValid(String s) {
        int cnt = 0, temp = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(') temp++;
            else{
                temp--;
                if(temp < 0){ 
                    temp = 0;
                    cnt++;
                }
            }
        }
        return cnt + temp;
    }
}