import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{
        int[] alphabet= new int[26];
        int max=0, maxcount=0,maxidx=0;
        for(int i=0; i<26; i++){
            alphabet[i]=0;
        }
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        StringTokenizer st;
        //  st=new StringTokenizer(br.readLine());
        for(int i=0; i<str.length(); i++){
            int ascii= (int)str.charAt(i);
            if(65<=ascii && ascii <=90){
                alphabet[ascii-65]++;
            }
            else if(97<= ascii && ascii <=122) {
                alphabet[ascii-97]++;
            }
        }
        max=alphabet[0];
        for(int i=1; i<26; i++){
            if(alphabet[i]>max){
                max=alphabet[i];
                maxidx=i;
            }
        }
        for(int i=0; i<26; i++){
            if(alphabet[i]==max){
                ++maxcount;
            }
        }
        if(maxcount>=2){
            System.out.println("?");
        }
        else if(maxcount==1){
            System.out.println((char)(maxidx+65));
        }
//A 65 Z 90 a 97 z 122

    }
}
