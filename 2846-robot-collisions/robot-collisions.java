class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<Pair> ll= new ArrayList<>();
        int n=positions.length;
        for(int i=0;i<n;i++){
            ll.add( new Pair(positions[i], healths[i], directions.charAt(i),i));
        }
        Collections.sort(ll,(a,b)->Integer.compare(a.pos, b.pos));
        Stack<Pair> st = new Stack<>();
        for(int i=0;i<ll.size();i++){
            Pair rm = ll.get(i);
            int currP = rm.pos;
            int currH = rm.health;
            char currDir = rm.dir;
            if(st.isEmpty() || st.peek().dir=='L' || currDir=='R'){
                st.push(rm);
            }
            else{
                while(!st.isEmpty() && st.peek().dir=='R' && ll.get(i).health> st.peek().health){
                    st.peek().health=0;
                    st.pop();
                    ll.get(i).health--;            //  R <-- L
                    if(ll.get(i).health==0) continue;
                }
                if(!st.isEmpty() && st.peek().dir=='R'){
                    if(st.peek().health == ll.get(i).health) {
                        ll.get(i).health=0;
                        st.peek().health=0;
                        st.pop();
                    }
                    else if(st.peek().health> ll.get(i).health){
                        ll.get(i).health=0;
                        st.peek().health--;
                    }
                }
                else{
                    st.push(rm);
                }
            }
        }
        List<Pair> res= new ArrayList<>();
        for(Pair p: ll){
            if(p.health>0){
                res.add(p);
            }
        }
        Collections.sort(res,(a,b)->Integer.compare(a.idx,b.idx));
        List<Integer> ans= new ArrayList<>();
        for(Pair P: res){
            ans.add(P.health);
        }
        return ans;
    }
    public static boolean sameDir(char a, char b){
        return a==b;
    }
    static class Pair{
        int pos;
        int health;
        char dir;
        int idx;
        public Pair(int pos, int health, char dir,int idx){
            this.pos=pos;
            this.health=health;
            this.dir=dir;
            this.idx=idx;
        }
    }
}