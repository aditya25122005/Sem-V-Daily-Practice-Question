class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x=0;
        for(String o:operations){
            if(o.equals("X++") || o.equals("++X")){
                x++;
            }
            else if(o.equals("--X") || o.equals("X--")){
                x--;
            }
        }
        return x;
        
    }
}