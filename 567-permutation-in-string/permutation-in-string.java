class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for (char ch : s1.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        HashMap<Character, Integer> map = new HashMap<>();
        int si = 0;
        int ei = 0;
        int matched = 0;
        while (ei < s2.length()) {
            char ch = s2.charAt(ei);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            if(freq.containsKey(ch) && map.get(ch)<= freq.get(ch)){
                matched++;
            }

            while (freq.containsKey(ch) && map.get(ch) > freq.get(ch)) {
                if (freq.containsKey(s2.charAt(si)) && map.get(s2.charAt(si)) <= freq.get(s2.charAt(si))) {
                    matched--;
                }
                map.put(s2.charAt(si), map.get(s2.charAt(si)) - 1);
                if (map.get(s2.charAt(si)) == 0){
                    map.remove(s2.charAt(si));
                }
                si++;
            }
            if (!freq.containsKey(ch)) {
                map.clear();
                si = ei + 1;
                matched = 0;
            }

            if (ei - si + 1 == s1.length() && matched == s1.length()) {
                return true;
            }
            ei++;

        }
        return false;
    }

}