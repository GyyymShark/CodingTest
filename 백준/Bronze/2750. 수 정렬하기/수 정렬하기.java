import java.io.*;
import java.util.*;


class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int[] arr=new int[n];

        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for(int i=0; i<n; i++){
            System.out.println(arr[i]);
        }

    }
}