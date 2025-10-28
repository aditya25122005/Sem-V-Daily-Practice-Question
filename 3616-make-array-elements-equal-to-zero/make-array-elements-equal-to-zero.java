class Solution {
    public int countValidSelections(int[] nums) {
        int si=0;
        int ei=nums.length-1;
        int ans=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                //Move left;
                int [] temp= nums.clone();
                int curr=i;
                int dir=-1;
                while(curr>=si && curr<=ei){
                    if(temp[curr]==0){
                        curr+=dir;
                    }
                    else if(temp[curr]>0){
                        temp[curr]--;
                        if(dir==1){
                            dir=-1;
                        }else{
                            dir=1;
                        }
                        curr+=dir;
                    }
                    
                }
                boolean allZero=true;
                for(int num:temp){
                    if(num!=0){
                        allZero=false;
                        break;
                    }
                }
                if(allZero) ans++;

                //Move right
                temp= nums.clone();
                curr=i;
                dir=1;
                while(curr>=si && curr<=ei){
                    if(temp[curr]==0){
                        curr+=dir;
                    }
                    else if(temp[curr]>0){
                        temp[curr]--;
                        if(dir==1){
                            dir=-1;
                        }else{
                            dir=1;
                        }
                        curr+=dir;
                    }
                    
                }
                allZero=true;
                for(int num:temp){
                    if(num!=0){
                        allZero=false;
                        break;
                    }
                }
                if(allZero) ans++;
            }

        }
        return ans;
    }
}