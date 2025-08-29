public class first_occurence {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 6, 4, 3, 7 };
		int item = 6;
        System.out.println(idx(arr,item,0));

    }
    public static int idx(int[] arr, int item, int i){
        if(i>=arr.length){
            return -1;
        }
        if(arr[i]==item){
            return i;
        }
        return idx(arr,item,i+1);
    }
}
