import java.util.*;
import java.io.*;



class Main{
    public static void main(String[] args)throws IOException{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int[] arr=new int[n+1];
        int[] d=new int[n+1];
        st=new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        d[1]=arr[1];
        for(int i=2; i<=n; i++){
            d[i]=arr[i]+d[i-1];
        }

   
        for(int j=0; j<m; j++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());

            start--;
            System.out.println(d[end]-d[start]);
        }





    }
}