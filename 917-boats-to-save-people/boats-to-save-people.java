class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int boat=0;
        int curr=0;
        int i=0;
        int j=people.length-1;
        Arrays.sort(people);
        while(i<=j){

            int sum= people[i]+people[j];
            if(sum<=limit){
                i++;
                j--;
                boat++;
            }
            else{
                j--;
                boat++;
            }
        }
        return boat;
    }
}