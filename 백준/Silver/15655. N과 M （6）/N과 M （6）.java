import java.util.*;
import java.io.*;

class Main{
    static int n,m;
    static boolean[] visited=new boolean[10];
    static int[] arr=new int[10];
    static int[] board;
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        board=new int[n];
        for(int i=0; i<n; i++){
            board[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(board);


        func(0, 0);
        System.out.println(sb);
    }

    static void func(int depth,int idx){
        if(depth==m){
            for(int i=0; i<m; i++){
                sb.append(arr[i]+" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=idx; i<n; i++){
            if(!visited[i]){
                visited[i]=true;
                arr[depth]=board[i];
                func(depth+1, i+1);
                visited[i]=false;
            }
        }
    }
}

//1 7 8 9