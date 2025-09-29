class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n= matrix.length;
        int m=matrix[0].length;
        int total=m*n;
        int cnt=0;

        int sr=0;
        int er=n-1;

        int sc=0;
        int ec=m-1;

        List<Integer> ll= new ArrayList<>();
        
        while(cnt<total){
        int curr=sc;
        while(curr<=ec && cnt<total){
            ll.add(matrix[sr][curr]);
            cnt++;
            curr++;
        }
        sr++;
        curr=sr;
        while(curr<=er && cnt<total){
            ll.add(matrix[curr][ec]);
            cnt++;
            curr++;
        }
        ec--;
        curr=ec;
        while(curr>=sc && cnt<total){
            ll.add(matrix[er][curr]);
            cnt++;
            curr--;
        }
        er--;
        curr=er;
        while(curr>=sr && cnt<total){
            ll.add(matrix[curr][sc]);
            cnt++;
            curr--;
        }
        sc++;
        }
        return ll;
    }
}