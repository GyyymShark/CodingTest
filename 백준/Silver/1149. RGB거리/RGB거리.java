import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args)throws IOException{
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st;
       int n=Integer.parseInt(br.readLine());
       int[][] arr=new int[n+1][3];
       int[][] d=new int[n+1][3];


       for(int i=1; i<=n; i++){
           st=new StringTokenizer(br.readLine());
           for(int j=0; j<3; j++){
               arr[i][j]=Integer.parseInt(st.nextToken());
           }
       }


       d[1][0]=arr[1][0];
       d[1][1]=arr[1][1];
       d[1][2]=arr[1][2];

       for(int i=2; i<=n; i++){
           d[i][0]=Math.min(d[i-1][1], d[i-1][2])+arr[i][0];
           d[i][1]=Math.min(d[i-1][0], d[i-1][2])+arr[i][1];
           d[i][2]=Math.min(d[i-1][0], d[i-1][1])+arr[i][2];
       }

       int min=Math.min(d[n][0],d[n][1]);
       min=Math.min(min,d[n][2]);

       System.out.println(min);







    }
}