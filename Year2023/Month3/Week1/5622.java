

import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int sum=0;
        String dial=br.readLine();

        for(int i=0; i<dial.length(); i++){
            char ch=dial.charAt(i);
            if('A'<=ch && ch<='C'){
                sum+=3;
            }

            else if('D'<=ch && ch<='F'){
                sum+=4;
            }
            else if('G'<=ch && ch<='I'){
                sum+=5;
            }
            else if('J'<=ch && ch<='L'){
                sum+=6;
            }
            else if('M'<=ch && ch<='O'){
                sum+=7;
            }
            else if('P'<=ch && ch<='S'){
                sum+=8;
            }
            else if('T'<=ch && ch<='V'){
                sum+=9;
            }
            else if('W'<=ch && ch<='Z'){
                sum+=10;
            }
        }


        //  bw.write(sum);
        br.close();
        System.out.println(sum);
        bw.flush();
        bw.close();


    }
}
