class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans= new int[nums1.length];
        HashMap<Integer,Integer> map= new HashMap<>();
        int idx=0;
        for(int num:nums2){
            map.put(num,idx);
            idx++;
        }
        int k=0;
        for(int i=0;i<nums1.length;i++){
            int id=map.get(nums1[i])+1;
            
            int nextGreater=-1;
            for(int j=id;j<nums2.length;j++){
                if(nums2[j]>nums1[i]) {
                    nextGreater = nums2[j];
                    break;
                }
                
            }
            ans[k]=nextGreater;
            k++;
            }
        
        return ans;

    }
}