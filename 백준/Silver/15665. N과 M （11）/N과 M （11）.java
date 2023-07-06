import java.util.*;
import java.io.*;

class Main{
    static int n,m;
    static int[] board;
    static int[] arr=new int[10];
    static StringBuilder sb=new StringBuilder();
    static boolean[] visited=new boolean[10];

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        board=new int[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            board[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(board);

        func(0,0);
        System.out.print(sb);

    }
    static void func(int depth, int idx){
        if(depth==m){
            for(int i=0; i<m; i++){
                sb.append(arr[i]+" ");
            }
            sb.append("\n");
            return;
        }

        int before=0;
        for(int i=0; i<n; i++){
            if(before!=board[i]){
                arr[depth]=board[i];
                before=board[i];
                func(depth+1, i);
            }
        }

    }
}