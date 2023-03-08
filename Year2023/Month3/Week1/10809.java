import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        int alphabet[]=new int[26];
        for(int i=0; i<26; i++){
            alphabet[i]=-1;
        }
        String str=br.readLine();

        for(int i=0; i<str.length(); i++){
            //A 65 Z 90    a 97 z 122
            int idx=(int)str.charAt(i)-97;
            if(alphabet[idx]==-1){
                alphabet[idx]=i;
            }

        }

        for(int i=0; i<26; i++){
            bw.write(alphabet[i]+" ");
        }
        br.close();
        bw.flush();
        bw.close();

    }

}
