class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> map= new HashMap<>();
        List<Integer> ll= new ArrayList<>();

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch,i);;
        }
        int prev=-1;
        int max=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            max=Math.max(max,map.get(ch));
            if(i==max){
                ll.add(max-prev);
                prev=i;
            }
        }
        return ll;
    }
}