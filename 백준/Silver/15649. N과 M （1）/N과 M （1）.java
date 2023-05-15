

import java.util.*;
import java.io.*;


class Main{

    static int n,m;
    static int[] arr=new int[10];
    static boolean[] visited=new boolean[10];

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        func(0);
    }

    static void func(int k){
        if(k==m){
            for(int i=0; i<m; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i]=true;
                arr[k]=i+1;
                func(k+1);
                visited[i]=false;
            }
        }

    }
}