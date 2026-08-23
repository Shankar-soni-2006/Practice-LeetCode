class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int sum = 0,qm = 0;
        for(int i=0;i<n;i++){
            char c = num.charAt(i);
            int val = (c!='?')?c-'0':0;
            if(i<n/2){
                sum+=val;
                if(c=='?') qm++;
            }
            else{
                sum-=val;
                if(c=='?') qm--;
            }
        }
        return (2*sum+qm*9)!=0;
    }
}