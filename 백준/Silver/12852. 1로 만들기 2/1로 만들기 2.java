import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();


        int[] d=new int[n+1];
        int[] back=new int[n+1];
        
   

        for(int i=2; i<=n; i++){
            d[i]=d[i-1]+1;
            back[i]=i-1;

            if(i%2==0){
                if(d[i/2]+1<d[i]){
                    d[i]=d[i/2]+1;
                    back[i]=i/2;
                }
            }


            if(i%3==0){
                if(d[i/3]+1<d[i]){
                    d[i]=d[i/3]+1;
                    back[i]=i/3;
                }
            }
        }


        System.out.println(d[n]);
        int idx=n;
        while(back[idx]!=0){
            sb.append(idx+" ");
            idx=back[idx];
        }
        sb.append(1);

        System.out.println(sb);

    }
}