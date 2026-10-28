class Solution {
    public boolean threeFibonacciSum(int n) {
        int a = 0,b = 1,c = 1;
        int sum = 0;
        while(sum<n){
            sum = a+b+c;
            if(sum==n) return true;
            int temp = b+c;
            a = b;
            b = c;
            c= temp;
        }
        return false;
    }
}