class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        HashMap<Character, HashSet<Character>> map = new HashMap<>();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            map.put(ch, new HashSet<>());
        }
        for (int i = 0; i < s1.length(); i++) {
            char u = s1.charAt(i);
            char v = s2.charAt(i);
            map.get(u).add(v);
            map.get(v).add(u);
        }
        StringBuilder res = new StringBuilder();
        for (char ch : baseStr.toCharArray()) {
            HashSet<Character> vis = new HashSet<>();
            Queue<Character> q = new LinkedList<>();
            char ans = ch;
            q.add(ch);
            while (!q.isEmpty()) {
                char rm = q.poll();
                if (vis.contains(rm)) {
                    continue;
                }
                vis.add(rm);
                if (rm < ans) {
                    ans = rm;
                }
                for (char nbrs : map.get(rm)) {
                    if (!vis.contains(nbrs)) {
                        q.add(nbrs);
                    }
                }
            }
            res.append(ans);
        }
        return res.toString();
    }
}