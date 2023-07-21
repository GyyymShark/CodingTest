import java.util.*;
import java.io.*;


class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        String[] str=new String[n];

        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            str[i]=(st.nextToken());
        }

        Comparator<String> comparator=new Comparator<String>(){
          @Override
          public int compare(String s1, String s2){
              int s1Sum=0, s2Sum=0;

             if(s1.length()!=s2.length()){
                 return s1.length()-s2.length();
             }
             else{
                 for(char ch : s1.toCharArray()){
                     if('0'<=ch && ch<='9')
                         s1Sum+=ch-'0';
                 }
                 for(char ch : s2.toCharArray()){
                     if('0'<=ch && ch<='9')
                         s2Sum+=ch-'0';
                 }
                 if(s1Sum!=s2Sum){
                     return s1Sum-s2Sum;
                 }
                 else{
                     return s1.compareTo(s2);
                 }
             }

          }
        };

        Arrays.sort(str,comparator);

        for(String sttt : str){
            System.out.println(sttt);
        }



    }
}