class Solution {
    public boolean sumGame(String num) {
        int diff = 0, ql = 0, qr = 0;
        int n = num.length();
        for(int i = 0; i < n/2; i++){
            if(num.charAt(i) == '?') ql++;
            else diff+=(num.charAt(i)-'0');
        }
        for(int i = n/2; i < n; i++){
            if(num.charAt(i) == '?') qr++;
            else diff-=(num.charAt(i)-'0');
        }
        return 2*diff != 9*(qr-ql);
    }
}