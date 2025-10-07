class Solution {
    public String simplifyPath(String path) {
        String[] parts= path.split("/");
        List<String> res= new ArrayList<>();
        for(String s:parts){
            if(s.equals(".") || s.equals("")){
                continue;
            }else if(s.equals("..")){
                if(res.size()!=0) res.remove(res.size()-1);
            }else{
                res.add(s);
            }
        }
        StringBuilder sb= new StringBuilder();
        for(String s:res){
            sb.append("/").append(s);
        }
        if(sb.length()==0) return "/";
        return sb.toString();
    }
}