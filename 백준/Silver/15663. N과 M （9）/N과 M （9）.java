import java.util.*;
import java.io.*;

class Main{
    static int n,m;
    static int[] arr=new int[10];
    static StringBuilder sb=new StringBuilder();
    static int[] board;

    static boolean[] visited=new boolean[10001];
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
        func(0);
        System.out.println(sb);

    }
    static void func(int depth){
        if(depth==m){
            for(int i=0; i<m; i++){
                sb.append(arr[i]+" ");
            }
            sb.append("\n");
            return;
        }

        int before=0;
        for(int i=0; i<n; i++){
            if(!visited[i] && before!= board[i]){
                arr[depth]=board[i];
                visited[i]=true;
                before=arr[depth];
                func(depth+1);
                visited[i]=false;
            }
        }

    }
}