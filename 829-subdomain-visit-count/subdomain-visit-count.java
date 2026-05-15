class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String,Integer> map = new HashMap<>();
        
        for(String str: cpdomains){
            String[] arr = str.split(" ");
            int count = Integer.parseInt(arr[0]);
            String s2 = arr[1];
            String [] arr2 = s2.split("\\.");
            // for(String sss: arr2) System.out.println("sss");
            for(int i=0;i<arr2.length;i++){
                StringBuilder sb = new StringBuilder();
                for(int j=i;j<arr2.length;j++){
                    sb.append(arr2[j]).append(".");
                }
                // System.out.println(sb);
                String ss = sb.toString().substring(0,sb.length()-1);
                if(!map.containsKey(ss)){
                    map.put(ss,count);
                }
                else{
                    map.put(ss,map.getOrDefault(ss,0)+count);
                }
                    
            }
        }
        // System.out.println(map);
        List<String> ans = new ArrayList<>();
        for(String key: map.keySet()){
            StringBuilder sb = new StringBuilder();
            sb.append(map.get(key)).append(" ").append(key);
            ans.add(sb.toString());
        }
        return ans;
        
    }
}