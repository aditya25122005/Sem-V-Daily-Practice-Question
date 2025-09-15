package codeskiller;
import java.util.*;
public class Valentine_Magic {
    public static void main(String args[]) {
        Scanner sc= new Scanner(System.in);
        int N= sc.nextInt();
        int M= sc.nextInt();
        int[] boy=new int[N];
        int[] girl= new int[M];
        for(int i=0;i<N;i++){
            boy[i]=sc.nextInt();
        }
        for(int i=0;i<M;i++){
            girl[i]=sc.nextInt();
        }
        Arrays.sort(boy);
        Arrays.sort(girl);
        int[][] dp= new int[N+1][M+1];
        for(int []a:dp){
            Arrays.fill(a,-1);
        }
        int A=Valentine(boy,girl,0,0,dp);
        System.out.println(A);

    }
    public static int Valentine(int[] boy, int [] girl, int i, int j, int[][] dp){
        if(i==boy.length){
            return 0;
        }
        if(j==girl.length){
            return 9999999;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int ans1= Math.abs(boy[i]-girl[j]) + Valentine(boy,girl,i+1,j+1,dp);
        int ans2=Valentine(boy,girl,i,j+1,dp);
        return dp[i][j]=Math.min(ans1, ans2);
    }

}