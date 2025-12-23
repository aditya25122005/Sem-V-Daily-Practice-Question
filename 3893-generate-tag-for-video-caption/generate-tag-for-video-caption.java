class Solution {
    public String generateTag(String caption) {
        StringBuilder sb= new StringBuilder();
        sb.append('#');
        int rem=99;
        String [] strs= caption.split(" ");
        int i2=1;
        for(int i=0;i<strs.length;i++){
            if(strs[i].equals(" ") || strs[i].equals("")){
                i2++;
                continue;
            }

            for(int j=0;j<strs[i].length() && rem>0;j++){
                    if(strs[i].charAt(j)==' ') continue;
                    sb.append(Character.toLowerCase(strs[i].charAt(j)));
                    rem--;
            }
            break;


        }
        for(int i=i2;i<strs.length;i++){
            if(rem>0 && strs[i].length()<=rem){
                if(strs[i].equals("")) continue;
                if(strs[i].charAt(0)==' ') continue;
                sb.append(Character.toUpperCase(strs[i].charAt(0)));
                rem--;
                for(int j=1;j<strs[i].length() && rem>0;j++){
                    if(strs[i].charAt(j)==' ') continue;
                    sb.append(Character.toLowerCase(strs[i].charAt(j)));
                    rem--;
                }
            }

        }
        return sb.toString();



    }
}