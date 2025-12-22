class Solution {
    public String alphabetBoardPath(String target) {
        String[] strs={"abcde","fghij","klmno","pqrst","uvwxy","z"};
        StringBuilder path= new StringBuilder();
        int cr=0;
        int cc=0;
        for(int i=0;i<target.length();i++){
            char ch=target.charAt(i);
            int n=ch-'a';
            int r=n/5;   //2
            int c=n%5;   //1

            if(ch=='z'){
                while(cc>c){
                    cc--;
                    path.append("L");
                }
                while(cr<r){
                    cr++;
                    path.append('D');
                }
                path.append("!");
                continue;
            }

            if(cr==r && cc==c){
                path.append("!");
            }
            else if(cr==r){
                if(cc<c){
                    while(cc<c){
                        cc++;
                        path.append('R');
                    }
                }
                else{
                    while(cc>c){
                        cc--;
                        path.append('L');
                    }
                }
                path.append("!");
            }
             else if(cc==c){
                if(cr<r){
                    while(cr<r){
                        cr++;
                        path.append('D');
                    }
                }
                else{
                    while(cr>r){
                        cr--;
                        path.append('U');
                    }
                }
                path.append("!");

             }

             else{
                if(cr<r){
                while(cr<r){
                    cr++;
                    path.append('D');
                }
                }
                if(cr>r){
                while(cr>r){
                    cr--;
                    path.append('U');
                }
                }
                if(cc<c){
                while(cc<c){
                    cc++;
                    path.append('R');
                }
                }
                if(cc>c){
                while(cc>c){
                    cc--;
                    path.append('L');
                }
                }
                path.append("!");
             }


        }
        return path.toString();
    }
}