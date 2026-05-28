class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int,int>  map;
        int curr = 0;
        for(int i=0;i<nums.size();i++){
            curr = nums[i];
            if(map.find(target-curr) != map.end()){
                return {map[target-curr],i};
            }
            map[nums[i]] = i;
        }
        return {};
    }
};