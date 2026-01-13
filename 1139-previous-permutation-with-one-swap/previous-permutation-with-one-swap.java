class Solution {
    public int[] prevPermOpt1(int[] arr) {
        int n=arr.length;
        int idx=-1;
        for(int i=n-2;i>=0;i--){
            if(arr[i]>arr[i+1]){
                idx=i;
                break;
            }
        }
        if(idx==-1) return arr;

        int j=n-1;
        while(arr[j]>=arr[idx]){
            j--;
        }
        while(j>0 && arr[j]==arr[j-1]){
            j--;
        }
        // swap
        int temp=arr[idx];
        arr[idx]=arr[j];
        arr[j]=temp;

        // reverse(arr,idx+1,j);

        return arr;
    }
    // public static void reverse(int [] arr, int i, int j){
    //     while(i<j){
    //         int temp=arr[i];
    //         arr[i]=arr[j];
    //         arr[j]=temp;
    //         i++;
    //         j--;
    //     }
    // }
}