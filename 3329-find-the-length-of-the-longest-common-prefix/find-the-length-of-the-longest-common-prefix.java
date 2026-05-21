class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int maxLen = 0;
        HashSet<Integer> hh = new HashSet<>();
        for(int num: arr1){
            hh.add(num);
            while(num!=0){
                num = num/10;
                if(num>0) hh.add(num);
            }
        }

        for(int num: arr2){
            int pre = num;
            if(hh.contains(pre)) maxLen = Math.max(maxLen, String.valueOf(pre).length());
            while(num!=0){
                num/=10;
                if(num>0 && hh.contains(num)){
                    maxLen = Math.max(maxLen, String.valueOf(num).length());
                }
            }
        }
    return maxLen;
    
    }
}