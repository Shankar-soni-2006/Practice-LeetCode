class Solution {
    public String convert(String s, int numRows) {
        int n = s.length();
        if(numRows == 1 || numRows >= n) return s;
        StringBuilder[] arr = new StringBuilder[numRows];
        for(int i = 0 ; i < arr.length; i++) arr[i] = new StringBuilder();
        boolean flag = false;
        int idx = 0;
        for(int i = 0; i < n; i++){
            arr[idx].append(s.charAt(i));
            if(idx == 0 || idx == numRows-1) flag = !flag;
            idx += (flag ? 1 : -1);
        }
        StringBuilder ans = new StringBuilder();
        for(StringBuilder k : arr) ans.append(k);
        return ans.toString();
    }
}