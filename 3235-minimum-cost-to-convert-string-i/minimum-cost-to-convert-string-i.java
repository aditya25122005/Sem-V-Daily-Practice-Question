class Solution {
    public long minimumCost(String s, String t, char[] original, char[] changed, int[] cost) {
        HashMap<Character, HashMap<Character, Integer>> map = new HashMap<>();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            map.put(ch, new HashMap<>());
        }

        for (int i = 0; i < original.length; i++) {
            char ch = original[i];
            map.get(ch).put(changed[i],
                    Math.min(cost[i], map.get(ch).getOrDefault(changed[i], Integer.MAX_VALUE)));
        }

        long[][] dp = new long[26][26];
        for (long[] A : dp) {
            Arrays.fill(A, -1);
        }

        long ans = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {

                int x = s.charAt(i) - 'a';
                int y = t.charAt(i) - 'a';
                if (dp[x][y] != -1) {
                    if (dp[x][y] == Integer.MAX_VALUE) {
                        return -1;
                    }
                    ans += dp[x][y];
                    continue;
                }
                boolean mark = false;
                PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.cost, b.cost));
                HashSet<Character> visited = new HashSet<>();
                pq.add(new Pair(s.charAt(i), 0));
                while (!pq.isEmpty()) {
                    // remove
                    Pair rm = pq.poll();
                    char c = rm.ch;
                    long p = rm.cost;

                    // ignore
                    if (visited.contains(c)) {
                        continue;
                    }

                    // Mark Visited
                    visited.add(c);

                    // Self work
                    if (c == t.charAt(i)) {
                        mark = true;
                        ans += p;
                        dp[x][y] = p;
                        break;
                    }

                    // Add Unvisited nbrs
                    for (char nbrs : map.get(c).keySet()) {
                        if (!visited.contains(nbrs)) {
                            long price = p + map.get(c).get(nbrs);
                            pq.add(new Pair(nbrs, price));
                        }
                    }
                }
                if (!mark) {
                    dp[x][y] = Integer.MAX_VALUE;
                    return -1;
                }
            }
        }
        return ans;
    }

    class Pair {
        char ch;
        long cost;

        public Pair(char ch, long cost) {
            this.ch = ch;
            this.cost = cost;
        }
    }
}
