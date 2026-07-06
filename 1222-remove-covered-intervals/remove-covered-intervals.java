class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        int count = 0;
        int end = 0;
        for (int[] inter : intervals) {
            if (inter[1] > end) {
                count++;
                end = inter[1];
            }
        }
        return count;
    }
}