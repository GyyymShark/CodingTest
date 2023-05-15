
import java.util.*;
import java.io.*;


class Main{
    static int n;
    static int cnt=0;
    static boolean[] visited1=new boolean[30];
    static boolean[] visited2=new boolean[30];
    static boolean[] visited3=new boolean[30];
    static int[][] board;

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        board=new int[n][n];
        func(0);
        System.out.println(cnt);
    }

    static void func(int cur){
        if(cur==n){
            cnt++;
            return;
        }


            for(int j=0; j<n; j++){
                if(!visited1[j] && !visited2[cur+j] && !visited3[cur-j+n-1]){
                    visited1[j]=true;
                    visited2[cur+j]=true;
                    visited3[cur-j+n-1]=true;
                    func(cur+1);
                    visited1[j]=false;
                    visited2[cur+j]=false;
                    visited3[cur-j+n-1]=false;
                }


        }

    }

}