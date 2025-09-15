public class coin_combination{
    public static void main(String[] args) {
        int[] coins={1,2,3,5};
        int amount=5;
        combination(coins, amount, "", 0);

    }
    public static void combination(int[] coins, int amount, String ans, int idx){
        if(amount==0){
            System.out.println(ans);
            return;
        }
        for(int i=idx;i<coins.length;i++){
            if(amount>=coins[i]){
                combination(coins, amount-coins[i], ans+coins[i], i);
            }
        }
    }
}