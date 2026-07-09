class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int Q = queries.length;
        int N = words.length;
        int[] qf = new int[Q];
        int idx = 0;
        for (String word : queries) {
            char[] a = word.toCharArray();
            Arrays.sort(a);
            char c = a[0];
            int cnt = 1;
            for (int i = 1; i < a.length; i++) {
                if (a[i] == c) {
                    cnt++;
                } else {
                    break;
                }
            }
            qf[idx] = cnt;
            idx++;
        }

        int[] wf = new int[N];
        idx = 0;
        for (String word : words) {
            char[] a = word.toCharArray();
            Arrays.sort(a);
            char ch = a[0];
            int cnt = 1;
            for (int i = 1; i < a.length; i++) {
                if (a[i] == ch) {
                    cnt++;
                } else {
                    break;
                }
            }
            wf[idx] = cnt;
            idx++;
        }
        Arrays.sort(wf);

        int[] res = new int[Q];
        idx = 0;

        for (int val1 : qf) {
            int ansIdx = Search(wf, val1);
            if (ansIdx < 0 || ansIdx > N) {
                res[idx++] = 0;
            } else {
                res[idx++] = N - ansIdx;
            }
        }
        return res;
    }

    public static int Search(int[] wf, int target) {
        int lo = 0;
        int hi = wf.length - 1;
        int res = wf.length;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (wf[mid] > target) {
                res = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return res;
    }
}