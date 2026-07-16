class Solution {
    public long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    public long gcdSum(int[] nums) {
        long mx = 0;
        List<Long> s = new ArrayList<>();
        for (int i : nums) {
            mx = Math.max(mx, i);
            s.add(gcd(mx, i));
        }
        Collections.sort(s);
        long sum = 0;
        int i = 0;
        int j = s.size() - 1;
        while (i < j) {
            sum += gcd(s.get(i), s.get(j));
            i++;
            j--;
        }
        return sum;
    }
}