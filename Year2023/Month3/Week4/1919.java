
import java.util.*;
import java.io.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int[] alp=new int[26];
        int count=0;

        StringTokenizer st=new StringTokenizer(br.readLine());
        StringTokenizer st2=new StringTokenizer(br.readLine());

        String s1=st.nextToken();
        for(char x : s1.toCharArray()){
            alp[x-'a']++;
        }
        String s2=st2.nextToken();
        for(char x : s2.toCharArray()){
            alp[x-'a']--;
        }

        for(int i=0; i<26; i++){
            count+=Math.abs(alp[i]);
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();



    }
}
