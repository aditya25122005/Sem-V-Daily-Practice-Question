class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0;
        int j=0;
        List<Integer> ll= new ArrayList<>();
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]==nums2[j]){
                ll.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i]<nums2[j]){
                i++;
            }
            else{
                j++;
            }
        }
        int [] ans= new int[ll.size()];
        for(int k=0;k<ll.size();k++){
            ans[k]=ll.get(k);
        }
        return ans;
        // HashMap<Integer,Integer> map1= new HashMap<>();
        // HashMap<Integer,Integer> map2= new HashMap<>();
        // List<Integer> ll= new ArrayList<>();
        // for(int num:nums1){
        //     map1.put(num,map1.getOrDefault(num,0)+1);
        // }
        // for(int num:nums2){
        //     map2.put(num,map2.getOrDefault(num,0)+1);
        // }
        // for(int i=0;i<nums1.length;i++){
        //     if(map1.containsKey(nums1[i]) && map2.containsKey(nums1[i])){
        //         int count=Math.min(map1.get(nums1[i]), map2.get(nums1[i]));
        //         map1.remove(nums1[i]);
        //         map2.remove(nums1[i]);
        //         for(int j=1;j<=count;j++){
        //             ll.add(nums1[i]);
        //         }
        //     }
        // }

        // int [] ans= new int[ll.size()];
        // for(int i=0;i<ll.size();i++){
        //     ans[i]=ll.get(i);
        // }
        // return ans;


        // if(nums2.length<nums1.length){
        //     return intersect(nums2,nums1);
        // }
        // List<Integer> ll= new ArrayList<>();

        // // Now nums1 is smaller
        // int n=nums1.length;
        // int m= nums2.length;
        // int idx=0;
        // for(int i=0;i<m;i++){
        //     if(nums2[i]==nums1[idx]){
        //         ll.add(nums2[i]);
        //         idx++;
        //         if(idx==n) break;
                
        //     }
        //     else{
        //         idx++;
        //         if(idx==n) break;
        //     }
        // }
        // int [] ans= new int[ll.size()];
        // for(int i=0;i<ll.size();i++){
        //     ans[i]=ll.get(i);
        // }
        // return ans;
    }
}