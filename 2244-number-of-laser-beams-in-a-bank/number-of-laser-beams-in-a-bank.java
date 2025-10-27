class Solution {
    public int numberOfBeams(String[] bank) {
        List<Integer> ll= new ArrayList<>();
        for(String str:bank){
            int cnt=0;
            for(char ch:str.toCharArray()){
                if(ch=='1') cnt++;
            }
            if(cnt!=0) ll.add(cnt);
        }
        int ans=0;
        for(int i=0;i<ll.size()-1;i++){
            ans+= ll.get(i)*ll.get(i+1);
        }
        return ans;
    }
}