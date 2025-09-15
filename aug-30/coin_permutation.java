public class coin_permutation {
    public static void main(String[] args) {
        int []coins={1,2,3,5};
        int amt=5;
        Permut(coins,amt,"");
        System.out.println();
        NoRepeat(coins, amt, "", 0);
    }
    public static void Permut(int[] coins, int amt, String ans){
        if(amt==0){
            System.out.print(ans+" ");
            return;
        }
        for(int i=0;i<coins.length;i++){
            if(amt>=coins[i]){
            Permut(coins, amt-coins[i], ans+coins[i]);
            }
        }
    }
    public static void NoRepeat(int[] coins, int amt, String ans, int idx){
        if(amt==0){
            System.out.print(ans+" ");
            return;
        }
        for(int i=idx;i<coins.length;i++){
            if(amt>=coins[i]){
            NoRepeat(coins, amt-coins[i], ans+coins[i],i+1);
            }
        }
    }    
}
