class Solution {
    public int compareVersion(String version1, String version2) {
        String[] s1= version1.split("\\.");
        String [] s2= version2.split("\\.");
        int n= Math.max(s1.length,s2.length);
        for(int i=0;i<n;i++){
            int val1=(i<s1.length)? Integer.parseInt(s1[i]) :0;
            int val2=(i<s2.length)? Integer.parseInt(s2[i]) :0;
            if(val1<val2)return -1;
            if(val1>val2)return 1;
        }
        return 0;
    }
}