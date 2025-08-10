import java.util.Arrays;

public class leetcode_3644 {
    public static void main(String[] args) {
        int [] nums={0,3,1,2};
        System.out.println(sortPermutation(nums));
    }
    public static int sortPermutation(int[] nums) {
        int n=nums.length;
        int maxK= Integer.MAX_VALUE; // all bits wil be one here
        int [] arr= nums.clone();
        int c=0;
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            if(arr[i]==nums[i]){
                c++;
            }
        }
        if(c==n) return 0;
        for(int i=0;i<n;i++){
            if(arr[i] != nums[i]){ // if the number needs to be swapped
                maxK= maxK & arr[i];   //a & b = k
            }                          // -> a&k = k also b&k = k
        }
        return maxK;
    }    
}
