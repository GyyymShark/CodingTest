import java.util.*;
import java.io.*;

class Main{
    static int n,m;
    static boolean[] visited=new boolean[10];
    static int[] arr=new int[10];
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        func(0, 1);
        System.out.println(sb);
    }

    static void func(int cur, int val){
        if(cur==m){
            for(int i=0; i<m; i++){
                sb.append(arr[i]+" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=val; i<=n; i++){
            arr[cur]=i;
            func(cur+1, i);
        }
    }
}