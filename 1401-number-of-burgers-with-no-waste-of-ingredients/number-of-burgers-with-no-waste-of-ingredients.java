class Solution {
    public List<Integer> numOfBurgers(int tomato, int cheese) {
        List<Integer> ll= new ArrayList<>();
        if(tomato%2!=0) return ll;
        int X=0;
        int Y=0;
        Y=(4*cheese-tomato)/2;
        X=cheese-Y;
        if(X<0 || Y<0) return ll;
        ll.add(X);
        ll.add(Y);
        return ll;

    }
}