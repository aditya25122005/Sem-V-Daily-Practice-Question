class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        int C = 0;
        int prevStart = intervals[0][0];
        int prevEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            if (currStart >= prevStart && currEnd <= prevEnd) {
                C++;
            } else {
                prevStart = currStart;
                prevEnd = currEnd;
            }
        }
        return intervals.length - C;
    }
}