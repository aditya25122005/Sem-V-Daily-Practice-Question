class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        // 0 1 2 3 0 0 1

        // 0 4 3 2 1 0 0
        List<Integer> ll= new ArrayList<>();
        int [] pre = new int[security.length];
        pre[0]=0;
        for(int i=1;i<security.length;i++){
            if(security[i-1]>=security[i]){
                pre[i]=pre[i-1]+1;
            }
            else{
                pre[i]=0;
            }
        }
        int [] suf= new int[security.length];
        suf[suf.length-1]=0;
        for(int i=suf.length-2;i>=0;i--){
            if(security[i]<= security[i+1]){
                suf[i]=suf[i+1]+1;
            }
            else{
                suf[i]=0;
            }
        }
        for(int i=0;i<pre.length;i++){
            if(pre[i]>=time && suf[i]>=time){
                ll.add(i);
            }
        }
        return ll;
    }
}