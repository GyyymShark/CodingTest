
import java.util.*;
import java.io.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));



        int n;
        n=Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            Boolean possible=true;
            int[] alp=new int[26];

            String s1=st.nextToken();
            String s2=st.nextToken();

            for(char x : s1.toCharArray()){
                alp[x-'a']++;
            }

            for(char x : s2.toCharArray()){
                alp[x-'a']--;
            }

            for(int k : alp){
                if(k!=0){
                    possible=false;
                    break;
                }
            }

            if(possible)
                bw.write("Possible\n");
            else
                bw.write("Impossible\n");
            bw.flush();

        }
        bw.close();
    }
}
