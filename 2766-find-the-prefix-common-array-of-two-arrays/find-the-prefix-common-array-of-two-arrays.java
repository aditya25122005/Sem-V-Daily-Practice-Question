class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        HashSet<Integer> hh1 = new HashSet<>();
        HashSet<Integer> hh2 = new HashSet<>(); 
        int c=0;       
        for(int i=0;i<A.length;i++){
            hh1.add(A[i]);
            hh2.add(B[i]);
            c=0;
            if(hh1.contains(A[i]) && hh2.contains(A[i])){
                c++;
            }
            if( A[i] != B[i] && hh1.contains(B[i]) && hh2.contains(B[i])){
                c++;
            }
            if(i>0){
                A[i] = c+A[i-1];
            }
            else{
                A[i] = c;
            }
            
        }
        return A;
    }
}