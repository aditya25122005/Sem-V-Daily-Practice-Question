class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        /*
         n stores are there
         m products whose quantity is given
        */
        int m= quantities.length;
        int sum=0;
        int max=0;
        for(int num:quantities){
            sum+= num;
            max=Math.max(num,max);
        }
        int lo=1;
        int hi=max;
        int ans=Integer.MAX_VALUE;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(isPossible(quantities,n,mid)){
                ans=mid;
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }

        }
        return ans;
        // return (int)Math.ceil((double)sum/n);

    }
    public static boolean isPossible(int []Quantity, int Shops, int mid){
        // Distribute max of mid Product-Quantity to each shop
        int currShop=0;
        for(int p:Quantity){
           currShop += (int) Math.ceil((double)p/mid);
           if(currShop>Shops) return false;
        }
        return true;
    }
}