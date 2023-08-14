import java.util.*;
import java.io.*;

class Main{
    static int[] arr;
    static boolean[] visited;
    static boolean[] done;
    static int count=0;
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            int n=Integer.parseInt(br.readLine());
            arr=new int[n+1]; visited=new boolean[n+1]; done=new boolean[n+1];
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                arr[j]=Integer.parseInt(st.nextToken());
            }
            for(int j=1; j<=n; j++)
            {
                if(done[j]) continue;
                dfs(j);
            }
            System.out.println(n-count);
            count=0;
        }
    }

    static void dfs(int cur){
        if(done[cur]) return;
        if(visited[cur]){
            done[cur]=true;
            count++;
        }
        visited[cur]=true;
        dfs(arr[cur]);
        done[cur]=true;
        visited[cur]=false;
    }
}