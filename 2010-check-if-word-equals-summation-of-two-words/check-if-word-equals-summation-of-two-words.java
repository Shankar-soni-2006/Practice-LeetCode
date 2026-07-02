class Solution {
    public int Check(String word){
        long num = 0;
        for (int i = 0; i < word.length(); i++) num = num * 10 + (word.charAt(i) - 'a');
        return (int)num;
    }
    public boolean isSumEqual(String fW, String sW, String tW) {
        long sum= Check(tW);
        long f = Check(fW);
        long s = Check(sW);
        return (f+s == sum);
    }
}