class Solution {
    public int minSwaps(String s) {
       int size = 0;
       for(char c : s.toCharArray()){
            if(c == '[') size++;
            else if(size > 0) size--;
       }
       return (size+1)/2;
    }
}