class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        Arrays.sort(arr);
        int N=arr.length;
        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<N-2;i++){
            //remove duplicates for 1st ele
            if(i>0 && arr[i]==arr[i-1]){
                continue;
            }
            int left=i+1;
            int right=N-1;
            while(left<right){
                int sum=arr[left]+arr[right]+arr[i];
                if(sum==0){
                    result.add(Arrays.asList(arr[right],arr[left],arr[i]));

                    //remove duplicates for 2nd and third ele
                    while(left<right && arr[left]==arr[left+1]) left++;
                    while(left<right && arr[right]==arr[right-1]) right--;

                    left++;
                    right--;

                }
                else if(sum<0){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
return result;

        
    }
    public static void sort(int [] arr){
        for(int i=0;i<arr.length;i++){
           int idx= min_from_ith_index(arr,i);
           int temp=arr[i];
           arr[i]=arr[idx];
           arr[idx]=temp;
        }
    }
    public static int min_from_ith_index(int[] arr, int i){
        int mini=i;
        for(int j=i+1;j<arr.length;j++){
            if(arr[j]<arr[mini]){
                mini=j;
            }
        }
        return mini;
    }
}