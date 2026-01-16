class Solution {
    public String largestMerge(String word1, String word2) {
        int i=0;
        int j=0;
        StringBuilder sb= new StringBuilder();
        while(i<word1.length() && j<word2.length()){
            if(word1.charAt(i)>word2.charAt(j)){
                sb.append(word1.charAt(i));
                i++;
            }
            else if(word2.charAt(j)>word1.charAt(i)){
                sb.append(word2.charAt(j));
                j++;
            }
            else if(word1.charAt(i)==word2.charAt(j)){
                String s1= word1.substring(i);
                String s2= word2.substring(j);

                if(s1.compareTo(s2)>0){
                    sb.append(word1.charAt(i));
                    i++;
                }
                else{
                    sb.append(word2.charAt(j));
                    j++;
                }
            }
        }

        while(i<word1.length()){
            sb.append(word1.charAt(i));
            i++;
        }
        while(j<word2.length()){
            sb.append(word2.charAt(j));
            j++;
        }
        return sb.toString();
    }
}