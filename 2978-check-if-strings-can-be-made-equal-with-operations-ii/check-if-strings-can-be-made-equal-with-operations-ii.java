class Solution {
    public boolean checkStrings(String s1, String s2) {

        return Solve(s1,s2);
        // StringBuilder sb1= new StringBuilder();
        // StringBuilder sb2= new StringBuilder();
        // StringBuilder sb3= new StringBuilder();
        // StringBuilder sb4= new StringBuilder();

        // for(int i=0;i<s1.length();i++){
        //     if(i%2==0){
        //         sb1.append(s1.charAt(i));
        //     }
        //     else{
        //         sb2.append(s1.charAt(i));
        //     }
        // }



        // for(int i=0;i<s2.length();i++){
        //     if(i%2==0){
        //         sb3.append(s2.charAt(i));
        //     }
        //     else{
        //         sb4.append(s2.charAt(i));
        //     }
        // }

        // char [] a1= sb1.toString().toCharArray();
        // char [] a2= sb2.toString().toCharArray();
        // char [] a3= sb3.toString().toCharArray();
        // char [] a4= sb4.toString().toCharArray();
        // Arrays.sort(a1);
        // Arrays.sort(a2);
        // Arrays.sort(a3);
        // Arrays.sort(a4);
        //  s1= String.valueOf(a1);
        //  s2=String.valueOf(a2);
        //  String s3= String.valueOf(a3);
        //  String s4= String.valueOf(a4);
        //  System.out.println(s1);
        //  System.out.println(s2);
        //  System.out.println(s3);
        //  System.out.println(s4);

        //  return s1.equals(s3) && s2.equals(s4);


        
    }
    public static boolean Solve(String s1, String s2){
        HashMap<Character,Integer> m1= new HashMap<>();
        HashMap<Character,Integer> m2= new HashMap<>();
        HashMap<Character,Integer> m3= new HashMap<>();
        HashMap<Character,Integer> m4= new HashMap<>();


        for(int i=0;i<s1.length();i++){
            if(i%2==0){
                m1.put(s1.charAt(i),m1.getOrDefault(s1.charAt(i),0)+1);
            }
            else{
                m2.put(s1.charAt(i),m2.getOrDefault(s1.charAt(i),0)+1);
            }
        }

        for(int i=0;i<s2.length();i++){
            if(i%2==0){
                m3.put(s2.charAt(i),m3.getOrDefault(s2.charAt(i),0)+1);
            }
            else{
                m4.put(s2.charAt(i),m4.getOrDefault(s2.charAt(i),0)+1);
            }
        }

       return m1.equals(m3) && m2.equals(m4);



    }
}