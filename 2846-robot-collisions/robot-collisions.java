class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n= healths.length;
        List<Pair> ll= new ArrayList<>();
        for(int i=0;i<n;i++){
            ll.add(new Pair(positions[i], healths[i], directions.charAt(i), i));
        }
        Stack<Pair> st= new Stack<>();
        Collections.sort(ll,(a,b)->Integer.compare(a.pos, b.pos));


        for(int i=0;i<n;i++){
            Pair rm= ll.get(i);

            if(st.isEmpty() || st.peek().dir=='L' || ll.get(i).dir=='R'){
                st.push(rm);
            }
            else{
                while(!st.isEmpty() &&  st.peek().dir=='R' && ll.get(i).dir=='L' && ll.get(i).health> st.peek().health){
                    // do batein ho sakti hai
                    st.peek().health=0;
                    st.pop();
                    ll.get(i).health--;
                }


                if(!st.isEmpty() && st.peek().dir=='R'){
                    if(st.peek().health== ll.get(i).health){
                        ll.get(i).health=0;
                        st.peek().health=0;
                        st.pop();
                    }
                    else if(st.peek().health> ll.get(i).health){
                        st.peek().health--;
                        ll.get(i).health=0;
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
        Collections.sort(res,(a,b)-> Integer.compare(a.idx,b.idx));
        List<Integer> ans= new ArrayList<>();
        for(Pair p: res){
            ans.add(p.health);
        }
        return ans;
    }

    static class Pair{
        int pos;
        int health;
        char dir;
        int idx;

        public Pair(int pos, int health, char dir, int idx){
            this.pos=pos;
            this.health=health;
            this.dir=dir;
            this.idx=idx;
        }
    }
}