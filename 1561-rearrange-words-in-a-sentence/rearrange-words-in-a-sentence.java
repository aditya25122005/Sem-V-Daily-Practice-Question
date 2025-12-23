class Solution {
    public String arrangeWords(String text) {
        String[] strs= text.split(" ");
        strs[0]=strs[0].toLowerCase();


        HashMap<String,Integer> map= new HashMap<>();
        for(int i=0;i<strs.length;i++){
            map.put(strs[i],i);
        }

        Arrays.sort(strs,(a,b)->a.length()-b.length());

        StringBuilder sb= new StringBuilder();
        for(String s:strs){
            sb.append(s).append(" ");
        }
        char [] ans= sb.toString().toCharArray();
        ans[0]=Character.toUpperCase(ans[0]);
        String res= String.valueOf(ans);
        return res.substring(0,res.length()-1);
    }
}