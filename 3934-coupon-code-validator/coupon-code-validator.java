class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<Integer> ll= new ArrayList<>();
        for(int i=0;i<code.length;i++){
            String s= code[i];
            
            if(validCode(s.toCharArray()) && validBusiness(businessLine[i]) && isActive[i]){
            ll.add(i);
            }
            
        }
        Collections.sort(ll,(a,b)->{
            int i= businessOrder(businessLine[a]);
            int j= businessOrder(businessLine[b]);
            if(i!=j) return i-j;

            return code[a].compareTo(code[b]);
        });
        List<String> ans= new ArrayList<>();
        for(int i=0;i<ll.size();i++){
            ans.add(code[ll.get(i)]);
        }
        return ans;
    }
    public static boolean validCode(char[] arr){
        if(arr.length==0) return false;
        for(int  i=0;i<arr.length;i++){
            if(arr[i]!='_' && !Character.isDigit(arr[i]) && !Character.isLetter(arr[i]) ){
                return false;
            }
        }
        return true;
    }
    public static boolean validBusiness(String s){
        if(s.equals("restaurant") || s.equals("pharmacy") || s.equals("electronics") || s.equals("grocery")){
            return true;
        }
        return false;
    }
    public static int businessOrder(String s){
        if(s.equals("electronics")) return 0;
        if(s.equals("grocery")) return 1;
        if(s.equals("pharmacy")) return 2;
        if(s.equals("restaurant")) return 3;
        return 34;
    }
}