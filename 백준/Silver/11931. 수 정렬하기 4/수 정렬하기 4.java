import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();



        int n=Integer.parseInt(st.nextToken());
        Integer[] arr=new Integer[n];


        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            arr[i]=Integer.parseInt(st.nextToken());
        }


        Arrays.sort(arr, Collections.reverseOrder());


        for(int i=0; i<n; i++){
            sb.append(arr[i]);
            sb.append("\n");
        }

        System.out.print(sb);



    }
}