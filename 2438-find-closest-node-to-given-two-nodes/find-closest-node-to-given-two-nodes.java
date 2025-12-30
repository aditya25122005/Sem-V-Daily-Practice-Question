class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        // [0,-1,1,2];
        // [-1,0,1,2];  Min(Max(1,1),Max(2,2))  so, node 2

        // [0,1,2]
        // [-1,-1,0]  // -> Take max of (2,0)

        int[] d1 = new int[edges.length];
        int[] d2 = new int[edges.length];
        Arrays.fill(d1, -1);
        Arrays.fill(d2, -1);
        d1[node1] = 0;
        d2[node2] = 0;
        Solve(edges, node1, d1);
        Solve(edges, node2, d2);
        int ans = Integer.MAX_VALUE;
        int node = -1;
        for (int i = 0; i < d1.length; i++) {
            if (d1[i] == -1 || d2[i] == -1)
                continue;

            int curr = Math.max(d1[i], d2[i]);
            if (curr < ans) {
                ans = curr;
                node = i;
            }
        }
        return node;
    }

    public static void Solve(int[] edges, int node, int[] d) {
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        q.add(node);
        while (!q.isEmpty()) {
            int n = q.poll();
            if (visited.contains(n))
                continue;
            visited.add(n);
            int nbr = edges[n];
            if (nbr == -1)
                continue;
            if (d[nbr] == -1) {
                d[nbr] = d[n] + 1;
                q.add(nbr);
            }

        }
    }
}